package com.example.wbtechnoschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschool.screens.StartScreen
import com.example.wbtechnoschool.ui.theme.WBTechnoschoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WBTechnoschoolTheme {
                val navController = rememberNavController()
                StartScreen(navController = navController)
            }
        }
    }
}