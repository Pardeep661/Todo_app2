package com.pardeep.todo_app

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pardeep.todo_app.databinding.ActivityTodoItemBinding

class TodoItemActivity : AppCompatActivity() {
    var binding : ActivityTodoItemBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo_item)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding?.fab?.setOnClickListener {
            Dialog(this).apply {
                setContentView(R.layout.cutom_todo_item)
                var todo_name = findViewById<EditText>(R.id.etTodoItem)
                var isChecked = findViewById<CheckBox>(R.id.checkBox)
                var add_button = findViewById<Button>(R.id.btnAdd)

                add_button.setOnClickListener {
                    if (todo_name.text.trim().isNullOrEmpty()){
                        todo_name.error = "please enter todo name"
                    }
                    else{

                    }
                }
            }
        }
    }
}