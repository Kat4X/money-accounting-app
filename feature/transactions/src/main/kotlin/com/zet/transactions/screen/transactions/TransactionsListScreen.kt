package com.zet.transactions.screen.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zet.desygn.theme.AppTheme
import com.zet.feature.transactions.R

@Composable
fun TransactionsListScreen(
    component: TransactionsListComponent,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(Unit) { component.loadTransactions() }

    val state by component.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.transactions)) },
                modifier = Modifier
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
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .clip(
                        RoundedCornerShape(
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 36.dp,
                            topStart = 36.dp,
                        ),
                    )
                    .background(MaterialTheme.colorScheme.surface),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    Text(
                        text = "Месяц",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                    )
                }
                items(state.transactionsList) { model ->
                    TransactionBlock(
                        model = model,
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        TransactionsListScreen(
            component = PreviewTransactionsListComponent(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}
