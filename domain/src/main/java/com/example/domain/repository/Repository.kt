package com.example.domain.repository

import com.example.domain.entities.Community
import com.example.domain.entities.Meetings

interface Repository {
    fun getAllCommunity(): List<Community>
    fun getDetailsCommunity(id: Int)
    fun saveCommunity()

    fun getMeetings(): Meetings
    fun getDescriptionMeetings(id: Int)

    fun getDataProfileUseCase()
    fun getCommunityProfile(): List<Community>
}