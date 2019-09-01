package com.namlu.airtasker.requests

import com.namlu.airtasker.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Generates an implementation of the TaskApi interface
* */
class ServiceGenerator {

    companion object {
        private val retrofitBuilder = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        private val retrofit = retrofitBuilder.build()

        private val feedItemApi = retrofit.create(FeedItemApi::class.java)

        fun getFeedItemApi(): FeedItemApi {
            return feedItemApi
        }
    }
}

