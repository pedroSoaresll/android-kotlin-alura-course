package com.wellbe.basicstudentlist.dao

import android.util.Log
import com.wellbe.basicstudentlist.model.Aluno

class AlunoDAO {
    companion object {
        val alunos: MutableList<Aluno> = mutableListOf()
        var id: Int = 1
        fun save(aluno: Aluno) {
            aluno.id = id

            Log.i("aluno aqui", "${aluno.id}, ${aluno.getHasValidId()}")
            alunos.add(aluno)

            id += 1
        }

        fun edit(aluno: Aluno) {
            Log.i("aluno editado", "$aluno.name")

            alunos.forEachIndexed {index, item ->
                if (item.id == aluno.id) {
                    alunos[index] = aluno
                }
            }
        }

        fun remove(aluno: Aluno?) {
            if (aluno == null) return
            alunos.remove(aluno)
        }
    }

}
