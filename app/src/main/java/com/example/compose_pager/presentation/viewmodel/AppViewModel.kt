package com.example.compose_pager.presentation.viewmodel

import androidx.compose.foundation.pager.rememberPagerState
import androidx.lifecycle.ViewModel

class AppViewModel() : ViewModel() {
    var currentPage = 0
    fun nextPage() {
        if (currentPage < 3)
            currentPage++
    }


}