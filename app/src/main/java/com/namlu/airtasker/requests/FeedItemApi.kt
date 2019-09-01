package com.namlu.airtasker.requests

import com.namlu.airtasker.models.FeedItem
import retrofit2.Call
import retrofit2.http.GET

/*
* Contains all requests for AirTasker's Api
* */
interface FeedItemApi {

    // Get a list of feed items
    // https://stage.airtasker.com/android-code-test/feed.json
    @GET("android-code-test/feed.json")
    fun getFeedItems(): Call<List<FeedItem>>
}