package fr.demo.anim.ui.component

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
// TODO BCR 3 3 Transitions entre les écrans
//import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import fr.demo.anim.ui.component.detail.DetailScreen
import fr.demo.anim.ui.navigation.Screen
import fr.demo.anim.ui.navigation.navigate

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DemoApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splashscreen.route) {
    // TODO BCR 3 1 Transitions entre les écrans
    /*val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = Screen.Splashscreen.route) {*/

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
            // TODO BCR 3 2 Transitions entre les écrans
            /*enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }*/
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            DetailScreen(id, onNavigate)
        }
    }
}

