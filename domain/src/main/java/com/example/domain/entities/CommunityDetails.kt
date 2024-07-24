package com.example.domain.entities

data class CommunityDetails (
    val id: Int,
    val title: String,
    val detailsCommunity: String,
    val meetingsCommunity: List<Meetings>
)