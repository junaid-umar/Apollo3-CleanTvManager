package com.combyne.tvmanager.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.combyne.tvmanager.R

@Composable
fun SearchAppBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    focusManager: FocusManager,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        Column {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .padding(8.dp),
                value = query,
                onValueChange = {
                    onQueryChanged(it)
                },
                label = {
                    Text(stringResource(R.string.search))
                },

                leadingIcon = {
                    Icon(Icons.Filled.Search, stringResource(R.string.search))
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    focusManager.clearFocus()
                }),
            )
        }
    }
}