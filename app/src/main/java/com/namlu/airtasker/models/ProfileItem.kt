package com.namlu.airtasker.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
* Model for a single profile item
* Sample
* {
    "id": 1,
    "avatar_mini_url": "/img/5.jpg",
    "first_name": "William",
    "rating": 4
}
* */
data class ProfileItem(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("avatar_mini_url")
    val avatar_mini_url: String,
    @Expose
    @SerializedName("first_name")
    val first_name: String,
    @Expose
    @SerializedName("rating")
    val rating: Int
)