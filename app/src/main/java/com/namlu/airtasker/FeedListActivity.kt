package com.namlu.airtasker

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.namlu.airtasker.requests.ServiceGenerator
import com.namlu.airtasker.requests.responses.FeedItemResponse
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
                Log.d(TAG, "onClick() called")
                testRetrofitRequest()
            }

        })
    }

    fun testRetrofitRequest() {
        val feedItemApi = ServiceGenerator.getFeedItemApi()

        // Get a list of feed items
        val responseCall: Call<FeedItemResponse> = feedItemApi.getFeedItems()

        responseCall.enqueue(object: Callback<FeedItemResponse> {
            override fun onFailure(call: Call<FeedItemResponse>, t: Throwable) {
                Log.e(TAG, "onResponse: ERROR: " + t.message)
            }

            override fun onResponse(call: Call<FeedItemResponse>, response: Response<FeedItemResponse>) {
                Log.d(TAG, "responseCall: $response")
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                    val feedItems  = ArrayList(response.body()?.getFeedItems())
                    for (feedItem in feedItems) {
                        Log.d(TAG, "onResponse: ${feedItem.profile_id}")
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
}
