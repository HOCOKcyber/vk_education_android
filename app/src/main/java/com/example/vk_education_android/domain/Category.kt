package com.example.vk_education_android.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Category {
    // Старые значения — оставлены для обратной совместимости
    @SerialName("Приложения")
    APP,

    @SerialName("Игры")
    GAME,

    @SerialName("Производительность")
    PRODUCTIVITY,

    @SerialName("Социальные сети")
    SOCIAL,

    @SerialName("Образование")
    EDUCATION,

    @SerialName("Развлечения")
    ENTERTAINMENT,

    @SerialName("Музыка")
    MUSIC,

    @SerialName("Видео")
    VIDEO,

    @SerialName("Фотография")
    PHOTOGRAPHY,

    @SerialName("Здоровье")
    HEALTH,

    @SerialName("Спорт")
    SPORTS,

    @SerialName("Здоровье и фитнес")
    HEALTH_AND_SPORT,

    @SerialName("Новости")
    NEWS,

    @SerialName("Книги")
    BOOKS,

    @SerialName("Бизнес")
    BUSINESS,

    @SerialName("Финансы")
    FINANCE,

    @SerialName("Путешествия")
    TRAVEL,

    @SerialName("Карты")
    MAPS,

    @SerialName("Еда")
    FOOD,

    @SerialName("Покупки")
    SHOPPING,

    @SerialName("Утилиты")
    UTILITIES,

    // Новые значения под категории из файла
    @SerialName("Фото и видео")
    PHOTO_AND_VIDEO,

    @SerialName("Еда и напитки")
    FOOD_AND_DRINKS,

    @SerialName("Образ жизни")
    LIFESTYLE,

    @SerialName("Шопинг")
    SHOPPING_MARKETPLACE,

    @SerialName("Навигация")
    NAVIGATION,

    @SerialName("Общение")
    COMMUNICATION,

    @SerialName("Погода")
    WEATHER,

    @SerialName("Книги и справочники")
    BOOKS_AND_REFERENCES
}