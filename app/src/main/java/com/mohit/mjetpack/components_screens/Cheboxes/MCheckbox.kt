package com.mohit.mjetpack.components_screens.Cheboxes

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.mohit.mjetpack.components_screens.TopBar

data class Topping(val id: Int, val name: String, var isSelected: Boolean = false)


@Composable
fun MCheckbox(navController: NavController) {

    val allToppings = arrayOf(
        "Mushrooms", "Bell peppers", "Onions", "Tomatoes", "Olives",
        "Pepperoni", "Sausage", "Bacon", "Ham", "Chicken",
        "Mozzarella", "Parmesan", "Cheddar", "Gorgonzola", "Feta",
        "Spinach", "Broccoli", "Artichokes", "Zucchini", "Caramelized onions",
        "Jalapeños", "Chili flakes", "Banana peppers", "Chipotle peppers", "Spicy sausage"
    )

    val toppingList = remember {
        mutableStateListOf<Topping>().apply {
            allToppings.forEachIndexed {index, item ->
                add(Topping(index, item, false))
            }
        }
    }

    Scaffold(
        topBar = {
            TopBar(title = "Checkboxes") {
                navController.popBackStack()
            }
        },
    ){

        Box(modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)) {
            LazyColumn(modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxHeight(.95f)
                .background(color = MaterialTheme.colorScheme.primary)) {
                item {
                    Text(text = "Please select pizza toppings.", modifier = Modifier.padding(10.dp), color = MaterialTheme.colorScheme.secondary)
                }
                items(toppingList) {item ->
                    PizzaToppingItem(item = item, modifier = Modifier)
                }
            }
            ElevatedButton(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).align(Alignment.BottomCenter),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                ),
                onClick = {
                    Log.d("TAG", "MCheckbox: ${Gson().toJson(toppingList)}")
                }) {
                Text(text = "Save", color = MaterialTheme.colorScheme.primary)
            }
        }

    }
}


@Composable
fun PizzaToppingItem(item: Topping, modifier: Modifier) {
    var checkedState by rememberSaveable {
        mutableStateOf(item.isSelected)
    }
    PizzaToppingItem(item = item, checked = checkedState, onChecked = {newState ->
        run {
            checkedState = newState
            item.isSelected = newState
        }
    } , onClose = {})
}


@Composable
fun PizzaToppingItem(
    item: Topping,
    checked : Boolean,
    onChecked : (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            colors = CheckboxDefaults.colors(
//                checkedColor = MaterialTheme.colorScheme.secondary,
//                uncheckedColor = MaterialTheme.colorScheme.secondary,
//                checkmarkColor = MaterialTheme.colorScheme.primary
//            ),
//            checked = checked, onCheckedChange = onChecked)
        IconButton(onClick = { onChecked(!item.isSelected) }) {
            Icon(imageVector = if (checked) Icons.Default.CheckCircle else Icons.Outlined.CheckCircle,
                contentDescription = "Checked", tint = MaterialTheme.colorScheme.secondary)
        }
        Spacer(modifier = Modifier.width(10.dp))
        TextButton(onClick = { onChecked(!item.isSelected) }) {
            Text(text = item.name, color = MaterialTheme.colorScheme.secondary)
        }
    }
}
