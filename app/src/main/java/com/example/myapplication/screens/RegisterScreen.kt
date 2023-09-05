package com.example.myapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegisterScreen() {
    Box(){
        Column( verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
        ) {
            Spacer(modifier = Modifier.height(height = 30.dp))

            Text(
                text = "Registros",
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp, bottom = 55.dp)
            ) {

            }
        }
    }
}