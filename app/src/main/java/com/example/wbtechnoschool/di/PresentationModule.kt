package com.example.wbtechnoschool.di

import com.example.data.repository.ICommunityRepository
import com.example.data.repository.IMeetingsRepository
import com.example.data.repository.IProfileRepository
import com.example.domain.repository.CommunityRepository
import com.example.domain.repository.MeetingsRepository
import com.example.domain.repository.ProfileRepository
import com.example.wbtechnoschool.screens.meetings.AllMeetings
import com.example.wbtechnoschool.viewmodel.auth_view_model.AuthorizationProfileViewModel
import com.example.wbtechnoschool.viewmodel.auth_view_model.AuthorizationViewModel
import com.example.wbtechnoschool.viewmodel.auth_view_model.EntryCodeViewModel
import com.example.wbtechnoschool.viewmodel.community_view_model.CommunityViewModel
import com.example.wbtechnoschool.viewmodel.community_view_model.DetailsCommunityViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.DescriptionMeetingViewModel
import com.example.wbtechnoschool.viewmodel.meetings_view_model.MeetingViewModel
import com.example.wbtechnoschool.viewmodel.more_view_model.my_meetings_view_model.MyMeetingsViewModel
import com.example.wbtechnoschool.viewmodel.more_view_model.profile_view_model.ProfileViewModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single<CommunityRepository> { ICommunityRepository() }
    single<MeetingsRepository> { IMeetingsRepository() }
    single<ProfileRepository> { IProfileRepository() }
    viewModel { AuthorizationViewModel() }
    viewModel { EntryCodeViewModel() }
    viewModel { AuthorizationProfileViewModel() }
    viewModel { CommunityViewModel(get()) }
    viewModel { DetailsCommunityViewModel(get()) }
    viewModel { DescriptionMeetingViewModel(get()) }
    viewModel { MeetingViewModel(get()) }
    viewModel { MyMeetingsViewModel() }
    viewModel { ProfileViewModule(get()) }
}