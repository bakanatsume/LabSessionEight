package com.bipash.labsessioneight.studentAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bipash.labsessioneight.MainActivity
import com.bipash.labsessioneight.R
import com.bipash.labsessioneight.model.Student

class AdapterStudent(
    val context: Context,
    val listStudent : ArrayList<Student>
) : RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.studentlayout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = listStudent[position]
        holder.tvName.text = student.name
        holder.tvAddress.text = student.address
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }
}

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imgProfile : ImageView = itemView.findViewById(R.id.imgProfile)
    val tvName : TextView = itemView.findViewById(R.id.tvName)
    val tvAddress : TextView = itemView.findViewById(R.id.tvAddress)
}
