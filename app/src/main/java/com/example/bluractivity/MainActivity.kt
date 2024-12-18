package com.example.bluractivity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bluractivity.databinding.AcitivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: AcitivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcitivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show overlay with dimmed background
        showOverlay()

        // Close button functionality
        binding.btnAction.setOnClickListener {
            hideOverlay()
        }
    }

    private fun showOverlay() {
        binding.dmBg.visibility = View.VISIBLE
        binding.overlay.visibility = View.VISIBLE
    }

    private fun hideOverlay() {
        binding.dmBg.visibility = View.GONE
        binding.overlay.visibility = View.GONE
    }
}
