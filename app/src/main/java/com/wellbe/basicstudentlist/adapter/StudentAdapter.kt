package com.wellbe.basicstudentlist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.wellbe.basicstudentlist.R
import com.wellbe.basicstudentlist.model.Aluno
import kotlinx.android.synthetic.main.item_student.view.*

class StudentAdapter(private val context: Context) : BaseAdapter() {
    private val students: ArrayList<Aluno> = arrayListOf()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflate = LayoutInflater
            .from(context)
            .inflate(R.layout.item_student, parent, false)

        inflate.item_student_name.text = students[position].name
        inflate.item_student_phone.text = students[position].phone

        return inflate
    }

    override fun getItem(position: Int): Aluno {
        return students[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return students.size
    }

    fun clear() {
        students.clear()
    }

    fun addAll(alunos: MutableList<Aluno>) {
        students.addAll(alunos)
    }

    fun remove(aluno: Aluno) {
        students.remove(aluno)
    }
}