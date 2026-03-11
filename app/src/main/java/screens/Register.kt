package com.example.pantallaprincipal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pantallaprincipal.R

@Composable
fun RegisterScreen(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5E4AE3)),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(Color.White, shape = RoundedCornerShape(30.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // Imagen superior
            Image(
                painter = painterResource(id = R.drawable.ic_phone),
                contentDescription = "Register Image",
                modifier = Modifier.height(160.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Login",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // NAME
            Column(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = "Name",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(
                            1.dp,
                            Color.LightGray,
                            RoundedCornerShape(10.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // EMAIL
            Column(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = "Email",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(
                            1.dp,
                            Color.LightGray,
                            RoundedCornerShape(10.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // PASSWORD
            Column(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = "Password",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(
                            1.dp,
                            Color.LightGray,
                            RoundedCornerShape(10.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Forgot password?",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // BOTÓN SIGN UP
            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .height(50.dp)
                    .width(120.dp)
                    .background(
                        Color(0xFF5E4AE3),
                        RoundedCornerShape(30.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Sign Up",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}