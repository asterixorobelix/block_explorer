package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.asterixorobelix.bitcoinblockexplorer.R
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlockDisplayItem
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlocksState
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.DefaultPadding
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun BlockDetailScreen(blockDetailRoute: BlockDetailRoute){
    Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->
        val viewModel: BlockDetailViewModel = koinViewModel()
        val state: State<BlockDetailState> =  viewModel.state.collectAsState()

        val scope = rememberCoroutineScope()
        LaunchedEffect(key1 = true) {
            scope.launch {
                viewModel.getBlockInfo(blockDetailRoute.id)
            }
        }
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)) {


            LazyColumn(Modifier.padding(innerPadding)) {
                item {
                    Text(text = "Block: ${blockDetailRoute.id}", modifier = Modifier.padding(horizontal = 10.dp))
                }
                state.value.blockDetail?.let {
                    items(7) { index ->
                        BlockDetailDisplayItem(text = it.getText(index))
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun BlockDetailScreen_Preview(){
    BlockDetailScreen(BlockDetailRoute(id = "12"))
}