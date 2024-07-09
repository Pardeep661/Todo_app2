package com.pardeep.todo_app

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.pardeep.todo_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CrudInterface {
    var binding :ActivityMainBinding? = null
    var data = arrayListOf<MyData>()
    var recyclerAdapter = MyAdapter(data,this)
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var dataBase: DataBase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dataBase = DataBase.getInstance(this)

        binding?.fab?.setOnClickListener {
            Dialog(this).apply {
                setContentView(R.layout.custom_dialog)
                window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                var text1 = findViewById<TextView>(R.id.editTextText)
                var text2 = findViewById<TextView>(R.id.editTextText2)
                var add = findViewById<Button>(R.id.Add)

                add?.setOnClickListener {
                    if(text1.text.trim().isNullOrEmpty()){
                        text1.error = "enter title"
                    }else if (text2.text.trim().isNullOrEmpty()){
                        text2.error = "enter description"
                    }else
                    {
                        var title_data = text1.text.toString()
                        var description_data = text2.text.toString()
                        data.add(MyData(name = title_data, description = description_data))
                        dataBase.dataDao().insertData(MyData(name = title_data, description = description_data))
                        recyclerAdapter.notifyDataSetChanged()
                        dismiss()
                    }
                }
            }.show()
        }



        linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding?.rv?.layoutManager = linearLayoutManager
        binding?.rv?.adapter = recyclerAdapter


    }

    override fun delete(position: Int) {
        data.removeAt(position)
        dataBase.dataDao().deleteData(data[position])
        getdata()
        recyclerAdapter.notifyDataSetChanged()
    }

    private fun getdata() {
        data.addAll(dataBase.dataDao().getdata()?: arrayListOf())
        recyclerAdapter.notifyDataSetChanged()
    }

    override fun update(position: Int) {
        Dialog(this).apply {
            setContentView(R.layout.custom_dialog)
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            var text1 = findViewById<TextView>(R.id.editTextText)
            var text2 = findViewById<TextView>(R.id.editTextText2)
            var add = findViewById<Button>(R.id.Add)

            add?.setOnClickListener {
                if(text1.text.trim().isNullOrEmpty()){
                    text1.error = "enter title"
                }else if (text2.text.trim().isNullOrEmpty()){
                    text2.error = "enter description"
                }else
                {
                    var title_data = text1.text.toString()
                    var description_data = text2.text.toString()
                    data.set(position,MyData(name = title_data, description = description_data))
                    dataBase.dataDao().updateData(MyData(id = data[position].id, name = title_data, description = description_data))
                    recyclerAdapter.notifyDataSetChanged()
                    dismiss()
                }
            }
        }.show()
    }
}