package com.mir.mir.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mir.mir.R
import com.mir.mir.ui.theme.BackgroundBtn
import com.mir.mir.ui.theme.BackgroundBtnGrey
import com.mir.mir.ui.theme.TextNotActiv


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    value: String = "",
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable() (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    textAlign: TextAlign? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                textAlign = textAlign,
                modifier = Modifier.fillMaxWidth(),
                style = textStyle
            )
        },
        modifier = modifier,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color.Black,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onSecondary,
            containerColor = BackgroundBtnGrey,
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.Black
        ),
        trailingIcon = trailingIcon,
        shape = RoundedCornerShape(16.dp),
        visualTransformation = visualTransformation
    )
}

@Composable
fun ButtonResume(
    onCLick: () -> Unit,
    checkedState: Boolean = true
) {
    Box(
        Modifier
            .padding(start = 16.dp, end = 16.dp,top = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(56.dp),
            onClick = onCLick,
            colors = ButtonDefaults.buttonColors(
                contentColor = if (checkedState) {
                    Color.White
                } else {
                    TextNotActiv
                },
                containerColor = if (checkedState) {
                    BackgroundBtn
                } else {
                    Color.Transparent
                },
            ),
            shape = RoundedCornerShape(30.dp)

        ) {
            Text(
                text = stringResource(id = R.string.resume),
                style = MaterialTheme.typography.displayMedium,
                color = if (checkedState) {
                    Color.White
                } else {
                    TextNotActiv
                }
            )
        }
    }
}

@Composable
fun AddPhotoButton(onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier.height(228.dp).width(172.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .clip(shape = RoundedCornerShape(10.dp))
            .background(BackgroundBtnGrey),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.plus),
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
fun SelectItem(
    text: String = "",
    isSelected: Boolean = false,
    onItemSelected: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .wrapContentSize()
            .clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onItemSelected
        )
            .clip(shape = RoundedCornerShape(26.dp))
            .background(
                if (isSelected) {
                    BackgroundBtn
                } else {
                    BackgroundBtnGrey
                }
            )
    ) {
        Text(
            modifier = Modifier .padding(top = 8.dp, bottom = 8.dp, start = 20.dp, end = 20.dp),
            textAlign = TextAlign.Center,
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            color = if (isSelected) {
                Color.White
            } else {
                Color.Black
            },
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CustomFlowRow(
    content: @Composable () -> Unit
){
    FlowRow(
        modifier = Modifier.wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        content
    }
}

/*@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomFilterChip(
    text: String = "Helloo",
    isSelected: Boolean = false,
    onItemSelected: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    FilterChip(
        modifier = Modifier
                   .clip(shape = RoundedCornerShape(26.dp)),
        onClick = {

        },
        shape = FilterChipDefaults.shape,
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = BackgroundBtn,
            disabledContainerColor = BackgroundBtnGrey,
            containerColor = BackgroundBtnGrey
        ),
        border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp),
        selected = isSelected,
        label = {
            Text(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 20.dp, end = 20.dp),
                textAlign = TextAlign.Center,
                text = text,
                style = MaterialTheme.typography.headlineMedium,
                color = if (isSelected) {
                    Color.White
                } else {
                    Color.Black
                },
            )
        }
    )
}*/
@Composable
fun HeaderLarge(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.displayLarge,
        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun HeaderMedium(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.displayMedium,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
}