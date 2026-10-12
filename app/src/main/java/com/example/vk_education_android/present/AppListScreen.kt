package com.example.vk_education_android.present

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.vk_education_android.R
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme

@Composable
fun AppListScreen(
    toDetails: () -> Unit,
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier
    ) {
        ToolBar()
        AppListContent(
            toDetails = toDetails
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
    toDetails: () -> Unit,
){
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        getAppCards().forEach {
            AppCard(
                iconRes = it.iconRes,
                appName = it.appName,
                category = it.category,
                description = it.description,
                onClick = toDetails
            )
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
        AppListScreen(
            toDetails = {}
        )
    }
}