package com.sachna.banco_sachna

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sachna.banco_sachna.databinding.ActivityCambiarClaveBinding

class CambiarClaveActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCambiarClaveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCambiarClaveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonGuardarClave.setOnClickListener {
            // Aquí puedes implementar la lógica para cambiar la clave.
            // Por ahora, solo haremos un Toast.

            val nuevaClave = binding.editTextNuevaClave.text.toString()
            // Lógica para almacenar la nueva clave (si fuera necesario).


            Toast.makeText(this, getString(R.string.new_password), Toast.LENGTH_SHORT).show()
            finish() // Cierra la actividad después de guardar la clave.
        }
    }
}
