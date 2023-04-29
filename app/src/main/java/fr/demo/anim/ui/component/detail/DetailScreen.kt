package fr.demo.anim.ui.component.detail

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.demo.anim.model.Gender
import fr.demo.anim.model.catList
import fr.demo.anim.ui.navigation.Screen
import fr.demo.anim.ui.theme.DemoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun DetailScreen(id: String?, onNavigate: (Screen?) -> Unit) {
    val cat = catList.first { it.id == id?.toInt() }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = {
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge,
                        text = "${cat.name} - ${cat.title}"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { onNavigate(null) },
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) {

        var isLoading by rememberSaveable { mutableStateOf(true) }

        val coroutineScope = rememberCoroutineScope()
        LaunchedEffect(true) {
            coroutineScope.launch {
                val delay: Long = 1500 + (100 * Random.nextInt(20)).toLong()
                delay(delay)
                isLoading = false
            }
        }

        if (isLoading) {
            CatLoading(modifier = Modifier.fillMaxSize())
        }

        AnimatedVisibility(
            visible = !isLoading,
            enter = fadeIn()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .nestedScroll(scrollBehavior.nestedScrollConnection)
                    .verticalScroll(rememberScrollState())
            ) {
                Box {
                    CatPicture(cat)
                    FavButton(
                        Modifier
                            .align(Alignment.BottomEnd)
                            .padding(12.dp)
                    )
                }
                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        val modifier = Modifier.weight(1f)
                        CatInfoBloc(modifier, Gender.getLabel(cat.gender), "Sexe")
                        CatInfoBloc(modifier, "${cat.age} mois", "Âge")
                    }
                    AbilitiesView(modifier = Modifier.padding(vertical = 24.dp), cat = cat)
                    DescriptionCard(cat)
                }
            }
        }
    }
}


@Preview(
    name = "DetailScreen",
    group = "Preview",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "DetailScreen",
    group = "Preview",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun Preview_DetailScreen() {
    DemoTheme {
        DetailScreen("1") {}
    }
}