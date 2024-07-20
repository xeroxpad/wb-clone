package com.example.wbtechnoschool.di

import com.example.data.RepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single { RepositoryImpl() }
}