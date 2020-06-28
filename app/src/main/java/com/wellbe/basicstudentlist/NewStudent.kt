package com.wellbe.basicstudentlist

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.wellbe.basicstudentlist.dao.AlunoDAO
import com.wellbe.basicstudentlist.model.Aluno
import kotlinx.android.synthetic.main.activity_new_student.*

class NewStudent : AppCompatActivity() {
    lateinit var aluno: Aluno

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        title = "Adicionar novo estudante"

        loadExistentStudent()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_save_new_student_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.activity_save_new_student_menu_button) {
            saveNewStudent()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadExistentStudent() {
        if (intent.hasExtra("aluno")) {
            val alunoSerializable = intent.getSerializableExtra("aluno")

            aluno = alunoSerializable as Aluno

            activity_new_student_name.setText(aluno.name)
            activity_new_student_phone.setText(aluno.phone)
            activity_new_student_email.setText(aluno.email)
        } else {
            aluno = Aluno()
        }
    }

    private fun saveNewStudent() {
        aluno.name = activity_new_student_name.text.toString()
        aluno.phone = activity_new_student_phone.text.toString()
        aluno.email = activity_new_student_email.text.toString()

        if (aluno.getHasValidId()) {
            Log.i("editou", "$aluno")
            AlunoDAO.edit(aluno)
        } else {
            Log.i("salvou", "$aluno")
            AlunoDAO.save(aluno)
        }

        finish()
    }
}