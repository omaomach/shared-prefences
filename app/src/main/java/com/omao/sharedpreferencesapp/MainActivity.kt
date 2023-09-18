package com.omao.sharedpreferencesapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.edit_text)
        textView = findViewById(R.id.last_username)
        val btn: Button = findViewById(R.id.save_me)

        displaySavedName()

        btn.setOnClickListener() {
            val enteredText: String = editText.text.toString()
            saveNameInSharedPreference(enteredText)
        }

    }

    private fun saveNameInSharedPreference(enteredText: String) {

        // saving user input
        val sharedPreferences: SharedPreferences = getSharedPreferences(
            "Users",
            MODE_PRIVATE
        )

        // Writing data to shared preferences
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("name", enteredText)
        editor.commit()

    }

    // Reading data from Shared Preferences
    fun displaySavedName() {
        val sharedPreferences: SharedPreferences = getSharedPreferences(
            "Users",
            MODE_PRIVATE
        )
        val name: String? = sharedPreferences.getString(
            "name",
            ""
        )
        textView.text = name
    }
}