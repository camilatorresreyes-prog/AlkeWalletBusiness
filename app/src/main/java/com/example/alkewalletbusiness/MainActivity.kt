package com.example.alkewalletbusiness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var saldo = 0
    private lateinit var tvSaldo: TextView
    private lateinit var tvMovimiento: TextView

    private val ingresoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val monto = result.data?.getIntExtra("montoIngreso", 0) ?: 0
            saldo += monto
            tvSaldo.text = "Saldo de caja: $$saldo"
            tvMovimiento.text = "Último movimiento: Ingreso registrado por $$monto"
            Toast.makeText(this, "Ingreso guardado correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvSaldo = findViewById(R.id.tvSaldo)
        tvMovimiento = findViewById(R.id.tvMovimiento)

        val btnIngreso = findViewById<Button>(R.id.btnIngreso)
        val btnProveedor = findViewById<Button>(R.id.btnProveedor)

        btnIngreso.setOnClickListener {
            val intent = Intent(this, IngresoActivity::class.java)
            ingresoLauncher.launch(intent)
        }

        btnProveedor.setOnClickListener {
            saldo -= 500
            tvSaldo.text = "Saldo de caja: $$saldo"
            tvMovimiento.text = "Último movimiento: Pago a proveedor registrado"
            Toast.makeText(this, "Pago a proveedor registrado", Toast.LENGTH_SHORT).show()
        }
    }
}