package com.example.pantallaprincipal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }


    val nameValid = name.matches(Regex("^[a-zA-Z ]+$"))

    val emailValid = android.util.Patterns.EMAIL_ADDRESS
        .matcher(email)
        .matches()

    val phoneValid = phone.matches(Regex("^\\d{10}$"))

    val passwordValid = password.isNotEmpty()

    val passwordsMatch = password == confirmPassword

    val formValid =
        nameValid &&
                emailValid &&
                phoneValid &&
                passwordValid &&
                passwordsMatch

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
                text = "Register",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(24.dp))

            // NAME
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                isError = name.isNotEmpty() && !nameValid
            )

            Spacer(modifier = Modifier.height(16.dp))

            // EMAIL
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                isError = email.isNotEmpty() && !emailValid
            )

            Spacer(modifier = Modifier.height(16.dp))

            // PHONE
            TextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone") },
                modifier = Modifier.fillMaxWidth(),
                isError = phone.isNotEmpty() && !phoneValid
            )

            Spacer(modifier = Modifier.height(12.dp))

            // PASSWORD
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = "Confirm Password",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    singleLine = true,
                    isError = confirmPassword.isNotEmpty() && !passwordsMatch
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // BOTÓN SIGN UP
            Box(
                modifier = Modifier
                    .align(Alignment.End)
                    .height(50.dp)
                    .width(120.dp)
                    .clickable(enabled = formValid) {
                        println("Registro correcto")
                    }
                    .background(
                        if (formValid) Color(0xFF5E4AE3) else Color.Gray,
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