package com.example.domain.entities

data class MeetingsDescription(
    val id: Int,
    val title: String,
    val dateAndLocation: String,
    val tags: List<String>,
    val map: String,
    val description: String,
    val rowAvatars: List<String>,
)

data class FixMeetingsDescription(
    val idMeeting: Int,
    val titleMeeting: String,
    val avatarUrlMeeting: String?,
    val dateMeeting: String,
    val timeMeeting: String,
    val locationMeeting: String,
    val tagsMeeting: String,
    val descriptionMeeting: String,
    val leaderMeeting: String,
    val leaderInfoMeeting: String,
    val leaderAvatar: String?,
    val iconMetroStation: String?,
    val titleMetroStation: String?,
    val mapMeeting: String,
    val visitorsMeeting: List<String>,
    val titleCommunityMeeting: String,
    val descriptionCommunityMeeting: String,
    val iconCommunityMeeting: String?,
    var isSubscribedCommunity: Boolean,
    val otherMeetingCommunity: FixEvent,
)