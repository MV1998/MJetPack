package com.mohit.mjetpack.utilities

import android.view.View
import androidx.compose.material3.Text


data class Route(val title : String,
    val path : String)

object ComponentList {
    val list = listOf(
        Route("Top bars", Routes.TOP_BAR.name),
//        Route("Bottom bars", Routes.BOTTOM_BAR.name),
        Route("Badges", "badges"),
        Route("Buttons", "buttons"),
        Route("Cards", "cards"),
       // Route("Carousel", "carousel"),
        Route("Checkbox", "checkbox"),
        Route("Chips", "chips"),
        Route("Date pickers", "date_picker"),
        Route("Dialogs", "dialogs"),
        Route("Divider", "divider"),
        Route("Lists", "lists"),
        Route("Menus", "menus"),
        Route("Navigation Bottom", "navigation_bottom_bar"),
        Route("Navigation Drawer", "navigation_drawer"),
        Route("Navigation Rail", "navigation_rail"),
        Route("Progress Indicators", "progress_indicators"),
        Route("Radio Buttons", "radio_buttons"),
      //  Route("Search", "search"),
        Route("Sheets", Routes.BOTTOM_SHEET.name),
        Route("Sliders", "sliders"),
        Route("Snackbar", "snackbar"),
        Route("Switch", "switch"),
        Route("Tabs", "tabs"),
        Route("Text Fields", "text_fields"),
        Route("Time pickers", "time_pickers"),
        Route("Tooltips", "tooltips")
      )
}