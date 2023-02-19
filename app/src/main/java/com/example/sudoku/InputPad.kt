package com.example.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputPad(
    selectedGrid:MutableList<Int>,
    board:MutableList<Int>,
    onUpdateBoard:(Int)->Unit

) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .border(
                1.dp,
                MaterialTheme.colorScheme.surfaceColorAtElevation(500.dp),
                RoundedCornerShape(16.dp)
            )
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.background)

    ) {

        val modifier = Modifier
            .weight(1f)
            .border(0.5.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(500.dp))

        Row() {
            DigitBox(1,modifier,board,onUpdateBoard,selectedGrid)
            DigitBox(2,modifier,board,onUpdateBoard,selectedGrid)
            DigitBox(3,modifier,board,onUpdateBoard,selectedGrid)
            DigitBox(4,modifier,board,onUpdateBoard,selectedGrid)
            DigitBox(5,modifier,board,onUpdateBoard,selectedGrid)
        }
        Row() {
            DigitBox(6,modifier,board,onUpdateBoard,selectedGrid)
            DigitBox(7,modifier,board,onUpdateBoard,selectedGrid)
            DigitBox(8,modifier,board,onUpdateBoard,selectedGrid)
            DigitBox(9,modifier,board,onUpdateBoard,selectedGrid)

            Row(
                modifier = modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
                    ) {
                        onUpdateBoard(0)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Backspace,
                    contentDescription = "Remove",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(29.dp)

                )
            }

        }
    }
}

@Composable
fun DigitBox(number:Int, modifier: Modifier, board: MutableList<Int>, onUpdateBoard: (Int) -> Unit,selectedGrid: MutableList<Int>){


    Row(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
            ) {
                onUpdateBoard(number)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(modifier = Modifier.padding(8.dp), text = number.toString(), fontSize = 28.sp, fontWeight = FontWeight.Bold)
    }
}