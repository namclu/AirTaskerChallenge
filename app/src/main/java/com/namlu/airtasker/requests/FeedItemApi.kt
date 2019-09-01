package com.namlu.airtasker.requests

import com.namlu.airtasker.models.FeedItem
import com.namlu.airtasker.models.TaskItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/*
* Contains all requests for AirTasker's Api
* */
interface FeedItemApi {

    // Get a list of feed items
    // https://stage.airtasker.com/android-code-test/feed.json
    @GET("android-code-test/feed.json")
    fun getFeedItems(): Call<List<FeedItem>>

    // Get a task item
    // https://stage.airtasker.com/android-code-test/task/4.json
    @GET("android-code-test/task/{id}.json")
    fun getTaskItem(
        @Path("id") id: Int
    ): Call<TaskItem>
}