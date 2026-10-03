package com.example.rastykpop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}
