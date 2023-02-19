package com.example.sudoku

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sudoku.data.tipData

@Composable
fun Tabs(
    selectedMode: String,
    onSelectedModeChange:(String) -> Unit,
) {

    Row() {

        TippingOptions(
            tipList = tipData,
            selectedMode,
            onSelectedModeChange
        )
    }

}



@Composable
fun TippingOptions(
    tipList: List<String>,
    selectedMode: String,
    onSelectedModeChange:(String) -> Unit,
) {
    Column() {

        Row(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp)),
        ) {

            val modifier = Modifier
                .weight(1f)
                .height(48.dp)
                .padding(4.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp))

            TipPercentRadio(
                tipList = tipList,
                selectedMode,
                onSelectedModeChange,
                modifier = modifier
            )

        }

    }
}


@Composable
fun TipPercentRadio(tipList:List<String>, selectedMode:String, onSelectedModeChange:(String)->Unit, modifier: Modifier){



    tipList.forEach { item ->

        val tipBgColor: Color by animateColorAsState(if (selectedMode.equals(item) ) {
            MaterialTheme.colorScheme.primary
        } else (MaterialTheme.colorScheme.surfaceColorAtElevation(100.dp)),
            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
        )

        val tipTextColor: Color by animateColorAsState((if (selectedMode.equals(item)) {
            MaterialTheme.colorScheme.onPrimary
        } else (MaterialTheme.colorScheme.primary)),
            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
        )

        Box(
            modifier = modifier
                .animateContentSize()
                .background(tipBgColor)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
                ) {
                    onSelectedModeChange(item)
                },
            contentAlignment = Alignment.Center,
        ) {

            Text(
                text = item,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = tipTextColor,
                letterSpacing = 0.sp

            )
        }

    }

}
