package com.namlu.airtasker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.namlu.airtasker.R
import com.namlu.airtasker.models.FeedItemViewState
import kotlinx.android.synthetic.main.feed_list_item.view.*
import java.text.SimpleDateFormat

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
        val feedText = itemView.text_feed_text
        val createdAt = itemView.text_created_at
        val event = itemView.text_event

        // Format the date/time
        var inFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        var outFormat = SimpleDateFormat("EE HH:mma")

        fun bind(viewState: FeedItemViewState) {
            var formattedDate = inFormat.parse(viewState.feedItem.created_at)

            feedText.text = viewState.taskText + " " + viewState.profileItem?.avatar_mini_url + " - Hello"
            createdAt.text = outFormat.format(formattedDate)
            event.text = viewState.event
        }
    }
}