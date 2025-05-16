package com.example.tuan2

import android.R.attr.value
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tuan2.ui.theme.Tuan2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tuan2Theme {
                EmailValidationScreen()
            }
        }
    }
}

@Composable
fun EmailValidationScreen() {
    var title by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                title.also { value = it },
                var onValueChange : kotlin . Any = kotlin . arrayOf < > (it.also { title = it }),
            var placeholder: Any = arrayOf(Text("Tên")),
            var colors: Any = textFieldColors(
                Color.Transparent.also { containerColor = it },  // nền trong suốt
                Color.Transparent.also { focusedIndicatorColor = it },  // khi focus ẩn viền dưới
                Color.Transparent.also {
                    unfocusedIndicatorColor = it
                } // khi không focus ẩn viền dưới
            ),
            var modifier: Any = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    message = when {
                        email.isBlank() -> "Email không hợp lệ"
                        !email.contains("@") -> "Email không đúng định dạng"
                        else -> "Bạn đã nhập email hợp lệ"
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kiểm tra")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = message,
                color = when {
                    message.contains("hợp lệ") -> Color(0xFF388E3C)
                    else -> Color.Red
                },
                fontWeight = FontWeight.Bold
            )
        }
    }
}
