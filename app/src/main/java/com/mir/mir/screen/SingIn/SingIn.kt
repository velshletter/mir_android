package com.mir.mir.screen.SingIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.mir.mir.R
import com.mir.mir.ui.theme.BackgroundBtn
import com.mir.mir.ui.theme.BackgroundBtnGrey

//@Preview(showBackground = true) //widthDp = 320,heightDp = 320


@Composable
fun SingInView(onClick:()->Unit) {

    Column(
        modifier = Modifier
            .padding(end = 16.dp, start = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val font = FontFamily(Font(R.font.sf_pro_display_medium))
        Text(
            text = "LOGO", modifier = Modifier
                .weight(1f)
                .padding(top = 120.dp), fontSize = 34.sp,
            fontFamily = font
        )


        Column(
            Modifier
                .weight(1f)
                .padding(top = 60.dp)
        ) {

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = BackgroundBtn,
                    containerColor = BackgroundBtn
                ),
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(30.dp)

            ) {
                Text(
                    stringResource(id = R.string.enter),
                    fontSize = 19.sp,
                    fontFamily = font,
                    color = Color.White
                )

            }


            Button(
                onClick = { onClick() },
                colors = ButtonDefaults.buttonColors(
                    contentColor = BackgroundBtn,
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(30.dp)

            ) {
                Text(
                    text = stringResource(id = R.string.createAcc),
                    fontSize = 19.sp,
                    fontFamily = font,
                    color = Color.Black
                )

            }
            RegistrationViaAcc()


        }

    }


}

@Composable
fun RegistrationViaAcc() {
    Box(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {


        Column() {
            Replies()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {/*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BackgroundBtnGrey,
                        contentColor = BackgroundBtn
                    ),
                    modifier = Modifier
                        .padding(5.dp, bottom = 30.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_google),
                        modifier = Modifier.size(20.dp),
                        contentDescription = null
                    )
                }

                Button(
                    onClick = {/*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BackgroundBtnGrey,
                        contentColor = BackgroundBtn
                    ),
                    modifier = Modifier
                        .padding(5.dp, bottom = 20.dp)
                        .weight(1f),
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_facebook),
                        modifier = Modifier.size(20.dp),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun Replies() {
    val font = FontFamily(Font(R.font.sf_pro_display_light))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.Gray)
        ) {}
        ClickableText(
            text = AnnotatedString(stringResource(id = R.string.or_continue)),
            onClick = {},
            modifier = Modifier.weight(1f),
            style = TextStyle(
                textAlign = TextAlign.Center, fontFamily = font
            ),
        )
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.Gray)
        ) {}
    }
}





