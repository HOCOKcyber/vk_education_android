package com.example.vk_education_android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vk_education_android.ui.theme.Vk_education_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vk_education_androidTheme {
                Screen(
                    sendTextToActivity = ::sendTextToActivity
                )
            }
        }
    }

    fun sendTextToActivity(text: String){
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("text", text)
        }
        startActivity(intent)
    }

}

@Composable
fun Screen(
    sendTextToActivity: (String) -> Unit
){
    var text by remember { mutableStateOf(" ") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Введите текст") }
        )
        Button(
            content = { Text("Передать") },
            onClick = { sendTextToActivity(text) }
        )
    }
}

@Preview
@Composable
fun ScreenPreview(){
    Vk_education_androidTheme {
        Screen(
            sendTextToActivity = {},
        )
    }
}