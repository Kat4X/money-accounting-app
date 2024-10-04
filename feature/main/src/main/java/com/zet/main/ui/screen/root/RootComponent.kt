package com.zet.main.ui.screen.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.zet.feature.transactions.screen.transactions.component.DefaultTransactionsListComponent
import com.zet.feature.transactions.screen.transactions.component.TransactionsListComponent
import com.zet.main.ui.screen.AddTransactionComponent
import com.zet.main.ui.screen.DefaultAddTransactionComponent
import kotlinx.serialization.Serializable

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        class TransactionsListChild(val component: TransactionsListComponent) : Child()
        class AddTransactionChild(val component: AddTransactionComponent) : Child()
    }
}

internal class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()
    override val childStack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(), // Or null to disable navigation state saving
        initialConfiguration = Config.TransactionsList,
        handleBackButton = true, // Pop the back stack on back button press
        childFactory = ::createChild,
    )

    private fun createChild(config: Config, componentContext: ComponentContext): RootComponent.Child =
        when (config) {
            Config.TransactionsList -> RootComponent.Child.TransactionsListChild(
                component = DefaultTransactionsListComponent(componentContext),
            )

            Config.AddTransaction -> RootComponent.Child.AddTransactionChild(
                component = DefaultAddTransactionComponent(componentContext),
            )
        }

    @Serializable
    private sealed class Config {
        @Serializable
        data object TransactionsList : Config()

        @Serializable
        data object AddTransaction : Config()
    }
}
