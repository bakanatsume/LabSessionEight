package com.bipash.labsessioneight

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bipash.labsessioneight.model.Student
import com.bipash.labsessioneight.studentAdapter.AdapterStudent
import java.sql.BatchUpdateException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var listOfStudent = ArrayList<Student>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAdd : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=GridLayoutManager(this,2);
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnAdd ->{
                startActivityForResult(Intent(this, Form::class.java), 1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode== Activity.RESULT_OK){
                var student = data?.getSerializableExtra("getDetails") as Student
                listOfStudent.add(student)
                val adapter = AdapterStudent(
                    this,
                    listOfStudent
                )

                recyclerView.adapter = adapter
            }
        }
    }
}