package com.example.vk_education_android.present

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.vk_education_android.R
import com.example.vk_education_android.domain.AppDetails
import com.example.vk_education_android.domain.Category
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme
import kotlinx.coroutines.launch

@Composable
fun AppShowcase(
    onBack: () -> Unit,
    appList: List<AppDetails>,
    modifier: Modifier = Modifier,
){
    val pagerState = rememberPagerState { 3 }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.showcase),
            style = MaterialTheme.typography.displaySmall,
        )
        HorizontalPager(
            state = pagerState
        ) { page ->
            Column {
                val start = page * 3
                val end = start + 2
                for (i in start..end) {
                    val app = appList[i]
                    AppCard(
                        iconUrl = app.iconUrl,
                        appName = app.name,
                        category = app.category,
                        description = app.description,
                        onClick = onBack
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    pagerState.scrollToPage(
                        if (pagerState.canScrollBackward) pagerState.currentPage - 1
                        else pagerState.pageCount
                    )
                }
            }) {
                Text("Назад")
            }

            Button(onClick = {
                coroutineScope.launch {
                    pagerState.scrollToPage(
                        if (pagerState.canScrollForward) pagerState.currentPage + 1
                        else 0
                    )
                }
            }) {
                Text("Далее")
            }
        }
    }
}

@Preview
@Composable
private fun AppShowCasePreview(){
    Vk_education_androidTheme{
        AppShowcase(
            onBack = {},
            appList = listOf(AppDetails(
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
                )
        )
    }
}