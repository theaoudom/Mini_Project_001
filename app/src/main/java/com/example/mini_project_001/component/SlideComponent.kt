package com.example.mini_project_001.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import com.example.mini_project_001.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun Slide(){
    val item = listOf(
        R.drawable.slide_1,
        R.drawable.slide2,
        R.drawable.slide3
    )

    val pageState = rememberPagerState {item.size}

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()){
            HorizontalPager(
                state = pageState,
                pageSize = PageSize.Fill,
                pageSpacing = 8.dp,
                modifier = Modifier.fillMaxSize()) { page ->
                CardComponent(item[page])
            }
        }
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f)){
            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {
                repeat(pageState.pageCount) { iteration ->
                    val color = if (pageState.currentPage == iteration) Color.LightGray else Color.DarkGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(8.dp)
                    )
                }
            }

        }
    }

    LaunchedEffect(pageState) {
        while (true) {
            delay(3000)
            val nextPage = (pageState.currentPage + 1) % item.size
            pageState.animateScrollToPage(nextPage)
        }
    }
}

@Composable
fun CardComponent(index: Int){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(Color.White, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp)
            ){
            Image(painter = painterResource(id = index), contentDescription = null, modifier = Modifier
                .fillMaxSize()
                , contentScale = ContentScale.Crop)
        }
}