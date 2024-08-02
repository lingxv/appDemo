package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.Login
import com.example.myapplication.ui.core.BottomNavigationBar
import com.example.myapplication.ui.page.Collection
import com.example.myapplication.ui.page.My
import com.example.myapplication.ui.page.PlayHouse
import com.example.myapplication.ui.page.Referral
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            // Observe the current route
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route
            MyApplicationTheme {
                Scaffold(
                    bottomBar = {
                        if (currentRoute != "login") {
                            BottomNavigationBar(navController,currentRoute)
                        }
                    },
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        if (currentRoute != "referral"){
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFFFA178), Color(0xFFF7F7F7)),
                                            start = Offset(63.6f, 6f),
                                            end = Offset(300f, 442.8f)
                                        )
                                    )
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        brush = Brush.linearGradient(
                                            colors = listOf(Color(0xFFBBFFEF), Color(0x00F7F7F7)),
                                            start = Offset(885.6f, 15.6f),
                                            end = Offset(565.2f, 570f)
                                        )
                                    )
                            )
                        }

                        NavHost(
                            navController = navController,
                            startDestination = "playhouse",
                            modifier = Modifier.padding(innerPadding),
                            contentAlignment = Alignment.TopEnd
                        ) {
                            composable("referral") { Referral() }
                            composable("playhouse") { PlayHouse() }
                            composable("collection") { Collection() }
                            composable("my") { My(navController) }
                            composable("login") { Login() }
                        }
                    }
                }

            }
        }
    }
}






