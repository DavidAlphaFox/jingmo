package com.hefengbao.wenqu.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hefengbao.wenqu.ui.screen.chinesewisecrack.nav.chineseWisecrackGraph
import com.hefengbao.wenqu.ui.screen.chinesewisecrack.nav.navigateToChineseWisecrackGraph
import com.hefengbao.wenqu.ui.screen.home.nav.ROUTE_HOME_GRAPH
import com.hefengbao.wenqu.ui.screen.home.nav.homeGraph
import com.hefengbao.wenqu.ui.screen.idiom.nav.idiomGraph
import com.hefengbao.wenqu.ui.screen.idiom.nav.navigateToIdiomGraph
import com.hefengbao.wenqu.ui.screen.poem.nav.navigateToPoemGraph
import com.hefengbao.wenqu.ui.screen.poem.nav.poemGraph
import com.hefengbao.wenqu.ui.screen.poemsentence.nav.navigateToPoemSentenceGraph
import com.hefengbao.wenqu.ui.screen.poemsentence.nav.poemSentenceGraph
import com.hefengbao.wenqu.ui.screen.settings.nav.aboutScreen
import com.hefengbao.wenqu.ui.screen.settings.nav.navigateToAboutScreen
import com.hefengbao.wenqu.ui.screen.settings.nav.navigateToPrivacyScreen
import com.hefengbao.wenqu.ui.screen.settings.nav.navigateToSettingsGraph
import com.hefengbao.wenqu.ui.screen.settings.nav.privacyScreen
import com.hefengbao.wenqu.ui.screen.settings.nav.settingsGraph

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_HOME_GRAPH
    ) {
        homeGraph(
            onSettingsClick = { navController.navigateToSettingsGraph() },
            onPoemClick = { navController.navigateToPoemGraph() },
            onPoemSentenceClick = { navController.navigateToPoemSentenceGraph() },
            onChineseWisecrackClick = { navController.navigateToChineseWisecrackGraph() },
            onIdiomClick = { navController.navigateToIdiomGraph() },
            nestGraph = {
                poemGraph(
                    onBackClick = navController::navigateUp,
                    nestGraph = {}
                )
                poemSentenceGraph(
                    onBackClick = navController::navigateUp,
                    nestGraph = {}
                )
                chineseWisecrackGraph(
                    onBackClick = navController::navigateUp,
                    nestGraph = {}
                )
                idiomGraph(
                    onBackClick = navController::navigateUp,
                    nestGraph = {}
                )
                settingsGraph(
                    onBackClick = navController::navigateUp,
                    onAboutClick = { navController.navigateToAboutScreen() },
                    onPrivacyClick = { navController.navigateToPrivacyScreen() },
                    nestGraph = {
                        aboutScreen(
                            onBackClick = navController::navigateUp
                        )
                        privacyScreen(
                            onBackClick = navController::navigateUp
                        )
                    }
                )
            }
        )
    }
}