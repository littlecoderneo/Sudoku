package com.example.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Header(settingSheetState:ModalBottomSheetState,scope:CoroutineScope,newGameBottomSheetState: ModalBottomSheetState) {

   var ticks by remember { mutableStateOf(0L) }
    LaunchedEffect(Unit) {
        while(true) {
            delay(1000)
            ticks++
        }
    }



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
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp),
                    RoundedCornerShape(100.dp)
                )
                .background(MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
                ) {
                    scope.launch {
                        settingSheetState.show()
                    }
                }

        ) {
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Settings",
                modifier = Modifier
                    .size(20.dp),
                tint = MaterialTheme.colorScheme.primary

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
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp),
                    RoundedCornerShape(100.dp)
                )


        ){

            Text(
                text = convertSecondsToHMmSs(ticks),
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
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp),
                    RoundedCornerShape(100.dp)
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
                ) {
                    scope.launch {
                        newGameBottomSheetState.show()
                    }
                }


        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "New Sudoku",
                modifier = Modifier
                    .size(24.dp),
                tint = MaterialTheme.colorScheme.primary


            )
        }

    }

}


fun convertSecondsToHMmSs(seconds: Long): String {
    val s = seconds % 60
    val m = seconds / 60 % 60
    val h = seconds / (60 * 60) % 24
    return String.format("%02d:%02d", m, s)
}