package com.example.reviewrestaurants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reviewrestaurants.ui.theme.ReviewRestaurantsTheme

class NavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReviewRestaurantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHostExample("SignIn")
                }
            }
        }
    }
}

@Composable
fun NavHostExample(startDestination: String) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = startDestination) {
        composable(route = "SignIn") {
            SignIn(navController)
        }
        composable("SignUp") {
            SignUp(navController)
        }

        composable("Dashboard") {
            Dashboard(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ReviewRestaurantsTheme {
        NavHostExample("SignIn")
    }
}