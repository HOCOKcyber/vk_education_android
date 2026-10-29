package com.example.vk_education_android.data

import com.example.vk_education_android.domain.AppDetails
import com.example.vk_education_android.domain.AppDetailsRepository
import com.example.vk_education_android.domain.Category

class AppDetailsRepositoryImpl: AppDetailsRepository {
    override fun get() = listOf(
        AppDetails(
            id = "0",
            name = "WhatsApp Messenger",
            developer = "WhatsApp LLC",
            category = Category.SOCIAL,
            ageRating = 3,
            size = 62.4f,
            iconUrl = "https://www.google.com/s2/favicons?domain=whatsapp.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Simple, reliable, and private messaging and calling for free."
        ),
        AppDetails(
            id = "1",
            name = "Instagram",
            developer = "Instagram",
            category = Category.SOCIAL,
            ageRating = 12,
            size = 54.8f,
            iconUrl = "https://www.google.com/s2/favicons?domain=instagram.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Share photos, reels, and stories with friends and the world."
        ),
        AppDetails(
            id = "2",
            name = "Telegram",
            developer = "Telegram FZ-LLC",
            category = Category.SOCIAL,
            ageRating = 12,
            size = 48.2f,
            iconUrl = "https://www.google.com/s2/favicons?domain=telegram.org&sz=128",
            screenshotUrlList = listOf(),
            description = "Fast and secure messaging with cloud-based chats and channels."
        ),
        AppDetails(
            id = "3",
            name = "Spotify",
            developer = "Spotify AB",
            category = Category.MUSIC,
            ageRating = 12,
            size = 35.7f,
            iconUrl = "https://www.google.com/s2/favicons?domain=spotify.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Listen to millions of songs, podcasts, and playlists for free."
        ),
        AppDetails(
            id = "4",
            name = "YouTube",
            developer = "Google LLC",
            category = Category.VIDEO,
            ageRating = 12,
            size = 88.3f,
            iconUrl = "https://www.google.com/s2/favicons?domain=youtube.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Watch videos, music, live streams, and subscribe to creators."
        ),
        AppDetails(
            id = "5",
            name = "Google Maps",
            developer = "Google LLC",
            category = Category.MAPS,
            ageRating = 3,
            size = 72.1f,
            iconUrl = "https://www.google.com/s2/favicons?domain=maps.google.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Navigate the world with real-time traffic, transit, and local guides."
        ),
        AppDetails(
            id = "6",
            name = "Netflix",
            developer = "Netflix, Inc.",
            category = Category.ENTERTAINMENT,
            ageRating = 12,
            size = 42.5f,
            iconUrl = "https://www.google.com/s2/favicons?domain=netflix.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Stream award-winning series, films, and documentaries on any device."
        ),
        AppDetails(
            id = "7",
            name = "Slack",
            developer = "Slack Technologies",
            category = Category.BUSINESS,
            ageRating = 12,
            size = 68.9f,
            iconUrl = "https://www.google.com/s2/favicons?domain=slack.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Organize your team's communication and collaboration in one place."
        ),
        AppDetails(
            id = "8",
            name = "Duolingo",
            developer = "Duolingo",
            category = Category.EDUCATION,
            ageRating = 3,
            size = 28.6f,
            iconUrl = "https://www.google.com/s2/favicons?domain=duolingo.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Learn languages for free with fun, bite-sized lessons and streaks."
        ),
        AppDetails(
            id = "9",
            name = "Gmail",
            developer = "Google LLC",
            category = Category.PRODUCTIVITY,
            ageRating = 3,
            size = 51.3f,
            iconUrl = "https://www.google.com/s2/favicons?domain=gmail.com&sz=128",
            screenshotUrlList = listOf(),
            description = "Fast, secure email with smart features and seamless organization."
        )
    )

}
