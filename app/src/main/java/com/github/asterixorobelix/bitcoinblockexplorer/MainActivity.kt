package com.github.asterixorobelix.bitcoinblockexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlocksRoute
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.RecentBlocksScreen
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail.BlockDetailRoute
import com.github.asterixorobelix.bitcoinblockexplorer.recent_blocks.detail.BlockDetailScreen
import com.github.asterixorobelix.bitcoinblockexplorer.ui.theme.BitcoinBlockExplorerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BitcoinBlockExplorerTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = RecentBlocksRoute) {
                    composable<RecentBlocksRoute> { RecentBlocksScreen{
                        navController.navigate(route = BlockDetailRoute(id = "1234"))
                    } }
                    composable<BlockDetailRoute> { BlockDetailScreen(blockDetailRoute = BlockDetailRoute("1234")) }
                }
            }
        }
    }
}