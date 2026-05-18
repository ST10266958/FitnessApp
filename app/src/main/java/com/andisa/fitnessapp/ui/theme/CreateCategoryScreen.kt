package com.andisa.fitnessapp.ui.theme

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.andisa.fitnessapp.data.AppDatabase
import com.andisa.fitnessapp.data.entity.Category
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CreateCategoryScreen() {

    val context = LocalContext.current
    val db = AppDatabase.getDatabase(context)

    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Category Name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            CoroutineScope(Dispatchers.IO).launch {

                db.categoryDao().insertCategory(
                    Category(
                        name = name,
                        description = description
                    )
                )
            }

            Toast.makeText(
                context,
                "Category Saved",
                Toast.LENGTH_SHORT
            ).show()

        }) {
            Text("Save Category")
        }
    }
}

