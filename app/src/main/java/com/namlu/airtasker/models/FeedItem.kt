package com.namlu.airtasker.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
* Model for a single feed item
* Sample:
* {
    "task_id": 4,
    "profile_id": 2,
    "text": "{profileName} posted {taskName}",
    "created_at": "2015-06-26T12:03:29+10:00",
    "event": "post"
  }
* */
data class FeedItem(
    @Expose
    @SerializedName("task_id")
    val task_id: Int,
    @Expose
    @SerializedName("profile_id")
    val profile_id: Int,
    @Expose
    @SerializedName("text")
    val task_text: String,
    @Expose
    @SerializedName("created_at")
    val created_at: String,
    @Expose
    @SerializedName("event")
    val event: String
)
