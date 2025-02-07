package com.hefengbao.jingmo.ui.screen.festival

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hefengbao.jingmo.data.model.Festival
import com.hefengbao.jingmo.data.repository.FestivalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FestivalListViewModel @Inject constructor(
    private val repository: FestivalRepository
) : ViewModel() {
    private val _festivals: MutableStateFlow<List<Festival>> = MutableStateFlow(emptyList())
    val festivals: SharedFlow<List<Festival>> = _festivals

    fun getList() {
        viewModelScope.launch {
            _festivals.value = repository.getList()
        }
    }
}