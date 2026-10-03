package com.example.rastykpop

import android.R
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ComposeUiFlags
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rastykpop.ui.theme.RastyKpopTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginBody()

        }
    }
}

@Composable
fun LoginBody() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(20.dp)
            .padding(horizontal = 20.dp)
    ){
        Text("Hello")
        Text("World")
    }

}
 @Preview
@Composable
 fun LoginPreview(){
     LoginBody()
 }







