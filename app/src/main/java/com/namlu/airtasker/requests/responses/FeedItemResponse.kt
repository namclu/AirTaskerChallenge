package com.namlu.airtasker.requests.responses

import com.google.gson.annotations.Expose
import com.namlu.airtasker.models.FeedItem

class FeedItemResponse {

    @Expose
    private val feedItems: List<FeedItem>? = null

    fun getFeedItems(): List<FeedItem>? {
        return feedItems
    }

    override fun toString(): String {
        return "FeedItemResponse(feedItems=$feedItems)"
    }
}