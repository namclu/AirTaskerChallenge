package com.namlu.airtasker.requests

import com.namlu.airtasker.util.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/*
* Generates an implementation of the TaskApi interface
* */
class ServiceGenerator {

    companion object {
        fun getApi() : FeedItemApi {
            val retrofitBuilder = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

            val retrofit = retrofitBuilder.build()

            return retrofit.create(FeedItemApi::class.java)
        }
    }
}

