package com.example.reviewrestaurants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reviewrestaurants.ui.theme.ReviewRestaurantsTheme


@Composable
fun SignIn(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(id = R.drawable.background)

        Column(
            modifier = Modifier
                .weight(1.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = image,
                contentDescription = "Test",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            FormLogin(navController = navController)
        }

        Column(
            modifier = Modifier
                .weight(0.5f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Don't have an account?", color = Color.Black)
                TextButton(onClick = {
                    navController.navigate("SignUp")
                }) {
                    Text("Sign Up")
                }
            }
        }
    }
}

@Composable
fun FormLogin(navController: NavHostController) {
    val focusManager = LocalFocusManager.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Welcome back!",
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text("Login your existing account", color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(30.dp))

    var email by remember { mutableStateOf("") }
    TextFieldReviewRestaurant(
        value = email,
        onValueChange = { email = it },
        image = Icons.Filled.Person,
        placeHolder = "Username"
    )
    Spacer(modifier = Modifier.height(10.dp))

    var password by remember { mutableStateOf("") }
    TextFieldReviewRestaurant(
        value = password,
        onValueChange = { password = it },
        image = Icons.Filled.Lock,
        placeHolder = "Password",
        isSecure = true
    )
    Spacer(modifier = Modifier.height(20.dp))

    Button(
        modifier = Modifier
            .width(150.dp)
            .height(50.dp),
        onClick = {
            navController.navigate("Dashboard")
        },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Blue
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text("LOG IN", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReviewRestaurantsTheme {
        SignIn(rememberNavController())
    }
}