package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import android.content.res.Configuration
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.asterixorobelix.bitcoinblockexplorer.displayComponents.ConcatenatedText
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.DefaultPadding

@Composable
fun RecentBlockDisplayItem(recentBlock: RecentBlock) {
    Card {
        Column(modifier = Modifier.padding(DefaultPadding)) {
            ConcatenatedText(text = "ID: ${recentBlock.id}", modifier = Modifier.padding(top = DefaultPadding))
            Column(Modifier.padding(horizontal = DefaultPadding, vertical = DefaultPadding)) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = DefaultPadding),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Height: ${recentBlock.blockHeight}")
                    Text(text = "Transactions: ${recentBlock.transactions}")
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = DefaultPadding),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Difficulty: ${recentBlock.difficulty}")
                    Text(text = "Average fee: ${recentBlock.averageFee}")
                }
                Text(text = "Reward: ${recentBlock.reward}")
            }
        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFF00FF00)
@Composable
fun RecentBlocksDisplayItem_Preview() {
    RecentBlockDisplayItem(
        RecentBlock(
            id = "0000000000000000000384f28cb3b9cf4377a39cfd6c29ae9466951de38c0529",
            blockHeight = 730000,
            transactions = 1627,
            difficulty = 28587155782195.14,
            averageFee = 10038,
            reward = 641321983
        )
    )
}