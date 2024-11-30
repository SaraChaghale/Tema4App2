package com.sachna.banco_sachna

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sachna.banco_sachna.bd.MiBancoOperacional
import com.sachna.banco_sachna.databinding.ActivityMainBinding
import com.sachna.banco_sachna.pojo.Cliente

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       binding.buttonLogin.setOnClickListener {
         if (validateFields()) {

              val dni = binding.editTextDNI.text.toString()


              val intent = Intent(this, BienvenidaActivity::class.java).apply {
                  putExtra("USER_DNI", dni) // Pasar el DNI al Intent
           }
            startActivity(intent) // Iniciar BienvenidaActivity
         }
       }

        binding.buttonExit.setOnClickListener {
            finish()
        }



    }//


    private fun validateFields(): Boolean {
        val dni = binding.editTextDNI.text.toString()
        val password = binding.editTextPassword.text.toString()


        val dniPattern = "^[0-9]{8}[A-Za-z]$".toRegex()

        return when {
            dni.isEmpty() || password.isEmpty() -> {
                Toast.makeText(this, getString(R.string.complete_fields), Toast.LENGTH_SHORT).show()
                false
            }

            !dni.matches(dniPattern) -> {
                Toast.makeText(this, getString(R.string.invalid_dni), Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }
}
