package com.example.wbtechnoschool.di

import com.example.data.repository.ICommunityRepository
import com.example.data.repository.IMeetingsRepository
import com.example.data.repository.IProfileRepository
import org.koin.dsl.module

val dataModule = module {
    single { IProfileRepository() }
    single { IMeetingsRepository() }
    single { ICommunityRepository() }
}