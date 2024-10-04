package com.zet.main.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.zet.desygn.theme.AppTheme
import com.zet.main.ui.screen.root.DefaultRootComponent
import com.zet.main.ui.screen.root.RootContent

class MainRootActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val rootComponent = DefaultRootComponent(componentContext = defaultComponentContext())

        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    RootContent(
                        component = rootComponent,
                        modifier = Modifier
                            .fillMaxSize(),
                    )
                }
            }
        }
    }
}
