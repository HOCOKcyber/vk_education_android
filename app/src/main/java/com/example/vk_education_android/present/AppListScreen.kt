package com.example.vk_education_android.present

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vk_education_android.R
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme

@Composable
fun AppListScreen(){

    Column {
        ToolBar()
        AppListContent()
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
private fun AppListContent(){
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        AppCard(
            appIcon = painterResource(R.drawable.firefox_svgrepo_com),
            appName = "Firefox",
            category = "браузер",
            description = "Очень крутого приложения"
        )
        AppCard(
            appIcon = painterResource(R.drawable.calculator_svgrepo_com),
            appName = "Калькулятор",
            category = "инструменты",
            description = "Очень крутого приложения"
        )
        AppCard(
            appIcon = painterResource(R.drawable.python_svgrepo_com),
            appName = "Python",
            category = "инструменты",
            description = "Очень не крутого приложения"
        )
        AppCard(
            appIcon = painterResource(R.drawable.phone_svgrepo_com),
            appName = "Телефон",
            category = "инструменты",
            description = "Очень крутого приложения"
        )
        AppCard(
            appIcon = painterResource(R.drawable.gallery_round_svgrepo_com),
            appName = "Галерея",
            category = "инструменты",
            description = "Очень крутого приложения"
        )
        AppCard(
            appIcon = painterResource(R.drawable.telegram_svgrepo_com),
            appName = "Telegram",
            category = "мессенждер",
            description = "Очень КРУТОЕ приложения"
        )
        AppCard(
            appIcon = painterResource(R.drawable.maps_svgrepo_com),
            appName = "Карты",
            category = "инструменты",
            description = "Очень крутого приложения"
        )
        AppCard(
            appIcon = painterResource(R.drawable.gmail_svgrepo_com),
            appName = "Почта",
            category = "почта",
            description = "Очень крутого приложения"
        )
        AppCard(
            appIcon = painterResource(R.drawable.calendar_alt_svgrepo_com),
            appName = "Календарь",
            category = "инструменты",
            description = "Очень крутого приложения"
        )
    }
}

@Composable
private fun AppCard(
    appIcon: Painter,
    appName: String,
    category: String,
    description: String,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Image(
            painter = appIcon,
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .padding(vertical = 8.dp)
        )
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = appName
                )
                Text(
                    text = category,
                    fontSize = 12.sp,
                    color = Color.White,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Gray)
                        .padding(vertical = 2.dp, horizontal = 4.dp)
                )
            }
            Text(
                text = description
            )
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun AppListScreenPreview(){
    Vk_education_androidTheme {
        AppListScreen()
    }
}