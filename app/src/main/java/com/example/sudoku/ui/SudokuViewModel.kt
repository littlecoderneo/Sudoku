package com.example.sudoku.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SudokuViewModel : ViewModel() {
    //object that is used to modify UI data from the currency converter data class
    private val _uiState = MutableStateFlow(SudokuUiState())

    //backing property to avoid state update from other classes
    val uiState : StateFlow<SudokuUiState> = _uiState.asStateFlow()

    fun updateMode(mode:String){
        _uiState.value = _uiState.value.copy(selectedMode = mode)
    }

    fun updateSelectedGrid(selectedGrid:IntArray){
        _uiState.value = _uiState.value.copy(selectedGrid = selectedGrid)
    }

    fun getBoard():Array<IntArray>{
        return _uiState.value.board
    }
}