package com.sur_tec.helmetiq

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sur_tec.helmetiq.navigation.Screens

@Composable

fun Mainscreen(navController: NavHostController , modifier: Modifier = Modifier) {

    var switchState by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        HeaderTitle()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Helmet Image
            HelmetImage()
            Spacer(modifier = Modifier.height(3.dp))
            // Battery and Bluetooth Icons
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_battery),
                    contentDescription = "Battery",
                    tint = Color.Gray,
                    modifier = Modifier.size(32.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_bluetooth),
                    contentDescription = "Bluetooth",
                    tint = Color.Gray,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Headlights Toggle
            HeadLight(switchState) {
                switchState = it
            }
        }

        // Placeholder for Map, replace with an actual map implementation
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            BasicText(text = "Map View Placeholder")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp)
                .background(Color.LightGray),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Total Distance Traveled: 10 Miles",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()
                .background(Color.LightGray),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Ride Time: 58 Minutes",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
      /*  Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(

                onClick = { navController.navigate(Screens.MAINSCREEN.name) },
                modifier = Modifier.padding(0.dp, 6.dp)

            ) {
                Text("Home")
            }
            Button(
                onClick = { navController.navigate(Screens.CONTACTSSCREEN.name) },
                modifier = Modifier.padding(0.dp, 6.dp)


            ) {
                Text("SOS Contacts")
            }

        }*/
    }
}

@Composable

private fun HeadLight(switchState: Boolean = false, onSwitchChanged: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Headlights", fontSize = 20.sp, color = Color.Gray,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.width(8.dp))
        Switch(
            checked = switchState, // Replace with actual state
            onCheckedChange = {
                onSwitchChanged(it)
            },
            colors = SwitchDefaults.colors(checkedThumbColor = Color.Gray)
        )
    }
}

@Composable
private fun HelmetImage() {
    Image(
        painter = painterResource(id = R.drawable.helmet_image), // Replace with your image resource
        contentDescription = "Helmet",
        modifier = Modifier.size(140.dp),
        contentScale = ContentScale.Fit
    )
}

@Composable
@Preview(showBackground = true)
private fun HeaderTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "HelmetIQ",
            fontSize = 24.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 10.dp)

        )
    }
}