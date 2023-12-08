import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.caraudio.home.view.BottomNavBar
import com.example.caraudio.login.viewModel.LoginViewModel
import com.example.caraudio.navigation.NavRoutes

@Composable
fun MenuView(
    navController: NavController,
    onMenuItemClick: (String) -> Unit,
    viewModel: LoginViewModel // Asegúrate de que LoginViewModel está correctamente importado
){
    val context = LocalContext.current

    Scaffold(
        bottomBar = { BottomNavBar(navController = navController, Modifier) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
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
                "Billing address",
                "Shipping address",
                "My orders",
                "Buy again",
                "Language",
                "About app",
                "Sign out"
            )

            menuItems.forEach { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            when (item) {
                                "Sign out" -> {
                                    viewModel.clearSession(context)
                                    navController.navigate(NavRoutes.Login.route) {
                                        popUpTo(NavRoutes.Home.route) { inclusive = true }
                                    }
                                }
                                "About app" -> navController.navigate(NavRoutes.About.route)


                                else -> {
                                    // Manejar la acción por defecto
                                }
                            }
                            onMenuItemClick(item)
                        }
                        .padding(vertical = 12.dp),
                    fontSize = 23.sp
                )
                Divider()
            }
        }
    }
}

@Preview
@Composable
fun MenuViewPreview() {
    val navController = rememberNavController()
    MenuView(navController = navController, onMenuItemClick = {}, viewModel = LoginViewModel())
}
