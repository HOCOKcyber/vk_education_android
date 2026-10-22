package com.example.vk_education_android.present

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vk_education_android.R
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme

@Composable
fun AppListScreen(
    snackBarHostState: SnackbarHostState,
    toDetails: () -> Unit,
    modifier: Modifier = Modifier
){
    val viewModel = viewModel<AppListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when(event){
                is AppListEvent.ToDetails -> {
                    Log.d("EVENT APPLIST", "To Details")
                    snackBarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Column(
        modifier = modifier
    ) {
        ToolBar()
        AppListContent(
            apps = state.apps,
            toDetails = { appName ->
                viewModel.showSnackBar("Переход в $appName")
                toDetails()
            }
        )
    }
}

@Composable
private fun ToolBar(){
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "main icon"
        )
    }
}

@Composable
private fun AppListContent(
    apps: List<AppCardState>,
    toDetails: (appName: String) -> Unit,
){
    LazyColumn {
        apps.forEach {
            item {
                AppCard(
                    iconRes = it.iconRes,
                    appName = it.appName,
                    category = it.category,
                    description = it.description,
                    onClick = { toDetails(it.appName) }
                )
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun AppListScreenPreview(){
    Vk_education_androidTheme {
        val snackbarHostState = SnackbarHostState()
        AppListScreen(
            toDetails = {},
            snackBarHostState = snackbarHostState
        )
    }
}