package com.example.vk_education_android.present.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vk_education_android.present.AppDetailsContent
import com.example.vk_education_android.present.AppDetailsState
import com.example.vk_education_android.present.AppDetailsViewModel
import com.example.vk_education_android.present.AppListScreen
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme

@Composable
fun NavigationScreen() {
    Vk_education_androidTheme {
        val snackBarHostState = remember { SnackbarHostState() }
        Scaffold(
            modifier = Modifier.background(MaterialTheme.colorScheme.surface),
            snackbarHost = { SnackbarHost(snackBarHostState) }
        ) { contentPadding ->

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Route.AppList
            ) {
                composable<Route.AppList>() {
                    AppListScreen(
                        snackBarHostState = snackBarHostState,
                        toDetails = { appId -> navController.navigate(Route.Details(appId)) },
                        modifier = Modifier.padding(contentPadding)
                    )
                }

                composable<Route.Details>() {
                    val viewModel = hiltViewModel<AppDetailsViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()

                    when (state) {
                        is AppDetailsState.Content -> {
                            AppDetailsContent(
                                content = state as AppDetailsState.Content,
                                onBackClick = {
                                    navController.popBackStack()
                                },
                                onShareClick = {
                                },
                                onInstallClick = {
                                    viewModel.onInstallClick()
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

                        is AppDetailsState.Loading -> {
                            Text(
                                text = "Loading"
                            )
                        }

                        is AppDetailsState.Error -> {
                            Text(
                                text = "Error"
                            )
                        }
                    }
                }

            }

        }
    }
}