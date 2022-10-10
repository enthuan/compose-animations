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
import androidx.compose.ui.unit.dp
import fr.demo.anim.R
import fr.demo.anim.model.catList
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
        coroutineScope.launch {
            delay(200)
            lazyListState.animateScrollToItem(0)
        }
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
    val fabIcon = AnimatedImageVector.animatedVectorResource(R.drawable.avd_anim)

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
                        //modifier = Modifier.scale(1f, scaleY),
                        painter = rememberAnimatedVectorPainter(fabIcon, atEnd),
                        contentDescription = null
                    )
                    // TODO FAB 1
                    //if (false /* && fabExpand */) {
                    // TODO FAB 2 (AnimatedVisibility)
                    AnimatedVisibility(fabExpand) {
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
                /*Row(modifier = Modifier
                    .fillMaxWidth()
                    .animateItemPlacement()
                    .clickable { onClick(it.toString()) }
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(text = "Item $it")
                    }
                }*/
                CatView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItemPlacement()
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
