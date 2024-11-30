package com.sachna.banco_sachna

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sachna.banco_sachna.databinding.BienvenidaBinding

class BienvenidaActivity : AppCompatActivity() {
    private lateinit var binding: BienvenidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dni = intent.getStringExtra("USER_DNI")
        binding.textViewWelcome.text = getString(R.string.welcome_message)+ ", \n $dni!"

        binding.buttonCambiarClave.setOnClickListener {
            val intent = Intent(this, CambiarClaveActivity::class.java)
            startActivity(intent)
        }
        binding.buttonSalir.setOnClickListener {
            finish()
        }
    }
}