package com.example.data.repository.di

import com.example.data.repository.CommunityRepositoryImpl
import com.example.data.repository.GalleryRepositoryImpl
import com.example.data.repository.MeetingsRepositoryImpl
import com.example.data.repository.ProfileRepositoryImpl
import com.example.data.repository.UserAuthRepositoryImpl
import com.example.domain.repository.ICommunityRepository
import com.example.domain.repository.IGalleryRepository
import com.example.domain.repository.IMeetingsRepository
import com.example.domain.repository.IProfileRepository
import com.example.domain.repository.IUserAuthRepository
import org.koin.dsl.module

val dataModule =
    module {
        single<IProfileRepository> { ProfileRepositoryImpl() }
        single<IMeetingsRepository> { MeetingsRepositoryImpl() }
        single<ICommunityRepository> { CommunityRepositoryImpl() }
        single<IUserAuthRepository> { UserAuthRepositoryImpl() }
        single<IGalleryRepository> { GalleryRepositoryImpl(get()) }
    }
