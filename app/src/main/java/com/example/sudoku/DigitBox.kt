package com.example.sudoku

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DigitBox(number:String, modifier: Modifier){


    Row(
        modifier = modifier
            .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
        ) {

        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(modifier = Modifier.padding(8.dp), text = number, fontSize = 28.sp, fontWeight = FontWeight.Bold)
    }
}