package com.combyne.tvmanager.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.combyne.tvmanager.R

@Composable
fun CreateMovie(
    title: String,
    releaseDate: String?,
    season: Int?,
    onTitleChange: (String) -> Unit,
    onReleaseDateChange: (String) -> Unit,
    onSeasonChange: (Int) -> Unit,
    modifier: Modifier,
    onSaveMovie: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(8.dp),
            value = title,
            onValueChange = onTitleChange,
            label = {
                Text(text = stringResource(R.string.title))
            }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(8.dp),
            value = releaseDate ?: "",
            onValueChange = onReleaseDateChange,
            label = {
                Text(text = stringResource(R.string.release_date))
            }
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(8.dp),
            value = season?.toString() ?: "",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            onValueChange = { onSeasonChange(it.toInt()) },
            label = {
                Text(text = stringResource(R.string.seasons))
            }
        )

        Button(
            onClick = { onSaveMovie() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {

            Text(text = stringResource(R.string.save_movie))
        }
    }


}