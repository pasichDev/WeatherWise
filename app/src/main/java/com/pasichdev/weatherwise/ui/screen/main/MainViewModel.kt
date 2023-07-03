package com.pasichdev.weatherwise.ui.screen.main

import androidx.lifecycle.ViewModel
import com.pasichdev.weatherwise.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var appRepository: AppRepository,
) : ViewModel() {
}