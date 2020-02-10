package fr.isen.dobosz.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.feltrin.technical_project.LoginActivity
import fr.isen.feltrin.technical_project.R
import fr.isen.feltrin.technical_project.SubscribeActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        buttonConnect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        buttonSubscribe.setOnClickListener {
            val intent = Intent(this, SubscribeActivity::class.java)
            startActivity(intent)
        }
    }

}
