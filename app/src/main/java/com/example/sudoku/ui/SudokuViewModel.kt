package com.example.sudoku.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    fun updateSelectedGrid(selectedGrid:MutableList<Int>){
        _uiState.value = _uiState.value.copy(selectedGrid = selectedGrid)
    }

    fun updateBoard(updatedBoard:MutableList<Int>) {

        val index = getSelectedGrid()[1] *9+ getSelectedGrid()[0]
        println(index)
        updatedBoard[index] = 9
        _uiState.value = _uiState.value.copy(board = updatedBoard)
    }

    fun getSudokuBoard(): MutableList<Int> {
        return _uiState.value.board
    }

    fun getSelectedGrid(): MutableList<Int> {
        return _uiState.value.selectedGrid
    }




}