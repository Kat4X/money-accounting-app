package com.zet.main.ui.screen.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zet.desygn.theme.AppTheme
import com.zet.main.ui.component.TransactionBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainRootScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "MainScreen") },
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topEnd = 0.dp,
                            topStart = 0.dp,
                            bottomEnd = 12.dp,
                            bottomStart = 12.dp,
                        ),
                    )
                    .fillMaxWidth(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                ),
            )
        },
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add Transaction",
                    modifier = Modifier.size(32.dp),
                )
            }
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = 16.dp)
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp,
                        topEnd = 12.dp,
                        topStart = 12.dp,
                    ),
                )
                .background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp),
        ) {
            item {
                Text(
                    text = "History",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            items(10) {
                TransactionBlock(Modifier.fillMaxWidth())
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        MainRootScreen()
    }
}
