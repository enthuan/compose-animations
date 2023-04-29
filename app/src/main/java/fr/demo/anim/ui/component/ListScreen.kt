@file:OptIn(ExperimentalAnimationGraphicsApi::class)

package fr.demo.anim.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.demo.anim.R
import fr.demo.anim.model.catList
import fr.demo.anim.ui.theme.DemoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ListScreen(onGoDetail: (String) -> Unit) {

    val lazyListState = rememberLazyListState()
    val fabExpand = remember { derivedStateOf { lazyListState.firstVisibleItemIndex > 0 } }.value

    var sorted by remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()
    val onInverseSort = {
        sorted = !sorted
        // TODO ARO 2 Lists animToZero
    }
    val myItems = remember(sorted) {
        derivedStateOf {
            if (sorted) {
                catList.sortedBy { it.name }
            } else {
                catList.sortedByDescending { it.name }
            }
        }
    }.value


    val scaleY by animateFloatAsState(
        targetValue = (if (sorted) {
            -1f
        } else {
            1f
        }),
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )
    var atEnd by remember { mutableStateOf(false) }

    // TODO ARO 1 FAB Icon v2 (AVD)
    val fabIcon = Icons.Filled.Sort

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                title = {
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge,
                        text = "Chaptel"
                    )
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onInverseSort()
                atEnd = !atEnd
            }) {
                Row(Modifier.padding(horizontal = 16.dp)) {
                    Icon(
                        // TODO ARO 1 FAB Icon v2 (AVD)
                        modifier = Modifier.scale(1f, scaleY),
                        imageVector = fabIcon,
                        contentDescription = null
                    )
                    // TODO ARO 2 Lists (remove me, I'm famous)
                    AnimatedVisibility (fabExpand) {
                        Text(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = "Trier"
                        )
                    }
                }
            }
        }
    ) { it ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            state = lazyListState
        ) {
            items(items = myItems, key = { it.id }) { cat ->
                CatView(
                    modifier = Modifier
                        .fillMaxWidth()
                        // TODO ARO 2 Lists
                        .clickable {
                            onGoDetail(cat.id.toString())
                        }
                        .padding(horizontal = 24.dp, vertical = 16.dp),
                    cat = cat
                )
            }
        }
    }
}

@Preview
@Composable
fun ListScreenPreview() {
    DemoTheme {
        ListScreen { }
    }
}
