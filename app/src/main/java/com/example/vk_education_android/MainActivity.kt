package com.example.vk_education_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vk_education_android.present.AppListScreen
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vk_education_androidTheme {
                AppListScreen()
            }
        }
    }
}