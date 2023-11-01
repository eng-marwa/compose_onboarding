package com.example.compose_pager.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.compose_pager.OnboardingEntity
import com.example.compose_pager.R
import com.example.compose_pager.navigation.NavigationItem
import com.example.compose_pager.presentation.viewmodel.AppViewModel
import com.example.compose_pager.ui.theme.descriptionFontFamily
import com.example.compose_pager.ui.theme.titleFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(navController: NavController) {

    val onboardingList = listOf<OnboardingEntity>(
        OnboardingEntity(
            R.string.onboarding_title_1,
            R.drawable.page1, R.drawable.step1,
            R.string.onboarding_description_1,
            false
        ),
        OnboardingEntity(
            R.string.onboarding_title_2,
            R.drawable.page2, R.drawable.step2,
            R.string.onboarding_description_2,
            false
        ),
        OnboardingEntity(
            R.string.onboarding_title_3,
            R.drawable.page3, R.drawable.step3,
            R.string.onboarding_description_3,
            true
        ),
    )
    val pagerState = rememberPagerState(pageCount = {
        onboardingList.size
    })

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(state = pagerState, modifier = Modifier.wrapContentSize()) { currentPage ->
            OnboardingItem(onboardingList[currentPage], navController, pagerState)
        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingItem(
    onboardingEntity: OnboardingEntity,
    navController: NavController,
    pagerState: PagerState,
) {

    val coroutineScope = rememberCoroutineScope()

    var isLastPage: Boolean by remember { mutableStateOf<Boolean>(onboardingEntity.isLastPage) }
    Column(
        Modifier
            .wrapContentSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally,

        ) {
        if (!isLastPage) {
            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        navController.popBackStack()
                        navController.navigate(NavigationItem.Home.route)
                    },
                color = Color.Gray,
                text = stringResource(R.string.skip),
                fontSize = 16.sp, lineHeight = 40.sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold,
                fontFamily = descriptionFontFamily
            )
            Spacer(modifier = Modifier.height(40.dp))
        }
        Text(
            color = Color.Black,
            text = stringResource(onboardingEntity.title),
            fontSize = 30.sp, lineHeight = 40.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = titleFontFamily
        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = onboardingEntity.image),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            color = Color.Black,
            text = stringResource(onboardingEntity.description),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = descriptionFontFamily
        )

        Spacer(modifier = Modifier.height(50.dp))
        Row(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            Arrangement.SpaceBetween,
            Alignment.Bottom,

            ) {
            Image(
                modifier = Modifier.padding(bottom = 20.dp),
                painter = painterResource(id = onboardingEntity.step),
                contentDescription = ""
            )
            Button(

                onClick = {
                    var page = pagerState.currentPage
                    if (page != 2) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(++page)
                        }
                    } else {
                        navController.popBackStack()
                        navController.navigate(NavigationItem.Home.route)
                    }

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.orange) // Set the color resource
                )

            ) {
                Text(
                    modifier = Modifier.width(80.dp), text =
                    if (isLastPage) stringResource(id = R.string.proceed) else stringResource(id = R.string.next),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = descriptionFontFamily
                )
            }
        }


    }
}