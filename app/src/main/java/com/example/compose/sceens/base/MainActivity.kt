package com.example.compose.sceens.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.example.compose.R
import com.example.compose.sceens.details.ProductScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colors = DarkColors
            ) {
                ProductScreen()
            }
        }
    }
}