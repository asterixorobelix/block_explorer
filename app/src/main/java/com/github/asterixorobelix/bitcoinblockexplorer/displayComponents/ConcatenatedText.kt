package com.github.asterixorobelix.bitcoinblockexplorer.displayComponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ConcatenatedText(text:String, modifier: Modifier = Modifier){
    Text(text = ellipsizeMiddle(text), modifier)
}

@Composable
@Preview
fun ConcatenatedText_Preview(){
    ConcatenatedText(text = "000000000000000000003b9455f7a5397d7f5bc2fdd2a914d999497c5736efcd")
}

private fun ellipsizeMiddle(input: String, maxLength: Int = 10): String {
    // If the string is shorter than or equal to the max length, return it as is.
    if (input.length <= maxLength) {
        return input
    }

    // Calculate how much we need to cut from the middle
    val ellipsis = "..."
    val maxContentLength = maxLength - ellipsis.length

    // Split the string into the first and last parts
    val halfLength = maxContentLength / 2
    val start = input.substring(0, halfLength)
    val end = input.substring(input.length - halfLength)

    // Combine the first part, ellipsis, and the last part
    return "$start$ellipsis$end"
}