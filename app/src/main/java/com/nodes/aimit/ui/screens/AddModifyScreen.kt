package com.nodes.aimit.ui.screens

import android.app.DatePickerDialog
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nodes.aimit.R
import com.nodes.aimit.domain.model.ContentType
import com.nodes.aimit.domain.model.GoalType
import com.nodes.aimit.ui.theme.AIMITTheme
import com.nodes.aimit.utils.LogCompositions
import com.nodes.aimit.utils.StringUtils
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Calendar
import java.util.Locale

@Composable
fun AddModifyScreen(modifier: Modifier = Modifier, contentType: ContentType = ContentType.GOAL) {
    when (contentType) {
        ContentType.GOAL -> AddModifyGoalContent(modifier = modifier)
        ContentType.HABIT -> AddModifyHabitContent(modifier = modifier)
        ContentType.ROUTINE -> AddModifyRoutineContent(modifier = modifier)
        ContentType.TASK -> AddModifyTaskContent(modifier = modifier)
    }
}

@Composable
private fun AddModifyGoalContent(modifier: Modifier = Modifier) {

    var goalName by rememberSaveable { mutableStateOf("") }
    val startDate = rememberSaveable { mutableStateOf(LocalDate.now()) }
    val endDate = rememberSaveable { mutableStateOf(LocalDate.now().plusDays(1)) }
    var selectedGoalType by rememberSaveable { mutableStateOf(GoalType.AVERAGE) }
    var startValue by rememberSaveable { mutableStateOf(0) }
    var targetValue by rememberSaveable { mutableStateOf(0) }
    var unit by rememberSaveable { mutableStateOf("") }

    val textFieldModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp)

    Surface(
        modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column {
            TextField(value = goalName, onValueChange = { newText ->
                goalName = newText
            }, label = { Text("Name your goal") }, modifier = textFieldModifier
            )

            DatePickerTextField(labelResId = R.string.start_date,
                modifier = textFieldModifier,
                date = startDate,
                onDateUpdated = {
                    if (endDate.value.isBefore(startDate.value)) {
                        endDate.value = startDate.value.plusDays(1)
                    }
                }
            )

            DatePickerTextField(
                labelResId = R.string.end_date,
                modifier = textFieldModifier,
                date = endDate,
                onDateUpdated = {// do nothing
                },
                minDate = startDate
            )

            Text(text = "Goal Type", modifier = Modifier.padding(16.dp))

            RadioButtonGroup(modifier = Modifier.padding(16.dp), options = listOf(
                listOf(GoalType.TARGET, GoalType.AVERAGE),
                listOf(GoalType.SUCCESS_RATE, GoalType.STREAK)
            ), onItemSelected = { selectedGoalType = it })

            when (selectedGoalType) {
                GoalType.TARGET -> {
                    IntTextField(
                        modifier = textFieldModifier,
                        value = startValue,
                        onValueChanged = { startValue = it },
                        labelResId = R.string.start_value
                    )
                    IntTextField(
                        modifier = textFieldModifier,
                        value = targetValue,
                        onValueChanged = { targetValue = it },
                        labelResId = R.string.target_value
                    )
                    TextField(
                        modifier = textFieldModifier,
                        value = unit,
                        onValueChange = { it -> unit = it },
                        label = { Text(stringResource(id = R.string.unit)) },
                    )
                }

                GoalType.AVERAGE -> {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        DropDownTextField(modifier = textFieldModifier.weight(1f))
                        IntTextField(
                            modifier = textFieldModifier.weight(1f),
                            value = targetValue,
                            onValueChanged = { targetValue = it },
                            labelResId = R.string.target_average
                        )
                    }

                }

                GoalType.SUCCESS_RATE -> {
                    TODO()
                }

                GoalType.STREAK -> {
                    TODO()
                }
            }
        }
    }
}

@Composable
private fun AddModifyHabitContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Text(text = "Add Modify Habit Screen")
        }
    }
}

@Composable
private fun AddModifyRoutineContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Text(text = "Add Modify Routine Screen")
        }
    }
}

@Composable
private fun AddModifyTaskContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Row() {
            Text(text = "Add Modify Task Screen")
        }
    }
}

