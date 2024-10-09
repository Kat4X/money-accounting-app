package com.zet.desygn.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zet.desygn.R
import com.zet.desygn.theme.AppTheme

private val BOTTOM_BAR_SHAPE = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(BOTTOM_BAR_SHAPE)
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_home),
            contentDescription = "Home",
        )
        Icon(
            painter = painterResource(R.drawable.ic_home),
            contentDescription = "Home",
        )
        Icon(
            painter = painterResource(R.drawable.ic_home),
            contentDescription = "Home",
        )
        Icon(
            painter = painterResource(R.drawable.ic_home),
            contentDescription = "Home",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .padding(16.dp),
        ) {
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
