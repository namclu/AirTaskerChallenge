package com.namlu.airtasker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.namlu.airtasker.R
import com.namlu.airtasker.models.FeedItem
import com.namlu.airtasker.models.FeedItemViewState
import kotlinx.android.synthetic.main.feed_list_item.view.*

class FeedItemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var feedItem: List<FeedItem> = ArrayList()

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

//        val item = feedItem[position]
//
//        var view = holder.itemView
//
//        if (item.feedItem.task_text!!.isNotEmpty()) {
//            view.text_feed_text.text = item.taskText
//        } else {
//            view.text_feed_text.text = "No text"
//        }
    }

    fun setFeedItems(feeds: List<FeedItem>) {
        feedItem = feeds
        notifyDataSetChanged()
    }

    class FeedItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val feedText = itemView.text_feed_text
        val createdAt = itemView.text_created_at
        val event = itemView.text_event

        fun bind(feedItem: FeedItem) {
            feedText.text = feedItem.task_text
            createdAt.text = feedItem.created_at
            event.text = feedItem.event
        }
    }
}