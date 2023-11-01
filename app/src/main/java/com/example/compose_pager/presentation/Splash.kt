package com.example.compose_pager.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose_pager.R
import com.example.compose_pager.navigation.NavigationItem
import com.example.compose_pager.ui.theme.titleFontFamily
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(NavigationItem.Onboarding.route)

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.orange)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Text(
            text = stringResource(id = R.string.online_market),
            fontSize = 23.sp,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = titleFontFamily
        )


    }
}