package com.rifqi.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rifqi.sqllite.R
import com.rifqi.sqllite.SqlActivity
import kotlinx.android.synthetic.main.activity_another.*

class AnotherActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        preferences = getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)

        val name = preferences.getString("NAME","")
        nameTv.text = name
        val age = preferences.getInt("AGE",0)
        ageTv.text=""+age

        logout.setOnClickListener {
            val editor : SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_sql.setOnClickListener {
            val pindah2 = Intent (this, SqlActivity::class.java)
            startActivity(pindah2)
        }
    }
}