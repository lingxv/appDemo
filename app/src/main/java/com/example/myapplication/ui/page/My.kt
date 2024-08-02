package com.example.myapplication.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.myapplication.R

@Composable
fun My(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp, 0.dp, 14.dp, 0.dp),
    ) {
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "设置"
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.default_avatar),
                contentDescription = "头像",
                modifier = Modifier.height(60.dp)
            )
            Text(text = "158858555555")
            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "登录",
                modifier = Modifier.clickable {
                    navController.navigate("login") {
                        // 确保只有选定的路由保留在后堆栈中
                        popUpTo("login") { inclusive = true }
                    }
                })
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(10.dp, 16.dp, 0.dp, 14.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "历史记录", fontWeight = FontWeight(500))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "",
                        tint = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(100) {
                        Column(modifier = Modifier.clickable { }.width(72.dp)) {
                            AsyncImage(
                                model = "https://cdn.anisearch.com/images/character/cover/85/85666_400.webp",
                                contentDescription = "",
                                modifier = Modifier
                                    .height(96.dp)
                                    .clip(RoundedCornerShape(8.dp))
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "不当哥哥了",
                                fontWeight = FontWeight(500),
                                fontSize = 13.sp,
                                lineHeight = TextUnit(13.64f, TextUnitType.Sp),
                                maxLines = 1, overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "观看至第1集",
                                fontWeight = FontWeight(400),
                                fontSize = 11.sp,
                                color = Color.Gray,
                                lineHeight = TextUnit(12.45f, TextUnitType.Sp)
                            )
                        }

                    }
                }
            }
        }
    }

}