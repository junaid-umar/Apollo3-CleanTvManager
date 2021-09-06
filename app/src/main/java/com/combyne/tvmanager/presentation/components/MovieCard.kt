package com.combyne.tvmanager.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.combyne.domain.model.Movie
import com.combyne.domain.util.TimeUtils

@Composable
fun MovieCard(
    movie: Movie,
    onClick: () -> Unit,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(
                top = 12.dp,
                bottom = 12.dp,
                start = 8.dp,
                end = 8.dp
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 12.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
                movie.releaseData?.let {
                    Text(
                        text = TimeUtils.dateToString(it),
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.caption
                    )
                }
            }

            movie.seasons?.let {
                Text(
                    text = "Season: " + movie.seasons.toString(),
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}