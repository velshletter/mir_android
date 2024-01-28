package com.mir.mir.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mir.mir.R
import com.mir.mir.screen.NumberDefaults.INPUT_LENGTH
import com.mir.mir.screen.NumberDefaults.MASK
import com.mir.mir.ui.theme.BackgroundBtn
import com.mir.mir.ui.theme.BackgroundBtnGrey

private val fontBold = FontFamily(Font(R.font.sf_pro_display_bold))
private val fontMedium = FontFamily(Font(R.font.sf_pro_display_medium))
private val fontLight = FontFamily(Font(R.font.sf_pro_display_light))

@Composable
fun CreateAccountView() {
    Column(Modifier.padding(top = 60.dp, end = 16.dp, start = 16.dp)) {
        DefaultsText(isFat = true, text = stringResource(id = R.string.createAcc), sizeText = 24)
        DefaultsText(
            isFat = false,
            text = stringResource(id = R.string.input_telephone),
            sizeText = 16
        )
        DefaultsText(
            isFat = true,
            text = stringResource(id = R.string.number_telephone),
            sizeText = 19
        )
        CustomTextField()

        Row(Modifier.padding(top = 15.dp)) {
            val checkedState = remember { mutableStateOf(true) }
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.Gray,
                    checkedColor = BackgroundBtn,
                    checkmarkColor = Color.White
                )
            )
            //Spacer(modifier = Modifier.width(5.dp))
            Text(
                stringResource(id = R.string.agreement_policy),
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontFamily = fontMedium
            )
        }

    }
}

@Composable
fun DefaultsText(isFat: Boolean, text: String, sizeText: Int) {

    Text(
        text = text,
        Modifier.padding(top = 10.dp, bottom = 10.dp),
        fontFamily = if (isFat) {
            fontBold
        } else {
            fontMedium
        },
        fontSize = sizeText.sp
    )
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField() {
    var text by remember { mutableStateOf("") }

    Box(
        Modifier
            .border(
                width = if (text != "") 0.dp else 10.dp,
                color = if (text != "") BackgroundBtn else Color.Transparent,
                shape = RoundedCornerShape(15.dp)
            )
            .background(
                color = BackgroundBtnGrey,
                shape = RoundedCornerShape(15.dp)
            )
    ) {


        Row(
            Modifier.padding(end = 16.dp, start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {


            Spinner()

            TextField(
                value = text,
                onValueChange = { it ->
                    if (it.length <= INPUT_LENGTH) {
                        text = it.filter { it.isDigit() }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = MaskVisualTransformation(MASK),
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontFamily = fontBold,
                    // textAlign = TextAlign.Justify,
                    fontSize = 24.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = Color.Gray
                )
            )

            Image(
                painter = painterResource(R.drawable.icon_phone),
                contentDescription = "icon telephone",
                modifier = Modifier.size(20.dp)
            )


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spinner() {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var flag by remember {
        mutableIntStateOf(R.drawable.icon_russia)
    }

    /*  Box(*//*modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center*//*
    ) {*/

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it }) {
/*
        Icon(
            painter = painterResource(id = flag),
            contentDescription = "icon_russia",
            modifier = Modifier
                .menuAnchor()
                .size(50.dp),
            )*/

        Image(
            painter = painterResource(id = flag), contentDescription = "",
            modifier = Modifier
                .menuAnchor()
                .size(50.dp),
        )

        /*     TextField(
                 value = gender,
                 onValueChange = {},
                 readOnly = true,
                 trailingIcon = {
                     ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                 },
                 modifier = Modifier.menuAnchor()
             )*/
        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
            DropdownMenuItem(


                text = {
                    Image(
                        painter = painterResource(id = R.drawable.icon_russia),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp),
                    )
                },
                onClick = {
                    flag = R.drawable.icon_russia
                    isExpanded = false
                }
            )
            DropdownMenuItem(


                text = {
                    Image(
                        painter = painterResource(id = R.drawable.icon_belarus),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp),
                    )
                },
                onClick = {
                    flag = R.drawable.icon_belarus
                    isExpanded = false
                }
            )
            DropdownMenuItem(


                text = {
                    Image(
                        painter = painterResource(id = R.drawable.icon_united),
                        contentDescription = "",
                        modifier = Modifier
                            .size(50.dp),
                    )
                },
                onClick = {
                    flag = R.drawable.icon_united
                    isExpanded = false
                }
            )
        }
    }
}


/* }
}*/


