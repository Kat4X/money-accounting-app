package com.zet.feature.transactions.screen.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zet.desygn.theme.AppTheme

@Composable
fun AddTransactionScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Add Transaction") },
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                },
            )
        },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
    ) { innerPadding ->
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary),
        ) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 36.dp,
                            topStart = 36.dp,
                        ),
                    )
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 16.dp, vertical = 24.dp),
            ) {
                // Блок выбора даты
                Text(text = "Date")
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Date") },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Блок выбора категории
                Text(text = "Category")
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Category") },
                    modifier = Modifier.fillMaxWidth(),
                )

                // Блок ввода суммы
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Amount")
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Amount") },
                    modifier = Modifier.fillMaxWidth(),
                )

                // Блок ввода комментария
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Comment")
                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Comment") },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        AddTransactionScreen(modifier = Modifier.fillMaxWidth())
    }
}
