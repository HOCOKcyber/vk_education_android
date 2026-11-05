package com.example.vk_education_android.utils

import com.example.vk_education_android.domain.AppDetails
import com.example.vk_education_android.domain.Category
import com.example.vk_education_android.domain.SimilarApp

object MockData {
    fun getMockSimilarApps() = List(15) { index ->
        SimilarApp(
            id = "similar-app-$index",
            name = "Гильдия Героев: Экшен ММО РПГ: $index",
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        )
    }

    fun getMockShowcase() = listOf(
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

    fun getMockScreenshotUrlList() = listOf(
        "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
        "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
        "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
        "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
    )
}