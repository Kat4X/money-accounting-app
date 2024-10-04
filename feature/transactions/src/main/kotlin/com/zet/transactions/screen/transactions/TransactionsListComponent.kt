package com.zet.transactions.screen.transactions

import com.arkivanov.decompose.ComponentContext
import com.zet.transactions.screen.transactions.model.TransactionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

interface TransactionsListComponent {
    data class State(
        val transactionsList: List<TransactionModel>,
    )

    val state: StateFlow<State>
    fun loadTransactions()
}

class DefaultTransactionsListComponent(
    componentContext: ComponentContext,
) : TransactionsListComponent, ComponentContext by componentContext {

    private val _state = MutableStateFlow(
        TransactionsListComponent.State(
            transactionsList = emptyList(),
        ),
    )
    override val state = _state.asStateFlow()

    override fun loadTransactions() {
        _state.update {
            TransactionsListComponent.State(
                transactionsList = getMockData(),
            )
        }
    }

    private fun getMockData(): List<TransactionModel> {
        return listOf(
            TransactionModel(
                name = "Покупка продуктов",
                date = "2024-09-22",
                typeOfBadge = "Расход",
                amount = "- \$1500",
            ),
            TransactionModel(
                name = "Зарплата",
                date = "2024-09-15",
                typeOfBadge = "Доход",
                amount = "+ \$50000",
            ),
            TransactionModel(
                name = "Оплата аренды",
                date = "2024-09-10",
                typeOfBadge = "Расход",
                amount = "- \$20000",
            ),
            TransactionModel(
                name = "Кафе с друзьями",
                date = "2024-09-18",
                typeOfBadge = "Расход",
                amount = "- \$2300",
            ),
            TransactionModel(
                name = "Возврат долга",
                date = "2024-09-20",
                typeOfBadge = "Доход",
                amount = "+ \$5000",
            ),
        )
    }
}

internal class PreviewTransactionsListComponent : TransactionsListComponent {
    override val state: StateFlow<TransactionsListComponent.State> = MutableStateFlow(
        TransactionsListComponent.State(
            transactionsList = getMockData(),
        ),
    )

    override fun loadTransactions() = Unit

    private fun getMockData(): List<TransactionModel> {
        return listOf(
            TransactionModel(
                name = "Покупка продуктов",
                date = "2024-09-22",
                typeOfBadge = "Расход",
                amount = "- \$1500",
            ),
            TransactionModel(
                name = "Зарплата",
                date = "2024-09-15",
                typeOfBadge = "Доход",
                amount = "+ \$50000",
            ),
            TransactionModel(
                name = "Оплата аренды",
                date = "2024-09-10",
                typeOfBadge = "Расход",
                amount = "- \$20000",
            ),
            TransactionModel(
                name = "Кафе с друзьями",
                date = "2024-09-18",
                typeOfBadge = "Расход",
                amount = "- \$2300",
            ),
            TransactionModel(
                name = "Возврат долга",
                date = "2024-09-20",
                typeOfBadge = "Доход",
                amount = "+ \$5000",
            ),
        )
    }
}
