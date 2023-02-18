package com.example.sudoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sudoku.ui.SudokuViewModel
import com.example.sudoku.ui.theme.SudokuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)

            SudokuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp)
                ) {

                    val sudokuViewModel : SudokuViewModel = viewModel()
                    val sudokuUiState by sudokuViewModel.uiState.collectAsState()

                    val selectedMode = sudokuUiState.selectedMode
                    val selectedGrid = sudokuUiState.selectedGrid
                    val board = sudokuUiState.board
                    val colorBoard = sudokuUiState.colorBoard


                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .statusBarsPadding()
                            .navigationBarsPadding()
                            .captionBarPadding()
                            .imePadding(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Header()

                        Grid(selectedGrid,{sudokuViewModel.updateSelectedGrid(it)},board,colorBoard)

                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.padding(bottom = 24.dp)
                        ) {
                            Tabs(selectedMode,{sudokuViewModel.updateMode(it)})
                            InputPad(selectedGrid,board,{sudokuViewModel.updateBoard(it)})
                        }


                    }


                }
            }
        }
    }
}
