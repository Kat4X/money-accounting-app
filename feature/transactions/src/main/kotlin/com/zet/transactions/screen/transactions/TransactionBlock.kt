package com.zet.transactions.screen.transactions

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zet.desygn.R
import com.zet.desygn.theme.AppTheme
import com.zet.transactions.screen.transactions.model.TransactionModel

@Composable
internal fun TransactionBlock(
    model: TransactionModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier.weight(0.55f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.ic_salary),
                contentDescription = null,
                modifier = Modifier.size(48.dp),
            )

            TransactionDescription(
                name = model.name,
                date = model.date,
            )
        }

        // TODO выровнять блок с оплатой
        Row(
            modifier = Modifier.weight(0.5f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            VerticalDivider(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.height(24.dp),
            )

            Text(
                text = model.typeOfBadge,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Thin,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.width(50.dp),
            )

            VerticalDivider(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.height(24.dp),
            )

            Text(
                text = model.amount,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                ),
            )
        }
    }
}

@Composable
private fun TransactionDescription(
    name: String,
    date: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
            ),
        )
        Text(
            text = date,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF0068FF),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionDescriptionPreview() {
    AppTheme {
        Box(Modifier.padding(16.dp)) {
            TransactionDescription(
                name = "Salary",
                date = "18:27 - April 30",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        Surface {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                getMockData().forEach { model ->
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
