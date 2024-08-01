package com.example.domain.repository

import com.example.domain.entities.Community
import com.example.domain.entities.CommunityDetails

interface ICommunityRepository {
    fun getAllCommunity(): List<Community>

    fun getDetailsCommunity(): CommunityDetails
}
