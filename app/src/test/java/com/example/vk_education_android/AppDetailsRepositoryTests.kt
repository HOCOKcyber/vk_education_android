package com.example.vk_education_android

import com.example.vk_education_android.data.AppDetailsAPI
import com.example.vk_education_android.data.AppDetailsRepositoryImpl
import com.example.vk_education_android.domain.AppDetails
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class AppDetailsRepositoryTests {
    private val api: AppDetailsAPI = mock()
    private val repository = AppDetailsRepositoryImpl(api)

    @Test
    fun `get empty list from getApps`() = runTest {
        whenever(api.getCatalogs()).thenReturn(listOf())

        val result = repository.getApps()

        assertEquals(listOf<AppDetails>(), result)
    }
}