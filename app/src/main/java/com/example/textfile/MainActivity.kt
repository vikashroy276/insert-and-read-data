package com.example.textfile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mEditText = findViewById<EditText>(R.id.edtTxt)
        val mButtonSave = findViewById<Button>(R.id.btn1)
        val mButtonShow = findViewById<Button>(R.id.btn2)
        val mTextView = findViewById<TextView>(R.id.txtView)

        mButtonSave.setOnClickListener {
            if(mEditText.text.toString().isNotEmpty()){


                try {
                    val fileOutputStream = openFileOutput("mytextfile.txt", Context.MODE_PRIVATE)
                    val outputWriter = OutputStreamWriter(fileOutputStream)
                    outputWriter.write(mEditText.text.toString())
                    outputWriter.close()
                    Toast.makeText(baseContext, "File saved successfully!", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(applicationContext, "No input?", Toast.LENGTH_SHORT).show()
            }
        }

        mButtonShow.setOnClickListener {

            try {
                val fileInputStream = openFileInput("mytextfile.txt")
                val inputReader = InputStreamReader(fileInputStream)
                val output = inputReader.readText()

                mTextView.text = output
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
