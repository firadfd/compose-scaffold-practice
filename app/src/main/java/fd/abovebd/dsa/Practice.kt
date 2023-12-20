package fd.abovebd.dsa

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

enum class Navigation(val value: String) {
    HOME("HomePage"),
    CHECKOUT("CheckOutPage"),
    PAYMENT("PaymentPage")
}


@Composable
fun DrawerItem(title: String, icon: ImageVector, onItemClick: () -> Unit) {

    Row(modifier = Modifier
        .clip(RoundedCornerShape(topStart = 25.dp, bottomEnd = 25.dp))
        .background(color = Color.Gray)
        .fillMaxWidth()
        .height(50.dp)
        .clickable {
            onItemClick()
        }
        ,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
        Spacer(modifier = Modifier.width(10.dp))
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = title)
    }


}

