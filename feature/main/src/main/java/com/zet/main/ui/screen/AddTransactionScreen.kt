package com.zet.main.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zet.desygn.theme.AppTheme

@Composable
internal fun AddTransactionScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Content",
                style = MaterialTheme.typography.displayLarge,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        AddTransactionScreen()
    }
}
