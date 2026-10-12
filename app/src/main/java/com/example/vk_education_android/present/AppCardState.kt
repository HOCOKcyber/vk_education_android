package com.example.vk_education_android.present

import androidx.annotation.DrawableRes
import com.example.vk_education_android.R

data class AppCardState(
    @DrawableRes val iconRes: Int,
    val appName: String,
    val category: String,
    val description: String
)

fun getAppCards(): List<AppCardState> = listOf(
    AppCardState(
        iconRes = R.drawable.firefox_svgrepo_com,
        appName = "Firefox",
        category = "браузер",
        description = "Очень крутого приложения"
    ),
    AppCardState(
        iconRes = R.drawable.calculator_svgrepo_com,
        appName = "Калькулятор",
        category = "инструменты",
        description = "Очень крутого приложения"
    ),
    AppCardState(
        iconRes = R.drawable.python_svgrepo_com,
        appName = "Python",
        category = "инструменты",
        description = "Очень не крутого приложения"
    ),
    AppCardState(
        iconRes = R.drawable.phone_svgrepo_com,
        appName = "Телефон",
        category = "инструменты",
        description = "Очень крутого приложения"
    ),
    AppCardState(
        iconRes = R.drawable.gallery_round_svgrepo_com,
        appName = "Галерея",
        category = "инструменты",
        description = "Очень крутого приложения"
    ),
    AppCardState(
        iconRes = R.drawable.telegram_svgrepo_com,
        appName = "Telegram",
        category = "мессенждер",
        description = "Очень КРУТОЕ приложения"
    ),
    AppCardState(
        iconRes = R.drawable.maps_svgrepo_com,
        appName = "Карты",
        category = "инструменты",
        description = "Очень крутого приложения"
    ),
    AppCardState(
        iconRes = R.drawable.gmail_svgrepo_com,
        appName = "Почта",
        category = "почта",
        description = "Очень крутого приложения"
    ),
    AppCardState(
        iconRes = R.drawable.calendar_alt_svgrepo_com,
        appName = "Календарь",
        category = "инструменты",
        description = "Очень крутого приложения"
    ),
)