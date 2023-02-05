package com.example.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Backspace
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputPad() {
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
            DigitBox("1",modifier)
            DigitBox("2",modifier)
            DigitBox("3",modifier)
            DigitBox("4",modifier)
            DigitBox("5",modifier)
        }
        Row() {
            DigitBox("6",modifier)
            DigitBox("7",modifier)
            DigitBox("8",modifier)
            DigitBox("9",modifier)

            Row(
                modifier = modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Backspace,
                    contentDescription = "Remove",
                    modifier = Modifier
                        .size(29.dp)
                )
            }

        }
    }
}
