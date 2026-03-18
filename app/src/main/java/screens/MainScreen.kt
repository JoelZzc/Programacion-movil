package screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.remote.creation.first
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import components.Contact
import kotlin.time.Duration.Companion.seconds

@Composable
fun MainScreen(navController: NavController){
    val contacs = listOf(Pair( first = "Juan Perez", second = "612-305-0012"))

    //lista en un estado
    val contactList = remember { mutableStateOf(Pair) }

    LazyColumn() {
        items( contacs){
            contact ->
            Contact(name = contact.first, phone= contact.second)

            //agregar elementos

            contactList.add(Pair(firs = name, second= phone))
        }
    }
}

