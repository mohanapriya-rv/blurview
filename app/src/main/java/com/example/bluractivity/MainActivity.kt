package com.example.bluractivity

import android.app.Dialog
import android.graphics.Color

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.bluractivity.databinding.AcitivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: AcitivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = AcitivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setDialogView()
        super.onCreate(savedInstanceState)
    }

    private fun setDialogView() {
        binding!!.root.setBackgroundColor(getResources().getColor(R.color.transparent))
        val dialog = Dialog(this)
        val view = LayoutInflater.from(this).inflate(R.layout.banner_dialog, null)
        dialog.setContentView(view)
        dialog.setCancelable(false)
        dialog.window?.apply {
            setLayout(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            setBackgroundDrawableResource(android.R.color.transparent)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            // Apply blur effect to the activity window behind the dialog
            window.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
            window.attributes = window.attributes.apply {
                blurBehindRadius = 20 // Set blur radius (20 is a good start)
            }
        } else {
            // Fallback for older versions: Semi-transparent background
            window.setBackgroundDrawable(ColorDrawable(Color.parseColor("#666666")))
        }
        dialog.show()
    }
}