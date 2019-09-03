package com.namlu.airtasker.models

import android.os.Parcel
import android.os.Parcelable
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
    val name: String?,
    @Expose
    @SerializedName("description")
    val description: String?,
    @Expose
    @SerializedName("state")
    val state: String?,
    @Expose
    @SerializedName("poster_id")
    val poster_id: Int,
    @Expose
    @SerializedName("worker_id")
    val worker_id: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<TaskItem> {
        override fun createFromParcel(parcel: Parcel): TaskItem {
            return TaskItem(parcel)
        }

        override fun newArray(size: Int): Array<TaskItem?> {
            return arrayOfNulls(size)
        }
    }
}