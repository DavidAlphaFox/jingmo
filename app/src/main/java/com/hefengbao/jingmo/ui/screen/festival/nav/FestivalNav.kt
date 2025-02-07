package com.hefengbao.jingmo.ui.screen.festival.nav

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hefengbao.jingmo.ui.screen.festival.FestivalRoute
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

internal const val festivalIdArg = "festivalId"

internal class FestivalArgs(val festivalId: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(URLDecoder.decode(checkNotNull(savedStateHandle[festivalIdArg]), UTF_8.name()))
}

fun NavController.navigateToFestival(id: String) {
    val encodedId = URLEncoder.encode(id, UTF_8.name())
    this.navigate("festival/$encodedId") {
        launchSingleTop = true
    }
}

fun NavGraphBuilder.festivalScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = "festival/{$festivalIdArg}",
        arguments = listOf(
            navArgument(name = festivalIdArg) {
                type = NavType.StringType
            }
        )
    ) {
        FestivalRoute(
            onBackClick = onBackClick
        )
    }
}