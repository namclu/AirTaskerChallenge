package com.namlu.airtasker.models

import android.os.Parcel
import android.os.Parcelable
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
    val avatar_mini_url: String?,
    @Expose
    @SerializedName("first_name")
    val first_name: String?,
    @Expose
    @SerializedName("rating")
    val rating: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(avatar_mini_url)
        parcel.writeString(first_name)
        parcel.writeInt(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProfileItem> {
        override fun createFromParcel(parcel: Parcel): ProfileItem {
            return ProfileItem(parcel)
        }

        override fun newArray(size: Int): Array<ProfileItem?> {
            return arrayOfNulls(size)
        }
    }
}