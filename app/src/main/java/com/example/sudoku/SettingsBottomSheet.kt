package com.example.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material3.Switch
import androidx.compose.runtime.MutableState
import androidx.compose.ui.draw.scale
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsBottomSheet(
    sheetState: ModalBottomSheetState,
    scope: CoroutineScope,
    hintMode:MutableState<Boolean>,
    updateHintMode:(MutableState<Boolean>)->Unit
){
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetElevation = 0.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        modifier = Modifier
            .fillMaxHeight(0.85f)
            .fillMaxWidth(1f)
            .navigationBarsPadding(),
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(0.60f)
                    .padding(top = 24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {


                    //header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {

                        Spacer(modifier = Modifier.weight(1f))
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .clip(shape = RoundedCornerShape(100.dp))
                                .background(
                                    color = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                        2.dp
                                    )
                                )
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
                                ) {
                                    scope.launch {
                                        sheetState.hide()
                                    }
                                }
                        ) {


                            Icon(
                                imageVector = Icons.Rounded.Close,
                                contentDescription = "Localized description",
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = "Settings",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 28.sp
                        )
                    }

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(vertical = 12.dp)
                    ) {


                        Row(

                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 12.dp,
                                        topEnd = 12.dp,
                                        bottomEnd = 12.dp,
                                        bottomStart = 12.dp
                                    )
                                )
                                .background(
                                    color = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                        2.dp
                                    )
                                )
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
                                ) {
                                    updateHintMode(hintMode)
                                    /*scope.launch {
                                        //currencyBottomSheetState.show()
                                    }*/
                                }
                                .padding(all = 16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween

                        ) {
                            Text(text = "Show hints")
                            Spacer(modifier = Modifier.weight(1f))
                            Switch(
                                modifier = Modifier.scale(0.8f).height(0.dp).padding(0.dp),
                                checked = hintMode.value,
                                onCheckedChange = { updateHintMode(hintMode) }
                            )
                            /*Text(
                                text = currencySymbol.find { it.symbol == selectedSymbol }?.shortName.toString(),
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = " • $selectedSymbol",
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.primary
                            )*/
                        }
                    }

                }
            }
        }
    ){}
}
