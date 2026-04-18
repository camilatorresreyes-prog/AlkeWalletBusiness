package com.example.alkewalletbusiness

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class IngresoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        val etMontoIngreso = findViewById<EditText>(R.id.etMontoIngreso)
        val btnGuardarIngreso = findViewById<Button>(R.id.btnGuardarIngreso)

        btnGuardarIngreso.setOnClickListener {
            val montoTexto = etMontoIngreso.text.toString()

            if (montoTexto.isEmpty()) {
                Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show()
            } else {
                val monto = montoTexto.toInt()

                val intent = Intent()
                intent.putExtra("montoIngreso", monto)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}