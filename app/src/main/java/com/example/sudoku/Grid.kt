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
    selectedGrid : IntArray,
    selectedGridOnChange : (IntArray)->Unit,
    board : Array<IntArray>
) {


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                4.dp,
                MaterialTheme.colorScheme.surfaceColorAtElevation(900.dp),
                RoundedCornerShape(16.dp)
            )
            .padding(3.dp)
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
                            if(selectedGrid.contentEquals(intArrayOf(r,c))){
                                MaterialTheme.colorScheme.tertiaryContainer
                            }else {
                                MaterialTheme.colorScheme.background
                            }

                        if (board[c].get(r)==0){
                            EmptyBox(number = 0,selectedGridBackground,selectedGridOnChange,r,c)
                        }else {
                            GreyBox(number = board[c].get(r) )
                        }


                        /*Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    0.5.dp,
                                    MaterialTheme.colorScheme.surfaceColorAtElevation(500.dp)
                                )
                                .background(selectedGridBackground)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(color = MaterialTheme.colorScheme.tertiaryContainer)
                                ) {
                                    selectedGridOnChange(intArrayOf(r, c))
                                }
                        ) {
                            Text(
                                text =  if (board[c].get(r)!=0){
                                    board[c].get(r).toString()
                                }else {
                                    ""
                                },
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }*/


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
        Text(
            text = number.toString(),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun EmptyBox(number:Int,selectedGridBackground:Color,selectedGridOnChange:(IntArray)->Unit,r:Int,c:Int){
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
                selectedGridOnChange(intArrayOf(r,c))
            }
    ) {
        Text(
            text = "",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}