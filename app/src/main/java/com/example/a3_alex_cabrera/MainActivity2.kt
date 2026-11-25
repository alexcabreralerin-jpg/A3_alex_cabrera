package com.example.a3_alex_cabrera

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity2 : AppCompatActivity() {

    private lateinit var viewName : TextView
    private lateinit var viewMail : TextView
    private lateinit var viewBio : TextView
    private lateinit var viewImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewName = findViewById(R.id.nomRebut)
        viewMail = findViewById(R.id.mailRebut)
        viewBio = findViewById(R.id.biografiaRebut)
        viewImage = findViewById(R.id.imageView)

        val name = intent.getStringExtra(CONSTANT_NAME) ?: ""
        val mail = intent.getStringExtra(CONSTANT_MAIL) ?: ""
        val bio = intent.getStringExtra(CONSTANT_BIO) ?: ""
        val imageUrl = intent.getStringExtra(CONSTANT_IMG) ?: ""

        viewName.text = name
        viewMail.text = mail
        viewBio.text = bio


        Glide.with(this)
            .load(imageUrl)
            .into(viewImage)

    }


}