package com.example.wbtechnoschool.di

import com.example.domain.usecases.GetAllCommunityUseCase
import com.example.domain.usecases.GetCommunityProfileUseCase
import com.example.domain.usecases.GetDataProfileUseCase
import com.example.domain.usecases.GetDescriptionMeetingsUseCase
import com.example.domain.usecases.GetDetailsCommunityUseCase
import com.example.domain.usecases.GetMeetingsUseCase
import com.example.domain.usecases.GetPersonsInfoUseCase
import com.example.domain.usecases.SaveCommunityUseCase
import org.koin.dsl.module

val domainModule =  module {
    factory { GetAllCommunityUseCase(repository = get()) }
    factory { GetCommunityProfileUseCase(repository = get()) }
    factory { GetDataProfileUseCase(repository = get()) }
    factory { GetDescriptionMeetingsUseCase(repository = get()) }
    factory { GetDetailsCommunityUseCase(repository = get()) }
    factory { GetMeetingsUseCase(repository = get()) }
    factory { GetPersonsInfoUseCase(repository = get()) }
    factory { SaveCommunityUseCase(repository = get()) }
}