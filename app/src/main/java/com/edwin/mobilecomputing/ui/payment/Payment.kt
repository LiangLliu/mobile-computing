package com.edwin.mobilecomputing.ui.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun Payment(
    onBackPress: () -> Unit
) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
        ) {
            TopAppBar {
                IconButton(onClick = onBackPress) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
                Text(text = "Payment")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Recipient name") },
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text("Recipient account") },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Date") },
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    OutlinedTextField(
                        value = "",
                        onValueChange = { },
                        label = { Text("Amount") },
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth().size(55.dp)
                ) {
                    Text(text = "Save payment")
                }
            }
        }
    }
}