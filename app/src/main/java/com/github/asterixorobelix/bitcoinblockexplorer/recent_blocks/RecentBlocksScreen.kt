package com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.github.asterixorobelix.bitcoinblockexplorer.R
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.DefaultPadding
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.Pink80
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.Purple80
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun RecentBlocksScreen(onNavigateToBlockDetail: (String) -> Unit){
    val viewModel: RecentBlocksViewModel = koinViewModel()

    val state: State<RecentBlocksState> =  viewModel.state.collectAsState()
    Scaffold (modifier = Modifier.fillMaxSize()){innerPadding ->
        val scope = rememberCoroutineScope()
        LaunchedEffect(key1 = true) {
            scope.launch {
                viewModel.getRecentBlocks()
            }
        }
        if (state.value.loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = DefaultPadding),
                color = Pink80,
                trackColor = Purple80
            )
        } else {
            LazyColumn(Modifier.padding(innerPadding)) {
                item {
                    Card {
                        Column(modifier = Modifier.padding(DefaultPadding)) {
                            Text(text = stringResource(id = R.string.recent_blocks))
                        }
                    }
                }

                state.value.recentBlocks?.let {
                    items(it.size) { index ->
                        RecentBlockDisplayItem(recentBlock = it[index], onBlockClick = onNavigateToBlockDetail)
                    }
                }
            }
        }
    }
}