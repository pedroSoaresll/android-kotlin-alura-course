package com.wellbe.basicstudentlist

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.wellbe.basicstudentlist.adapter.StudentAdapter
import com.wellbe.basicstudentlist.dao.AlunoDAO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: StudentAdapter
    lateinit var studentList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Lista de alunos"

        configureAdapter()
        handleClickFloatingButton()
    }

    override fun onResume() {
        super.onResume()

        adapter.clear()
        adapter.addAll(AlunoDAO.alunos)

        addStudentInListView()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.activity_student_list_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.activity_studednt_list_menu_remove) {
            val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
            val aluno = adapter.getItem(menuInfo.position)

            adapter.remove(aluno)
            adapter.notifyDataSetChanged()
        }

        return super.onContextItemSelected(item)
    }

    private fun handleClickFloatingButton() {
        activity_main_floating_button.setOnClickListener {
            val intent = Intent(this, NewStudent::class.java)
            startActivity(intent)
        }
    }

    private fun  addStudentInListView() {
        handleClickStudentFromList()
    }

    private fun configureAdapter() {
        studentList = activity_main_student_list
        registerForContextMenu(studentList)

        adapter = StudentAdapter(this)

        studentList.adapter = adapter
    }

    private fun handleClickStudentFromList() {
        studentList.setOnItemClickListener { parent, view, position, id ->
            val aluno = AlunoDAO.alunos[position]
            val intent = Intent(this, NewStudent::class.java)

            intent.putExtra("aluno", aluno)

            startActivity(intent)
        }
    }
}