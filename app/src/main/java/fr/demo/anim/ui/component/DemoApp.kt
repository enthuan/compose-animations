package fr.demo.anim.ui.component

//import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import fr.demo.anim.ui.component.detail.DetailScreen
import fr.demo.anim.ui.navigation.Screen
import fr.demo.anim.ui.navigation.navigate

@Composable
fun DemoApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splashscreen.route) {

        val onNavigate: (Screen?) -> Unit = {
            if (it == null) {
                navController.popBackStack()
            } else {
                navController.navigate(it.route)
            }
        }

        composable(Screen.Splashscreen.route) {
            SplashScreen {
                navController.navigate(Screen.List) {
                    popUpTo(Screen.Splashscreen.route) { inclusive = true }
                }
            }
        }

        composable(Screen.List.route) {
            ListScreen {
                navController.navigate(Screen.Detail, it)
            }
        }
        composable(
            Screen.Detail.route,
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            DetailScreen(id, onNavigate)
        }
    }
}

