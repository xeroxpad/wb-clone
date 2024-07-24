package com.example.data.repository.di

import com.example.data.repository.ICommunityRepository
import com.example.data.repository.IMeetingsRepository
import com.example.data.repository.IProfileRepository
import com.example.domain.repository.CommunityRepository
import com.example.domain.repository.MeetingsRepository
import com.example.domain.repository.ProfileRepository
import org.koin.dsl.module

val dataModule = module {
    single <ProfileRepository> { IProfileRepository() }
    single <MeetingsRepository> { IMeetingsRepository() }
    single <CommunityRepository> { ICommunityRepository() }
}