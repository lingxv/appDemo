package com.example.myapplication.ui.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R

@Composable
fun BottomNavigationBar(navController: NavHostController, currentRoute: String?) {
    // Data class for navigation item
    data class NavigationItem(
        val iconRes: Int,
        val iconLive: Int,
        val label: String,
        val route: String
    )

    // List of navigation items
    val navigationItems = listOf(
        NavigationItem(R.drawable.referral, R.drawable.referral_live, "推荐", "referral"),
        NavigationItem(R.drawable.playhouse, R.drawable.playhouse_live, "剧场", "playhouse"),
        NavigationItem(R.drawable.collection, R.drawable.collection_live, "收藏", "collection"),
        NavigationItem(R.drawable.my, R.drawable.my_live, "我的", "my")
    )


    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier.height(60.dp)
    ) {
        navigationItems.forEachIndexed { _, item ->
            NavigationBarItem(
                icon = {
                    if (currentRoute == item.route) {
                        Image(
                            painterResource(id = item.iconLive),
                            contentDescription = item.label
                        )
                    } else {
                        Image(
                            painterResource(id = item.iconRes),
                            contentDescription = item.label,
                            modifier = Modifier.height(28.dp)
                        )
                    }

                },
                label = {
                    Text(
                        text = item.label,
                        color = if (currentRoute == item.route) Color(0xFFFF6320) else Color.Gray,
                        fontSize = if (currentRoute == item.route) 11.sp else 10.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = TextUnit(10.49f, TextUnitType.Sp)
                    )
                },
                selected = false,
                onClick = {
                    // 导航到所选路线
                    navController.navigate(item.route) {
                        // 确保只有选定的路由保留在后堆栈中
                        popUpTo(item.route) { inclusive = true }
                    }
                }
            )
        }
    }
}