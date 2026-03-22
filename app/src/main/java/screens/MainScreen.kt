package screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import components.Contact

@Composable
fun MainScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val contactList = remember {
        mutableStateListOf(
            Pair("Ana García", "612345678"),
            Pair("Carlos Rodríguez", "699888777")
        )
    }

    Column {

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = phone,
            onValueChange = {
                if (it.length <= 10) phone = it.filter { c -> c.isDigit() }
            },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )

        // 🔹 BOTÓN AGREGAR
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .background(Color(0xFF3D5AFE), RoundedCornerShape(10.dp))
                .clickable {
                    if (name.isNotEmpty() && phone.length == 10) {
                        contactList.add(Pair(name, phone))
                        name = ""
                        phone = ""
                    }
                }
                .padding(15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Agregar Contacto", color = Color.White)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .background(Color.LightGray, RoundedCornerShape(10.dp))
                .clickable {
                    name = ""
                    phone = ""
                }
                .padding(15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Limpiar Campos")
        }

        LazyColumn {
            items(contactList) { contact ->
                Contact(
                    name = contact.first,
                    phone = contact.second
                )
            }
        }
    }
}
