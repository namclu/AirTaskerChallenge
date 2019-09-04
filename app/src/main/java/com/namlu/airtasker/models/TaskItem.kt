package com.namlu.airtasker.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
* Model for a single task item
* Sample:
* {
    "id": 4,
    "name": "Mystery Shopper Rockdale NSW",
    "description": "1. Visit a shop anonymously as an \"undercover customer.\"
    \n2. Make two short enquiries in the same shop.
    \n3. Fill in a questionnaire. \n4. Report by phone.",
    "state": "assigned",
    "poster_id": 2,
    "worker_id": 3
}
* */
data class TaskItem(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("state")
    val state: String,
    @Expose
    @SerializedName("poster_id")
    val poster_id: Int,
    @Expose
    @SerializedName("worker_id")
    val worker_id: Int
)