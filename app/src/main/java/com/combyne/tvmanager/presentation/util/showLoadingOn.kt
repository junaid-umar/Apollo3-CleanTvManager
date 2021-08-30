package com.combyne.tvmanager.presentation.util

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.combyne.domain.model.Movie
import com.combyne.domain.util.Result
import com.combyne.domain.util.TimeUtils
import com.combyne.tvmanager.presentation.movie.movies.MoviesAdapter
import com.google.android.material.snackbar.Snackbar
import java.time.ZonedDateTime

@BindingAdapter("bind:showLoadingOn")
fun showLoadingOn(view: View, item: Result<Any>?) {
    view.visibility = if (item is Result.Loading) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("bind:showErrorOn")
fun showErrorOn(view: View, item: Result<Any>?) {
    if (item is Result.Error) {
        Snackbar.make(
            view,
            item.error,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}

@BindingAdapter("bind:showDate")
fun showDate(view: TextView, date: ZonedDateTime?) {
    date?.let {
        view.text = "Release Date: " +TimeUtils.dateToString(date)
    } ?: run { view.visibility = View.GONE}
}


@BindingAdapter("bind:showSeason")
fun showSeason(view: TextView, seasons: Int?) {
    seasons?.let {
        view.text = "Seasons: " +seasons
    } ?: run { view.visibility = View.GONE}
}

@BindingAdapter("bind:bound_items")
fun setRecyclerViewResourceItems(
    recyclerView: RecyclerView,
    items: Result<List<Movie>>?,
) = setupMovieAdapter(recyclerView, items?.let { getData(items) } ?: emptyList())

fun getData(items: Result<List<Movie>>) = when (items) {
    is Result.Success -> items.data
    is Error -> emptyList()
    is Result.Loading -> items.data
    else -> emptyList()
}

fun setupMovieAdapter(
    recyclerView: RecyclerView,
    items: List<Movie>,
) {
    var adapter = (recyclerView.adapter as? MoviesAdapter)

    if (adapter == null) {
        adapter = MoviesAdapter()
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
    }

    if (!items.isEmpty()) {
        adapter.submitList(items.toMutableList())
    }
}