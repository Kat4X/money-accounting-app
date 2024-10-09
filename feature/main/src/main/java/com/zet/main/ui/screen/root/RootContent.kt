package com.zet.main.ui.screen.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.zet.feature.transactions.screen.add.AddTransactionScreen
import com.zet.feature.transactions.screen.transactions.TransactionsListScreen

@Composable
internal fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade()),
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.TransactionsListChild -> TransactionsListScreen(
                component = child.component,
                modifier = Modifier.fillMaxSize(),
            )
            is RootComponent.Child.AddTransactionChild -> AddTransactionScreen()
        }
    }
}
