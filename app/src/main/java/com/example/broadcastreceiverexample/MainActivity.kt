package com.example.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.broadcastreceiverexample.ui.theme.BroadcastReceiverExampleTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(
            NetworkChangeReceiver(),
            IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        )
        registerReceiver(
            BatteryBroadcastReceiver(),
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        )


        setContent {
            BroadcastReceiverExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    val intent = Intent("com.example.custom_action").apply {
                        putExtra("message", "Merhaba dünya!")
                    }
                    registerReceiver(MyBroadcastReceiver(), IntentFilter("com.example.custom_action"))
                    context.sendBroadcast(intent)
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BroadcastReceiverExampleTheme {
        Greeting("Android")
    }
}