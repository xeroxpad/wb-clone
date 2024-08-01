package com.example.domain.di

import com.example.domain.usecases.GetAllCommunityUseCase
import com.example.domain.usecases.GetDataProfileUseCase
import com.example.domain.usecases.GetDescriptionMeetingsUseCase
import com.example.domain.usecases.GetDetailsCommunityUseCase
import com.example.domain.usecases.GetMeetingsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule =
    module {
        factoryOf(::GetAllCommunityUseCase)
        factoryOf(::GetDataProfileUseCase)
        factoryOf(::GetDescriptionMeetingsUseCase)
        factoryOf(::GetDetailsCommunityUseCase)
        factoryOf(::GetMeetingsUseCase)
    }
