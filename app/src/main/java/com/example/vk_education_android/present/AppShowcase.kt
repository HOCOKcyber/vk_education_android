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
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme
import kotlinx.coroutines.launch

@Composable
fun AppShowcase(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
){
    val pagerState = rememberPagerState { 3 }
    val coroutineScope = rememberCoroutineScope()
    val appList = getAppCards()

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
                        iconRes = app.iconRes,
                        appName = app.appName,
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
            onBack = {}
        )
    }
}