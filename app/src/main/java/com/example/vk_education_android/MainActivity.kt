package com.example.vk_education_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vk_education_android.present.AppDetailsContent
import com.example.vk_education_android.present.AppListScreen
import com.example.vk_education_android.present.getAppDetails
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vk_education_androidTheme {
                Scaffold(
                    modifier = Modifier.background(MaterialTheme.colorScheme.surface)
                ) { contentPadding ->

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            AppListScreen(
                                toDetails = { navController.navigate("details") },
                                modifier = Modifier.padding(contentPadding)
                            )
                        }

                        composable("details") {
                            AppDetailsContent(
                                content = getAppDetails(),
                                onBackClick = {
                                    navController.popBackStack()
                                },
                                onShareClick = {
                                },
                                onInstallClick = {
                                },
                                onReadMoreClick = {
                                },
                                onSimilarAppDownloadClick = {
                                },
                                onDeveloperClick = {
                                },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .safeDrawingPadding()
                                    .padding(contentPadding),
                            )
                        }
                    }

                }
            }
        }
    }
}