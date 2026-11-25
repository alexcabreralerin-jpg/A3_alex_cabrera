package com.example.a3_alex_cabrera

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

const val CONSTANT_NAME = "NAME"
const val CONSTANT_MAIL = "MAIL"
const val CONSTANT_BIO = "BIO"
const val CONSTANT_IMG = "IMG"
class MainActivity : AppCompatActivity() {

    private lateinit var btn : Button
    private lateinit var name : EditText
    private lateinit var mail : EditText
    private lateinit var bio : EditText
    private lateinit var url : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn = findViewById(R.id.button)
        name = findViewById(R.id.campNom)
        mail = findViewById(R.id.campEmail)
        bio = findViewById(R.id.campBio)
        url = findViewById(R.id.campUrl)


        btn.setOnClickListener {
            val nom = name.text.toString().trim()
            val email = mail.text.toString().trim()
            val biografia = bio.text.toString().trim()
            val imatge = url.text.toString().trim()

            //aqui lo enviamos tot al MainActivity2
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra(CONSTANT_NAME, nom);
                putExtra(CONSTANT_MAIL, email);
                putExtra(CONSTANT_BIO, biografia);
                putExtra(CONSTANT_IMG, imatge);
            }
            startActivity(intent)

        }
    }
}