@Preview
@Composable
private fun AddModifyGoalScreenPreview() {
    AIMITTheme() {
        AddModifyScreen(contentType = ContentType.GOAL)
    }
}

@Composable
private inline fun <reified T> RadioButtonGroup(
    modifier: Modifier = Modifier, options: List<List<T>>, crossinline onItemSelected: (T) -> Unit
) {
    val selectedRowIndex = remember { mutableStateOf(0) }
    val selectedColumnIndex = remember { mutableStateOf(0) }

    Column(modifier = modifier.fillMaxWidth()) {
        for (rowIndex in options.indices) {
            Row {
                for (columnIndex in options[rowIndex].indices) {
                    val option = options[rowIndex][columnIndex]
                    val isSelected =
                        rowIndex == selectedRowIndex.value && columnIndex == selectedColumnIndex.value
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            selectedRowIndex.value = rowIndex
                            selectedColumnIndex.value = columnIndex
                            onItemSelected(option)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.outline
                            }
                        ),

                        ) {
                        val text = when (T::class) {
                            GoalType::class -> {
                                stringResource((option as GoalType).labelResId)
                            }

                            else -> {
                                ""
                            }
                        }
                        Text(text = text)
                    }
                }
            }
        }
    }
}

@Composable
private fun IntTextField(
    modifier: Modifier = Modifier, value: Int, labelResId: Int, onValueChanged: (Int) -> Unit
) {
    var text by remember { mutableStateOf(value.toString()) }

    TextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            text = it
            onValueChanged(it.toIntOrNull() ?: 0)
        },
        label = { Text(stringResource(id = labelResId)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
private fun DatePickerTextField(
    modifier: Modifier = Modifier,
    date: MutableState<LocalDate>,
    labelResId: Int,
    onDateUpdated: (LocalDate) -> Unit,
    minDate: MutableState<LocalDate>? = null
) {
    val context = LocalContext.current
    val localCurrentLocale = compositionLocalOf<Locale> {
        error("No current locale provided")
    }

    ClickableTextField(
        modifier = modifier,
        valueProvider = { StringUtils.getFormattedDate(date.value, localCurrentLocale) },
        onValueChanged = {},
        onClick = {
            DatePickerDialog(
                context, { _, year, month, dayOfMonth ->
                    val updatedDate = LocalDate.of(year, month - 1, dayOfMonth)
                    date.value = updatedDate
                    onDateUpdated(date.value)
                },
                date.value.year,
                date.value.monthValue + 1,
                date.value.dayOfMonth
            ).apply {
                if (minDate != null) {
                    val minCalendar = Calendar.getInstance()
                    minCalendar.set(
                        minDate.value.year,
                        minDate.value.monthValue + 1,
                        minDate.value.dayOfMonth
                    )
                    this.datePicker.minDate = minCalendar.timeInMillis
                }
            }.show()
        },
        label = { Text(stringResource(id = labelResId)) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DropDownTextField(modifier: Modifier = Modifier) {

    val defaultItem = stringResource(id = R.string.average_above)
    var isExpanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(defaultItem) }

    val items = listOf(
        stringResource(id = R.string.average_above),
        stringResource(id = R.string.average_below)
    )

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded }) {

        TextField(
            modifier = Modifier.menuAnchor(),
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) })

        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            for (item in items) {
                DropdownMenuItem(text = { Text(text = item) }, onClick = {
                    selectedItem = item
                    isExpanded = false
                })
            }
        }
    }

}

@Composable
private fun ClickableTextField(
    modifier: Modifier = Modifier,
    valueProvider: () -> String,
    onValueChanged: (String) -> Unit,
    onClick: () -> Unit,
    label: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    TextField(
        modifier = modifier,
        value = valueProvider(),
        onValueChange = onValueChanged,
        readOnly = true,
        interactionSource = remember { MutableInteractionSource() }.also { interactionSource ->
            LaunchedEffect(interactionSource) {
                interactionSource.interactions.collect() {
                    if (it is PressInteraction.Release) {
                        onClick()
                    }
                }
            }
        },
        label = label,
        trailingIcon = trailingIcon
    )
}