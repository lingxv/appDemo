package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun Login() {
    Column(modifier = Modifier.fillMaxSize()) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = "关闭",
            modifier = Modifier
                .height(28.dp)
                .padding(18.dp, 4.dp, 0.dp, 0.dp)
        )
        Spacer(modifier = Modifier.height(108.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .width(107.dp)
                .height(57.dp)
                .align(Alignment.CenterHorizontally)

        )

    }
}