package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BlockDetailScreen(blockDetailRoute: BlockDetailRoute? = null){
    Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->
        Card(modifier = Modifier.fillMaxWidth().padding(innerPadding)) {
            Text(text = blockDetailRoute?.id ?: "No id")
        }
    }

}

@Preview
@Composable
fun BlockDetailScreen_Preview(){
    BlockDetailScreen(BlockDetailRoute(id = "12"))
}