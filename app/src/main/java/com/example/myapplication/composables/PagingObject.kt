package com.example.myapplication.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.data.ContainerData

@Composable
fun PagingObject(paggingobject: ContainerData) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White,
        ) ,
        modifier = Modifier.fillMaxWidth(),

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(90.dp)
                .padding(horizontal = 20.dp),
        ) {
            Column(

            ) {
                Row() {
                    Text(
                        text = "Codigo: ",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "exampleCode",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.LightGray
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row() {
                    Text(
                        text = "Ubicacion: ",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "exampleLocation",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.LightGray

                    )
                }
                Spacer(modifier = Modifier.height(5.dp))

                Row() {
                    Text(
                        text = "Dato: ",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "exampleData",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.LightGray

                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 5.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_container),
                    modifier = Modifier.size(50.dp),
                    contentDescription = "Turn Icon",
                    tint = Color.Green
                )

            }
        }
    }
}


