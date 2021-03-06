package com.example.compose.sceens.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.compose.R
import com.example.compose.sceens.details.ProductScreen

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.start_fragment, container, false).apply {
        findViewById<ComposeView>(R.id.compose_container).setContent {
            MaterialTheme(
                colors= DarkColors
            ){
                ProductScreen()
            }

        }
    }
}