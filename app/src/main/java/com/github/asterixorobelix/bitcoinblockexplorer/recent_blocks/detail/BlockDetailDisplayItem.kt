package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail

import androidx.compose.foundation.clickable
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
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlock
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.DefaultPadding

@Composable
fun BlockDetailDisplayItem(text: String) {
    Column(modifier = Modifier.padding(DefaultPadding)) {
        Text(
            text = text,
            modifier = Modifier.padding(top = DefaultPadding)
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF00FF00)
@Composable
fun BlockDetailDisplayItem_Preview() {
    BlockDetailDisplayItem(
        text = "yes"
    )
}