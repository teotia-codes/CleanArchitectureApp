package com.example.cleanarchitectureapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.cleanarchitectureapp.store.presentation.products_screen.ProductsScreen
import com.example.cleanarchitectureapp.ui.theme.CleanArchitectureAppTheme
import com.example.cleanarchitectureapp.util.Event
import com.example.cleanarchitectureapp.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureAppTheme {
                // A surface container using the 'background' color from the theme
               val lifecycle = LocalLifecycleOwner.current.lifecycle
                LaunchedEffect(key1 = lifecycle){
                    repeatOnLifecycle(state = Lifecycle.State.STARTED){
                        EventBus.events.collect{event->
                            if(event is Event.Toast){
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductsScreen()
                }
            }
        }
    }
}
