package com.namlu.airtasker.models

import android.os.Parcel
import android.os.Parcelable
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
    @SerializedName("task_id")
    val task_id: Int,
    @SerializedName("profile_id")
    val profile_id: Int,
    @SerializedName("text")
    val task_text: String?,
    @SerializedName("created_at")
    val created_at: String?,
    @SerializedName("event")
    val event: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(task_id)
        parcel.writeInt(profile_id)
        parcel.writeString(task_text)
        parcel.writeString(created_at)
        parcel.writeString(event)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "FeedItem(" +
                "task_id=$task_id, " +
                "profile_id=$profile_id, " +
                "task_text=$task_text, " +
                "created_at=$created_at, " +
                "event=$event)"
    }

    companion object CREATOR : Parcelable.Creator<FeedItem> {
        override fun createFromParcel(parcel: Parcel): FeedItem {
            return FeedItem(parcel)
        }

        override fun newArray(size: Int): Array<FeedItem?> {
            return arrayOfNulls(size)
        }
    }
}
