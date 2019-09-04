package com.namlu.airtasker.models

/*
* Data model which is a composite of FeedItem, ProfileItem, and TaskItem
* */
data class FeedItemViewState(
    val feedItem: FeedItem,
    val profileItem: ProfileItem? = null,
    val taskItem: TaskItem? = null
) {
    val taskText = feedItem.task_text
    val createAt = feedItem.created_at
    val event = feedItem.event
}
