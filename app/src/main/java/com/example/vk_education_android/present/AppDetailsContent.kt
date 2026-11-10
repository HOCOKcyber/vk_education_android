package com.example.vk_education_android.present

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vk_education_android.domain.AppDetails
import com.example.vk_education_android.domain.Category
import com.example.vk_education_android.domain.SimilarApp
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme
import com.example.vk_education_android.utils.MockData

@Composable
fun AppDetailsContent(
    content: AppDetailsState.Content,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onInstallClick: () -> Unit,
    onReadMoreClick: () -> Unit,
    onDeveloperClick: () -> Unit,
    onSimilarAppDownloadClick: (SimilarApp) -> Unit,
    modifier: Modifier = Modifier,
) {
    val appDetails = content.appDetails
    val descriptionCollapsed = content.descriptionCollapsed

    Column(modifier.verticalScroll(rememberScrollState())) {
        Toolbar(
            onBackClick = onBackClick,
            onShareClick = onShareClick,
        )
        Spacer(Modifier.height(8.dp))
        AppDetailsHeader(
            appDetails = appDetails,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(16.dp))
        InstallButton(
            onClick = onInstallClick,
            installState = content.installState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        if (content.similarApps.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            SimilarApps(
                apps = content.similarApps,
                onDownloadClick = onSimilarAppDownloadClick,
                modifier = Modifier.padding(horizontal = 16.dp),
            )
        }
        Spacer(Modifier.height(12.dp))
        if (!appDetails.screenshotUrlList.isNullOrEmpty()){
            ScreenshotsList(
                screenshotUrlList = appDetails.screenshotUrlList,
                contentPadding = PaddingValues(horizontal = 16.dp),
            )
            Spacer(Modifier.height(12.dp))
        }
        AppDescription(
            description = appDetails.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = onReadMoreClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Spacer(Modifier.height(12.dp))
        Developer(
            name = appDetails.developer,
            onClick = onDeveloperClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        )

        AppShowcase(
            onBack = onBackClick,
            appList = content.appShowcase,
            modifier = Modifier.padding(
                horizontal = 16.dp
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Vk_education_androidTheme {
        AppDetailsContent(
            content = AppDetailsState.Content(
                appDetails = AppDetails(
                    id = "fa2e31b8-1234-4cf7-9914-108a170a1b01",
                    name = "Гильдия Героев: Экшен ММО РПГ",
                    developer = "VK Play",
                    category = Category.GAME,
                    ageRating = 12,
                    size = 223.7f,
                    screenshotUrlList = MockData.getMockScreenshotUrlList(),
                    iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
                    description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
                ),
                similarApps = MockData.getMockSimilarApps(),
                descriptionCollapsed = false,
                appShowcase = MockData.getMockShowcase(),
                installState = InstallState.Installed
            ),
            onReadMoreClick = {},
            onBackClick = {},
            onShareClick = {},
            onInstallClick = {},
            onDeveloperClick = {},
            onSimilarAppDownloadClick = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}