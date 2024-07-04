package com.example.wbtechnoschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.wbtechnoschool.navigation.BottomNavBar
import com.example.wbtechnoschool.navigation.NavHostContainer
import com.example.wbtechnoschool.ui.theme.WBTechnoschoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WBTechnoschoolTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavBar(navController = navController) }, modifier = Modifier.navigationBarsPadding(),
                    content = { padding ->
                        NavHostContainer(
                            navController = navController,
                            modifier = Modifier.padding()
                        )
                    }
                )
            }
        }
    }
}