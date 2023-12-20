package fd.abovebd.dsa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(title: String,onClick: () -> Unit) {
    TopAppBar(title = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                Icons.Default.Menu,
                tint = Color.Black,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onClick()
                    }
                    .height(45.dp)
                    .width(45.dp)
                    .padding((0.dp))

            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = title, style = TextStyle(
                    fontSize = 19.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF111827),
                )
            )
        }

    }, colors = TopAppBarDefaults.topAppBarColors(Color(0xFFDCE4EC)))
}

@Composable
fun CheckOutMainPage(onClick: (key:String) -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color.White)
            .padding(15.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Jorenrui Merch", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF111827),
                )
            )
            Text(
                text = "Add Items", style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF1D4ED8),
                )
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        CardItem(
            image = R.drawable.demo_img,
            title = "Boom Jacket",
            price = "4,300.00",
            id = "JMU#0021321230214",
            quality = "2",
            size = "S",
            color = "Brown"
        )
        CardItem(
            image = R.drawable.demo_image_two,
            title = "Leather Sling Baggu",
            price = "1,299.00",
            id = "JMU#0014582134383y25",
            quality = "1",
            size = "M",
            color = "Red"
        )
        Spacer(modifier = Modifier.height(10.dp))
        PaymentMethod(cardHolderName = "Firad Fd", cardLastDigits = "2195")
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Shipping Information", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF111827),
                )
            )
            Text(
                text = "Edit", style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF1D4ED8),
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Joeylene Rivera", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF111827),
                )
            )
            Text(
                text = "221B Baker Street, London", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6B7280),
                )
            )
            Text(
                text = "0273 287 5834", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF6B7280),
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.Black)
        ) {}
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Subtotal", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
            Text(
                text = "₱ 5,599.00", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Taxes", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
            Text(
                text = "₱ 20.00", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total", style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 30.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
            Text(
                text = "₱ 5,619.00", style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 30.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(text = "Place Order") {
            onClick.invoke(Navigation.HOME.value)
        }
    }


}


@Composable
fun CardItem(
    image: Int,
    title: String,
    price: String,
    id: String,
    quality: String,
    size: String,
    color: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(bottom = 10.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color(0xFFFFFFFF)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title, style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF111827),

                        ), modifier = Modifier.width(100.dp)
                )
                Text(
                    text = id, style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6B7280),
                    )
                )
                Text(
                    text = "Size: $size", style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6B7280),
                    )
                )
                Text(
                    text = "Color: $color", style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6B7280),
                    )
                )
                Text(
                    text = "Edit Details", style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF1D4ED8),
                    )
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            Column(
                verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "₱ $price", maxLines = 1, style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Right,
                    )
                )
                Text(
                    text = "Qty. $quality", style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF6B7280),
                        textAlign = TextAlign.Right,
                    )
                )
            }
            Icon(Icons.Outlined.Delete, contentDescription = null, tint = Color(0xFF6B7280))
        }
    }

}

@Composable
fun PaymentMethod(cardHolderName: String, cardLastDigits: String) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        Text(
            text = "Payment Method", style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Image(painterResource(id = R.drawable.mastercard), contentDescription = null)
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = cardHolderName, style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF111827),
                        )
                    )
                    Text(
                        text = "**** $cardLastDigits", style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF6B7280),
                        )
                    )
                }
            }
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
            )
        }


    }

}