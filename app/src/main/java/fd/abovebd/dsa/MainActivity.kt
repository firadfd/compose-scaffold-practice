package fd.abovebd.dsa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fd.abovebd.dsa.ui.theme.DSATheme
import fd.abovebd.dsa.ui.theme.backgroundColor
import fd.abovebd.dsa.ui.theme.editTextBackgroundColor
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DSATheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val coroutine = rememberCoroutineScope()
                val navController = rememberNavController()
                ModalNavigationDrawer(gesturesEnabled = drawerState.isOpen, drawerContent = { ModalDrawerSheet(modifier = Modifier.fillMaxWidth(.8f).background(color = Color.White)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.header),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = Color.Cyan)
                        )
                    }
                    Column(
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.padding(10.dp)
                        ) {
                            DrawerItem(title = "Registration", Icons.Default.Home) {
                                coroutine.launch {
                                    navController.navigate(Navigation.HOME.value)
                                    drawerState.close()
                                }
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            DrawerItem(title = "CheckOut", Icons.Default.ShoppingCart) {
                                coroutine.launch {
                                    navController.navigate(Navigation.CHECKOUT.value)
                                    drawerState.close()
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))
                            DrawerItem(title = "Payment Methods", Icons.Default.MailOutline) {
                                coroutine.launch {
                                    navController.navigate(Navigation.PAYMENT.value)
                                    drawerState.close()
                                }
                            }
                        }
                    }

                }, drawerState = drawerState) {
                    Scaffold(topBar = {
                        CustomTopAppBar("TENSI") {
                            coroutine.launch {
                                drawerState.open()
                            }
                        }
                    }) {
                        Column(
                            modifier = Modifier
                                .padding(it)
                                .background(color = Color.White)
                        ) {
                            MainApp(navController)
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun MainApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Navigation.HOME.value) {
        composable(route = Navigation.HOME.value) {
            MainActivityScreen {
                if (it == Navigation.CHECKOUT.value) {
                    navController.navigate(Navigation.CHECKOUT.value)
                } else if (it == Navigation.PAYMENT.value) {
                    navController.navigate(Navigation.PAYMENT.value)
                }
            }
        }
        composable(route = Navigation.CHECKOUT.value) {
            CheckOutMainPage {
                navController.navigate(Navigation.PAYMENT.value)
            }
        }
        composable(route = Navigation.PAYMENT.value) {
            MainPaymentBody {
                navController.navigate(Navigation.HOME.value)
            }
        }
    }

}

@Composable
fun MainActivityScreen(onClick: (key: String) -> Unit) {
    var name by remember {
        mutableStateOf("")
    }
    var userName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var pass by remember {
        mutableStateOf("")
    }
    var conPass by remember {
        mutableStateOf("")
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = backgroundColor)
            .padding(15.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Create an account.",
            modifier = Modifier
                .width(263.dp)
                .height(45.dp),
            style = TextStyle(
                fontSize = 30.sp,
                lineHeight = 45.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
            )
        )
        Text(
            text = "Start building your brand and grow your community.", style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = Color.Black,
            )
        )
        Text(
            text = "Already have an account? Sign in", style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = Color.Black,
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Name", modifier = Modifier.padding(5.dp), style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
            )
        )
        CustomEditText(hint = "Enter your name", text = name, onTextChange = {
            name = it
        })
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Username", modifier = Modifier.padding(5.dp), style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
            )
        )
        CustomEditText(hint = "Enter your username", text = userName, onTextChange = {
            userName = it
        })
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Email", modifier = Modifier.padding(5.dp), style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
            )
        )
        CustomEditText(hint = "Enter your email", text = email, onTextChange = {
            email = it
        })
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Password", modifier = Modifier.padding(5.dp), style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
            )
        )
        CustomEditText(hint = "Enter your password", text = pass, onTextChange = {
            pass = it
        })
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Confirm Password", modifier = Modifier.padding(5.dp), style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontWeight = FontWeight(500),
                color = Color.Black,
            )
        )
        CustomEditText(hint = "Enter your confirm password", text = conPass, onTextChange = {
            conPass = it
        })
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(text = "Register") {
            onClick(Navigation.CHECKOUT.value)
        }
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "or you can",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 18.sp,
                color = Color.Black,
            )
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomSignUpButton(text = "Continue with Google", R.drawable.google) {
            onClick(Navigation.PAYMENT.value)
        }
        Spacer(modifier = Modifier.height(12.dp))
        CustomSignUpButton(text = "Continue with Twitter", R.drawable.twitter) {
            onClick(Navigation.PAYMENT.value)
        }
    }

}


@Composable
fun CustomEditText(hint: String, text: String, onTextChange: (String) -> Unit) {
    OutlinedTextField(value = text,
        onValueChange = { onTextChange.invoke(it) },
        textStyle = TextStyle(color = Color.Black),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(color = editTextBackgroundColor),
        placeholder = {
            Text(
                text = hint, color = Color(0xFF9CA3AF)
            )
        })
}


@Composable
fun CustomButton(text: String, onButtonClicked: () -> Unit) {
    ElevatedButton(
        onClick = {
            onButtonClicked.invoke()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .pointerHoverIcon(PointerIcon.Crosshair),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF111827))

    ) {
        Text(text = text, style = TextStyle(color = Color.White))
    }
}

@Composable
fun CustomSignUpButton(text: String, icon: Int, onButtonClicked: () -> Unit) {
    OutlinedButton(
        onClick = {
            onButtonClicked.invoke()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE5E7EB))
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(id = icon), contentDescription = null, tint = Color(0xFF6B7280)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = text, textAlign = TextAlign.Center, style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF6B7280),
                )
            )

        }
    }
}


