package com.cr7.customaler

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowCustomDialog: Button = findViewById(R.id.btnShowCustomDialog)
        btnShowCustomDialog.setOnClickListener {
            showCustomDialog()
        }
    }

    private fun showCustomDialog() {
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        val etName: EditText = dialogView.findViewById(R.id.etName)
        val btnCancel: Button = dialogView.findViewById(R.id.btnCancel)
        val btnSubmit: Button = dialogView.findViewById(R.id.btnSubmit)

        val alertDialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        btnCancel.setOnClickListener {
            alertDialogBuilder.dismiss()
        }

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()) {
                Toast.makeText(this, "Hello, $name!", Toast.LENGTH_SHORT).show()
                alertDialogBuilder.dismiss()
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }

        alertDialogBuilder.show()
    }
}
