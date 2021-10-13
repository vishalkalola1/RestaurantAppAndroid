package com.example.reviewrestaurants

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.reviewrestaurants.ui.theme.ReviewRestaurantsTheme
import kotlin.math.log

class UserDashboardActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewRestaurantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SignUp(rememberNavController())
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}

@Composable
fun SignUp(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            FormSignUp()
        }
    }
}

@Composable
fun FormSignUp() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(text = "Sign Up",
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text("Create a new account", color = Color.Gray)
    }
    Spacer(modifier = Modifier.height(30.dp))

    var firstname by remember { mutableStateOf("") }
    TextFieldReviewRestaurant(
        value = firstname,
        onValueChange = { firstname = it },
        image = Icons.Filled.Person,
        placeHolder = "First Name"
    )
    Spacer(modifier = Modifier.height(10.dp))

    var lastname by remember { mutableStateOf("") }
    TextFieldReviewRestaurant(
        value = lastname,
        onValueChange = { lastname = it },
        image = Icons.Filled.Lock,
        placeHolder = "Last Name"
    )
    Spacer(modifier = Modifier.height(20.dp))

    var email by remember { mutableStateOf("") }
    TextFieldReviewRestaurant(
        value = email,
        onValueChange = { email = it },
        image = Icons.Filled.Lock,
        placeHolder = "Email"
    )
    Spacer(modifier = Modifier.height(20.dp))

    var username by remember { mutableStateOf("") }
    TextFieldReviewRestaurant(
        value = username,
        onValueChange = { username = it },
        image = Icons.Filled.Lock,
        placeHolder = "Username"
    )
    Spacer(modifier = Modifier.height(20.dp))

    var password by remember { mutableStateOf("") }
    TextFieldReviewRestaurant(
        value = password,
        onValueChange = { password = it },
        image = Icons.Filled.Lock,
        placeHolder = "Password",
        isSecure = true
    )
    Spacer(modifier = Modifier.height(20.dp))

    var confirmPassword by remember { mutableStateOf("") }
    TextFieldReviewRestaurant(
        value = confirmPassword,
        onValueChange = { confirmPassword = it },
        image = Icons.Filled.Lock,
        placeHolder = "Confirm Password",
        isSecure = true
    )
    Spacer(modifier = Modifier.height(20.dp))

    Button(
        modifier = Modifier
            .width(150.dp)
            .height(50.dp),
        onClick = { /* Do something! */ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Blue
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text("Sign Up", color = Color.White)
    }
}

@Composable
fun TextFieldReviewRestaurant(value: String, onValueChange: (String) -> Unit, image: ImageVector, placeHolder: String, isSecure:Boolean = false){
    val focusManager = LocalFocusManager.current
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Blue, shape = RoundedCornerShape(50)),
        leadingIcon = {
            Icon(
                imageVector = image,
                contentDescription = "Icon",
                tint = Color.Blue
            )
        },
        placeholder = {
            Text(placeHolder, color = Color.LightGray)
        },
        singleLine = true,
        visualTransformation = if (isSecure) PasswordVisualTransformation() else VisualTransformation.None,
        shape = RoundedCornerShape(50),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
            disabledLabelColor = Color.LightGray,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ReviewRestaurantsTheme {
        SignUp(rememberNavController())
    }
}