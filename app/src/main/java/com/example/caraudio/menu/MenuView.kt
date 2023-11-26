import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.navigation.NavRoutes

@Composable
fun MenuView(navController: NavController, onMenuItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Menu",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Divider(modifier = Modifier.padding(vertical = 4.dp))

        // Lista de elementos de menú
        val menuItems = listOf(
            "Datos de facturación",
            "Datos de envío",
            "Mis pedidos",
            "Comprar de nuevo",
            "Idioma",
            "Califica nuestra aplicación",
            "Permisos",
            "Notificaciones",
            "Acerca de la app",
            "Redes sociales",
            "Cierra Sesión"
        )

        menuItems.forEach { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // Manejar la acción basada en el elemento de menú seleccionado
                        when (item) {
                            "Cierra Sesión" -> {
                                navController.navigate(route = NavRoutes.Intro.route)                            }
                            else -> {
                                // Manejar la acción por defecto
                                // Puedes definir una acción predeterminada aquí
                            }
                        }
                        // Llamar a la función proporcionada onMenuItemClick con el nombre del elemento de menú
                        onMenuItemClick(item)
                    }
                    .padding(vertical = 12.dp),
                fontSize = 23.sp
            )
            Divider()
        }
    }
}

@Preview
@Composable
fun MenuViewPreview() {
    val navController = rememberNavController()
    MenuView(navController = navController, onMenuItemClick = {})
}
