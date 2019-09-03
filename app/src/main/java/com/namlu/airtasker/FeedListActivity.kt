package com.namlu.airtasker

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.namlu.airtasker.models.FeedItem
import com.namlu.airtasker.models.ProfileItem
import com.namlu.airtasker.models.TaskItem
import com.namlu.airtasker.requests.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class FeedListActivity : BaseActivity() {

    private lateinit var buttonTest: Button

    companion object{
        const val TAG = "FeedListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_list)

        buttonTest = findViewById(R.id.button_test)

        // test showProgressBar()
        buttonTest.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
//                testFeedItemResponse()
//                testTaskItemResponse()
                testProfileItemResponse()
            }

        })
    }

    // Get a list of feed items
    fun testFeedItemResponse() {
        val feedItemApi = ServiceGenerator.getFeedItemApi()

        val responseCall: Call<List<FeedItem>> = feedItemApi.getFeedItems()

        responseCall.enqueue(object: Callback<List<FeedItem>> {
            override fun onFailure(call: Call<List<FeedItem>>, t: Throwable) {
                Log.e(TAG, "onResponse: ERROR: " + t.message)
            }

            override fun onResponse(call: Call<List<FeedItem>>, response: Response<List<FeedItem>>) {
                Log.d(TAG, "responseCall: $response")
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                    for (item in response.body().orEmpty()) {
                        Log.d(TAG, "onResponse: ${item.profile_id}")
                    }
                } else {
                    try {
                        Log.e(TAG, "onResponse: ${response.errorBody()}")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }

    // Get a task item
    fun testTaskItemResponse() {
        val feedItemApi = ServiceGenerator.getFeedItemApi()

        val responseCall: Call<TaskItem> = feedItemApi.getTaskItem(4)

        responseCall.enqueue(object : Callback<TaskItem> {
            override fun onFailure(call: Call<TaskItem>, t: Throwable) {
                Log.e(TAG, "onResponse: ERROR: " + t.message)
            }

            override fun onResponse(call: Call<TaskItem>, response: Response<TaskItem>) {
                Log.d(TAG, "responseCall: $response")
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                } else {
                    try {
                        Log.e(TAG, "onResponse: ${response.errorBody()}")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }

    // Get a profile item
    fun testProfileItemResponse() {
        val feedItemApi = ServiceGenerator.getFeedItemApi()

        val responseCall: Call<ProfileItem> = feedItemApi.getProfileItem(1)

        responseCall.enqueue(object : Callback<ProfileItem> {
            override fun onFailure(call: Call<ProfileItem>, t: Throwable) {
                Log.e(TAG, "onResponse: ERROR: " + t.message)
            }

            override fun onResponse(call: Call<ProfileItem>, response: Response<ProfileItem>) {
                Log.d(TAG, "responseCall: $response")
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                } else {
                    try {
                        Log.e(TAG, "onResponse: ${response.errorBody()}")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        })
    }
}
