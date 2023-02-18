package com.example.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Grid(
    selectedGrid : MutableList<Int>,
    selectedGridOnChange : (MutableList<Int>)->Unit,
    board : MutableList<Int>,
    colorBoard:List<Int>
) {

    val grid = board.chunked(9)
    val colorBoardGrid = colorBoard.chunked(9)

    Box{

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(
                    4.dp,
                    MaterialTheme.colorScheme.surfaceColorAtElevation(900.dp),
                    RoundedCornerShape(16.dp)
                )
                .padding(4.dp)
                .background(MaterialTheme.colorScheme.surface)
        ){
            for (r in 0..8){

                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    for (c in 0..8){

                        val selectedGridBackground =
                            if(selectedGrid[0]==r && selectedGrid[1]==c){
                                MaterialTheme.colorScheme.tertiaryContainer
                            }else {
                                MaterialTheme.colorScheme.background
                            }

                        if (colorBoardGrid[c][r]==0){
                            EmptyBox(number = grid[c][r],selectedGridBackground,selectedGridOnChange,r,c)
                        }else {
                            GreyBox(number = grid[c][r])
                        }


                    }
                }
            }
        }

        //sudoku thick frame
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(
                    0.dp,
                    MaterialTheme.colorScheme.surfaceColorAtElevation(900.dp),
                    RoundedCornerShape(16.dp)
                )
        ){
            for (r in 0..2){

                Column(
                    modifier = Modifier
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    for (c in 0..2){
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    1.dp,
                                    MaterialTheme.colorScheme.surfaceColorAtElevation(2000.dp)
                                )
                        ){
                            Box(
                                modifier = Modifier
                                    .height(111.dp)

                            )
                        }


                    }
                }
            }
        }
    }

}

@Composable
fun GreyBox(number:Int){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .border(0.5.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(500.dp))
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp))
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.width(36.dp).height(36.dp)) {
            Text(
                text = number.toString(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
            )
        }

    }
}

@Composable
fun EmptyBox(number:Int,selectedGridBackground:Color,selectedGridOnChange:(MutableList<Int>)->Unit,r:Int,c:Int){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .border(0.5.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(500.dp))
            .background(selectedGridBackground)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                selectedGridOnChange(mutableListOf(r, c))
            }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.width(36.dp).height(36.dp)) {
            Text(
                text = if (number==0){""}else number.toString(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}