package com.namlu.airtasker.requests

import com.namlu.airtasker.models.FeedItem
import com.namlu.airtasker.models.ProfileItem
import com.namlu.airtasker.models.TaskItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/*
* Contains all requests for AirTasker's Api
* */
interface FeedItemApi {

   // Get a list of feed items
    // https://stage.airtasker.com/android-code-test/feed.json
    @GET("android-code-test/feed.json")
    fun getFeedItemsObservable(): Observable<List<FeedItem>>

    // Get a task item
    // https://stage.airtasker.com/android-code-test/task/4.json
    @GET("android-code-test/task/{id}.json")
    fun getTaskItemObservable(
        @Path("id") id: Int
    ): Observable<TaskItem>

    //  Get a profile item
    // https://stage.airtasker.com/android-code-test/profile/1.json
    @GET("android-code-test/profile/{id}.json")
    fun getProfileItemObservable(
        @Path("id") id: Int
    ) : Observable<ProfileItem>
}