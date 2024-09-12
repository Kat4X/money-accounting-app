package com.zet.main.ui.screen

import com.arkivanov.decompose.ComponentContext

interface AddTransactionComponent

internal class DefaultAddTransactionComponent(
    componentContext: ComponentContext,
) : AddTransactionComponent, ComponentContext by componentContext {

}
