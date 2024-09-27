package com.example.myintentapp

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MoveWithObjectActivity : AppCompatActivity() {
//    Menerima data object dari MoveActivity dengan Get Parcelable
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
//    Mengirimkan data parcelable yang sudah diterima ke activity yang lain
    var persons = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject:TextView = findViewById(R.id.tv_object_received)
//      Dikarenakan object yang dikirimkan dengan Parcelable maka harus menggunakan getParcelableExtra() karena tipe data yang beragam
        val person = if(Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }
//      Menampilkan objek yang sudah diterima dari MoveActivity ke TextView
        if (person != null) {
            val text = "Name : ${person.name.toString()},\nEmail : ${person.email}, \nAge :${person.age}, \nLocation : ${person.city}"
            tvObject.text = text
        }

//    Mengirimkan data parcelable yang sudah diterima ke activity yang lain
//        moveWithObjectIntent.putParcelableArrayListExtra(KEY, persons)
//    Menerima data parcelable yang sudah diterima ke activity yang lain
//       intent.getParcelableArrayListExtra(EXTRA_PERSON, Person::class.java)

    }
}