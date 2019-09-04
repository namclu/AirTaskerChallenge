package com.namlu.airtasker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import com.namlu.airtasker.R
import com.namlu.airtasker.models.FeedItemViewState
import com.namlu.airtasker.util.Constants
import kotlinx.android.synthetic.main.feed_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FeedItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var feedItem: List<FeedItemViewState> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feed_list_item, parent, false)
        return FeedItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return feedItem.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FeedItemViewHolder -> holder.bind(feedItem[position])
        }
    }

    fun setFeedItems(feeds: List<FeedItemViewState>) {
        feedItem = feeds
        notifyDataSetChanged()
    }

    class FeedItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage = itemView.image_profile
        val feedText = itemView.text_feed_text
        val createdAt = itemView.text_created_at
        val event = itemView.text_event

        // Format the date/time
        var inFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault())
        var outFormat = SimpleDateFormat("EE HH:mma", Locale.getDefault())

        fun bind(viewState: FeedItemViewState) {
            val formattedDate = inFormat.parse(viewState.feedItem.created_at)
            val imageUrl = Constants.BASE_URL + Constants.ANDROID_CODE_TEST_URL + viewState.profileItem?.avatar_mini_url

            // Replace "{profileName} w name from profile and {taskName}" w take name in " "
            val json = Gson().toJson(viewState.taskText)
            val newJson = json.replace("\"{profileName}", viewState.profileItem?.first_name.toString())
                .replace("{taskName}\"", "\"${viewState.taskItem?.name.toString()}\"")


            feedText.text = newJson
            createdAt.text = outFormat.format(formattedDate)
            event.text = viewState.event

            // Load image
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(imageUrl)
                .into(profileImage)
        }
    }
}