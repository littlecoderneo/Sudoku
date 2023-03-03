package com.example.sudoku

import androidx.compose.runtime.mutableStateListOf
import com.example.sudoku.ui.SudokuCell

val sudokulist: List<Int> = listOf(0, 9, 6, 0, 0, 2, 8, 0, 4, 5, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 9, 3, 0, 9, 0, 8, 5, 0, 0, 3, 0, 0, 0, 3, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, 9, 0, 0, 6, 0, 0, 5, 0, 0, 7, 0, 2, 0, 0, 0, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3)
val boardData : MutableList<SudokuCell> = getBoard()

fun getBoard():MutableList<SudokuCell>{
    val boardData : MutableList<SudokuCell> = mutableStateListOf()
    for(cell in sudokulist){
        boardData.add(SudokuCell(cell, modeNormal = true, block = false))
    }
    return boardData
}