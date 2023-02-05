package com.example.sudoku

import android.preference.PreferenceActivity.Header
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Settings
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
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(100.dp))
                .border(1.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp), RoundedCornerShape(100.dp))
                .background(MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp))

        ) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Settings",
                modifier = Modifier
                    .size(20.dp)

            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .defaultMinSize(minWidth = 80.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp))
                .border(1.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp), RoundedCornerShape(100.dp))


        ){

            Text(
                text = "1:22",
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp))
                .border(1.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp), RoundedCornerShape(100.dp))


        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "New Sudoku",
                modifier = Modifier
                    .size(24.dp)

            )
        }

    }
}