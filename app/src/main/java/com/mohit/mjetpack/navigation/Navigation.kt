package com.mohit.mjetpack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mohit.mjetpack.componen.Splash
import com.mohit.mjetpack.components_screens.Badges.badgesScreen
import com.mohit.mjetpack.components_screens.BottomSheets.MBottomSheet
import com.mohit.mjetpack.components_screens.Cards.cards
import com.mohit.mjetpack.components_screens.Cheboxes.MCheckbox
import com.mohit.mjetpack.components_screens.Chips.MChips
import com.mohit.mjetpack.components_screens.DatePicker.MDatePicker
import com.mohit.mjetpack.components_screens.Dialogs.MDialogs
import com.mohit.mjetpack.components_screens.Dividers.MDivider
import com.mohit.mjetpack.components_screens.Lists.MLists
import com.mohit.mjetpack.components_screens.MButtons.buttons
import com.mohit.mjetpack.components_screens.MJetPack
import com.mohit.mjetpack.components_screens.MTopBar.topBars
import com.mohit.mjetpack.components_screens.Menus.MMenus
import com.mohit.mjetpack.components_screens.NavigationBar.MNavigationBottomBar
import com.mohit.mjetpack.components_screens.NavigationBar.MNavigationDrawerBar
import com.mohit.mjetpack.components_screens.NavigationBar.MNavigationRail
import com.mohit.mjetpack.components_screens.ProgressIndicators.MProgressIndicators
import com.mohit.mjetpack.components_screens.RadioButtons.MRadioButtons
import com.mohit.mjetpack.components_screens.Sliders.MSliders
import com.mohit.mjetpack.components_screens.SnackBar.MSnackBar
import com.mohit.mjetpack.components_screens.Switch.MSwitch
import com.mohit.mjetpack.components_screens.Tabs.MTab
import com.mohit.mjetpack.components_screens.TextFields.MTextFields
import com.mohit.mjetpack.components_screens.TimePickers.MTimePickers
import com.mohit.mjetpack.components_screens.ToolTips.MToolTip
import com.mohit.mjetpack.components_screens.homeScreen
import com.mohit.mjetpack.utilities.Routes

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SPLASH.name) {

        composable(route = Routes.SPLASH.name) {
            Splash {
                navController.navigate(it) {
                    popUpTo(Routes.SPLASH.name) {
                        inclusive = true
                    }
                }
            }
        }

        composable(route = Routes.HOME.name) {
            homeScreen {
                navController.navigate(it)
            }
        }

        composable(route = Routes.MJETPACK.name) {
            MJetPack(navController = navController) {
                navController.navigate(it)
            }
        }

        composable(route = Routes.TOP_BAR.name) {
            topBars(navController = navController)
        }

        composable(route = Routes.TOP_BAR.name) {
            topBars(navController = navController)
        }

        composable(route = Routes.BADGES.name) {
            badgesScreen(navController)
        }

        composable(route = Routes.BUTTONS.name) {
            buttons(navController)
        }

        composable(route = Routes.CARDS.name) {
            cards(navController)
        }

        composable(route = Routes.CHECKBOX.name) {
            MCheckbox(navController)
        }

        composable(route = Routes.CHIPS.name) {
            MChips(navController)
        }

        composable(route = Routes.DATE_PICKER.name) {
            MDatePicker(navController)
        }

        composable(route = Routes.DIALOGS.name) {
            MDialogs(navController)
        }

        composable(route = Routes.DIVIDER.name) {
            MDivider(navController)
        }

        composable(route = Routes.LISTS.name) {
            MLists(navController)
        }

        composable(route = Routes.MENUS.name) {
            MMenus(navController)
        }

        composable(route = Routes.NAVIGATION_BOTTOM_BAR.name) {
            MNavigationBottomBar(navController)
        }

        composable(route = Routes.NAVIGATION_DRAWER.name) {
            MNavigationDrawerBar(navController)
        }
        composable(route = Routes.NAVIGATION_RAIL.name) {
            MNavigationRail(navController)
        }

        composable(route = Routes.PROGRESS_INDICATORS.name) {
            MProgressIndicators(navController)
        }

        composable(route = Routes.RADIO_BUTTONS.name) {
            MRadioButtons(navController)
        }

        composable(route = Routes.BOTTOM_SHEET.name) {
            MBottomSheet(navController)
        }

        composable(route = Routes.SLIDERS.name) {
            MSliders(navController)
        }

        composable(route = Routes.SNACKBAR.name) {
            MSnackBar(navController)
        }

        composable(route = Routes.SWITCH.name) {
            MSwitch(navController)
        }

        composable(route = Routes.TABS.name) {
            MTab(navController)
        }

        composable(route = Routes.TEXT_FIELDS.name) {
            MTextFields(navController)
        }

        composable(route = Routes.TIME_PICKERS.name) {
            MTimePickers(navController)
        }

        composable(route = Routes.TOOLTIPS.name) {
            MToolTip(navController = navController)
        }
    }
}