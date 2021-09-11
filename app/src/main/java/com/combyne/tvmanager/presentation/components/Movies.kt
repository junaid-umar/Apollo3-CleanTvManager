package com.combyne.tvmanager.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.combyne.domain.model.Movie
import com.combyne.domain.util.TimeUtils
import com.combyne.tvmanager.R
import kotlinx.coroutines.launch


@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun Movies(
    movies: Map<Char, List<Movie>>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(modifier) {
        val lazyState = rememberLazyListState()
        val scope = rememberCoroutineScope()
        LazyColumn(
            state = lazyState,
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            movies.forEach { initial, movies ->
                stickyHeader {
                    MovieHeader(initial = initial, Modifier.fillParentMaxWidth())
                }
                items(movies) { movie ->
                    MovieCard(movie = movie, onClick = onClick)
                }
            }
        }
        val showButton = lazyState.firstVisibleItemIndex > 0
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton {
                scope.launch {
                    lazyState.animateScrollToItem(0)
                }
            }
        }
    }
}

@Composable
fun MovieHeader(initial: Char, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.background(Color.White)) {
        Text(
            text = initial.toString(),
            modifier = modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun ScrollToTopButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(imageVector = Icons.Filled.ArrowUpward, contentDescription = "")
    }
}

@ExperimentalCoilApi
@Composable
fun MovieCard(
    movie: Movie,
    onClick: () -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(
                top = 12.dp,
                bottom = 12.dp,
                start = 8.dp,
                end = 8.dp
            )
        ) {

            Image(
                painter = rememberImagePainter(
                    data = movie.movieCover,
                    builder = {
                        crossfade(true)
                        placeholder(R.drawable.movie_holder)
                    }
                ),
                contentDescription = "Movie Cover",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(6.dp))
            )

            Column(
                modifier = Modifier
                    .padding(
                        bottom = 12.dp
                    )
                    .align(Alignment.CenterVertically),

                ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h3
                )
                movie.releaseData?.let {
                    Text(
                        text = TimeUtils.dateToString(it),
                        style = MaterialTheme.typography.caption
                    )
                }
                movie.seasons?.let {
                    Text(
                        text = "Season: " + movie.seasons.toString(),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
    }
}