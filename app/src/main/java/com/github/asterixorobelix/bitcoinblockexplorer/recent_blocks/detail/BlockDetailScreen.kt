package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun BlockDetailScreen(blockDetailRoute: BlockDetailRoute){
    Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->
        val viewModel: BlockDetailViewModel = koinViewModel()

        val scope = rememberCoroutineScope()
        LaunchedEffect(key1 = true) {
            scope.launch {
                viewModel.getBlockInfo(blockDetailRoute.id)
            }
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)) {
            Text(text = blockDetailRoute.id)
        }
    }

}

@Preview
@Composable
fun BlockDetailScreen_Preview(){
    BlockDetailScreen(BlockDetailRoute(id = "12"))
}