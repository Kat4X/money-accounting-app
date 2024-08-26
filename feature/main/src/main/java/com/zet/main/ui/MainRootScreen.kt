package com.zet.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zet.desygn.theme.AppTheme

@Composable
internal fun MainRootScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            Text(
                text = "Main Root Screen",
                modifier = Modifier.padding(16.dp)
            )
        }
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Main Root Content"
        )
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        MainRootScreen()
    }
}