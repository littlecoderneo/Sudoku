package com.example.sudoku.ui

import com.example.sudoku.data.tipData

data class SudokuUiState(
    val selectedMode: String = tipData[0],
    val selectedGrid: IntArray = intArrayOf(0,0),
    val board: Array<IntArray> = arrayOf(
        intArrayOf(0,9,6,0,0,2,8,0,4),
        intArrayOf(5,0,0,0,1,0,0,0,0),
        intArrayOf(0,0,2,0,0,0,9,3,0),
        intArrayOf(9,0,8,5,0,0,3,0,0),
        intArrayOf(0,3,0,0,2,0,0,0,0),
        intArrayOf(0,1,0,0,9,0,0,6,0),
        intArrayOf(0,5,0,0,7,0,2,0,0),
        intArrayOf(0,4,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,3)
    ),
    val solution:Array<IntArray> = arrayOf(
        intArrayOf(3,9,6,7,5,2,8,1,4),
        intArrayOf(5,8,4,9,1,3,7,2,6),
        intArrayOf(1,7,2,8,4,6,9,3,5),
        intArrayOf(9,2,8,5,6,1,3,4,7),
        intArrayOf(6,3,5,4,2,7,1,8,9),
        intArrayOf(4,1,7,3,9,8,5,6,2),
        intArrayOf(8,5,3,6,7,4,2,9,1),
        intArrayOf(2,4,9,1,3,5,6,7,8),
        intArrayOf(7,6,1,2,8,9,4,5,3)
    )

)