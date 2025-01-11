package com.github.asterixorobelix.bitcoinblockexplorer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlockDisplayItem
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlocksViewModel
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.BitcoinBlockExplorerTheme
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.DefaultPadding
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.Pink80
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.Purple80
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.compose.getKoin

class MainActivity : ComponentActivity() {

    private val viewModel: RecentBlocksViewModel by viewModel<RecentBlocksViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BitcoinBlockExplorerTheme {
                val state by viewModel.state.collectAsState()
                val scope = rememberCoroutineScope()
                LaunchedEffect(key1 = true) {
                    scope.launch {
                        val blocks = viewModel.getRecentBlocks()
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    if (state.loading) {
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
                                        Text(text = "Recent Blocks")
                                    }
                                }
                            }

                            state.recentBlocks?.let {
                                items(it.size) { index ->
                                    RecentBlockDisplayItem(recentBlock = it[index])
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BitcoinBlockExplorerTheme {
        Greeting("Android")
    }
}