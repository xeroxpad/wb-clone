package com.example.wbtechnoschool.navigation

sealed class Graph(
    val route: String,
) {
    private companion object {
        const val screenMeetingsRoot = "screen_meeting_root"
        const val screenCommunityRoot = "screen_community_root"
        const val screenInfoRoot = "screen_info_root"
        const val screenMeeting = "screen_meeting"
        const val screenCommunity = "screen_community"
        const val screenInfo = "screen_info"
        const val screenProfile = "screen_profile"
        const val screenMyMeetings = "screen_my_meetings"
        const val screenTheme = "screen_theme"
        const val screenNotifications = "screen_notifications"
        const val screenSafety = "screen_safety"
        const val screenResources = "screen_resources"
        const val screenHelp = "screen_help"
        const val inviteFriend = "screen_invite_friend"
        const val screenDetailsCommunity = "screen_details_community"
        const val screenDescriptionMeeting = "screen_description_meeting"
        const val splashScreen = "splash_screen"
        const val screenAuthorizationProfile = "screen_authorization_profile"
        const val screenAuthorization = "screen_authorization"
        const val screenEntryCode = "screen_entry_code"
        const val screenSplashHelloName = "screen_splash_hello_name"
    }

    data object Meetings : Graph(screenMeeting)
    data object Community : Graph(screenCommunity)
    data object Info : Graph(screenInfo)
    data object Profile : Graph(screenProfile)
    data object MyMeetings : Graph(screenMyMeetings)
    data object Theme : Graph(screenTheme)
    data object Notifications : Graph(screenNotifications)
    data object Safety : Graph(screenSafety)
    data object Resources : Graph(screenResources)
    data object Help : Graph(screenHelp)
    data object Friend : Graph(inviteFriend)
    data object DetailsCommunity : Graph(screenDetailsCommunity)
    data object DescriptionMeeting : Graph(screenDescriptionMeeting)
    data object Splash : Graph(splashScreen)
    data object AuthorizationProfile : Graph(screenAuthorizationProfile)
    data object Authorization : Graph(screenAuthorization)
    data object EntryCode : Graph(screenEntryCode)
    data object SplashHelloName : Graph(screenSplashHelloName)

    data object MeetingsRoot : Graph(screenMeetingsRoot) {
        data object AllMeetings : Graph(screenMeeting)
        data object DescriptionMeetings : Graph(screenDescriptionMeeting)
    }

    data object CommunityRoot : Graph(screenCommunityRoot) {
        data object AllCommunity : Graph(screenCommunity)
        data object DetailsCommunity : Graph(screenDetailsCommunity)
    }

    data object InfoRoot : Graph(screenInfoRoot) {
        data object AllInfo : Graph(screenInfo)
        data object MyProfile : Graph(screenProfile)
        data object MyMeetings : Graph(screenMyMeetings)
        data object MyTheme : Graph(screenTheme)
        data object MyNotifications : Graph(screenNotifications)
        data object MySafety : Graph(screenSafety)
        data object MyResources : Graph(screenResources)
        data object MyHelp : Graph(screenHelp)
        data object MyInviteFriend : Graph(inviteFriend)
    }
}