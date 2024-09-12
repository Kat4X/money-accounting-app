package com.zet.main.ui.screen

import com.arkivanov.decompose.ComponentContext

interface TransactionsListComponent

class DefaultTransactionsListComponent(
    componentContext: ComponentContext,
) : TransactionsListComponent, ComponentContext by componentContext {

}
