package com.example.sudoku.ui

import androidx.compose.runtime.MutableState
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


    fun updatedHintMode(hint:MutableState<Boolean>){
        hint.value = !hint.value
        _uiState.value = _uiState.value.copy(showHint = hint)
    }

    fun updateMode(mode:String){
        _uiState.value = _uiState.value.copy(selectedMode = mode)
    }

    fun updateSelectedGrid(selectedGrid:MutableList<Int>){
        _uiState.value = _uiState.value.copy(selectedGrid = selectedGrid)
    }

    fun updateBoard(number:Int) {
        val index = getSelectedGrid()[1] *9+ getSelectedGrid()[0]
        if (getSelectedMode() == "Normal"){
            getModeBoard()[index] = 0
        }else{
            getModeBoard()[index] = 1
        }

        getSudokuBoard()[index] = number
        _uiState.value = _uiState.value.copy(board = getSudokuBoard())
        _uiState.value = _uiState.value.copy(modeBoard = getModeBoard())
    }

    private fun getSudokuBoard(): MutableList<Int> {
        return _uiState.value.board
    }

    private fun getModeBoard(): MutableList<Int> {
        return _uiState.value.modeBoard
    }

    private fun getSelectedGrid(): MutableList<Int> {
        return _uiState.value.selectedGrid
    }


    private fun getSelectedMode(): String {
        return _uiState.value.selectedMode
    }


}