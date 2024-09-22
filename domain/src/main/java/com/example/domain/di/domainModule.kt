package com.example.domain.di

import com.example.domain.usecases.GetCommunityUseCase
import com.example.domain.usecases.GetDataProfileUseCase
import com.example.domain.usecases.GetDescriptionMeetingsUseCase
import com.example.domain.usecases.GetDetailsCommunityUseCase
import com.example.domain.usecases.GetMeetingsUseCase
import com.example.domain.usecases.VerifyPhoneNumberUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule =
    module {
        factoryOf(::GetCommunityUseCase)
        factoryOf(::GetDataProfileUseCase)
        factoryOf(::GetDescriptionMeetingsUseCase)
        factoryOf(::GetDetailsCommunityUseCase)
        factoryOf(::GetMeetingsUseCase)
        factoryOf(::VerifyPhoneNumberUseCase)
    }
