package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveintent = Intent(this@MainActivity, MoveActivityDialog::class.java)
                startActivity(moveintent)
            }

            R.id.btn_move_activity_data -> {
            val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
//            putExtra = mengirimkan data ke MoveWithDataActivity dengan objek intent yang merupakan metode key-value
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "dicodingAcademy Boy")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

//            Mengirimkan data object ke MoveWithObjectActivity dengan put Parcelable
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "DicodingAcademy",
                    5,
                    "john.mckinley@examplepetstore.com",
                    "Bandung"
                )
            val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
            startActivity(moveWithObjectIntent)
            }

//            Intent implicit untuk melakukan dial sebuah nomor telepon
            R.id.btn_dial_number -> {
                val phoneNumber = "08120841382"
//                Action Intent untuk melakukan dial sebuah nomor telepon
//                ADCTION_DIAL menentukan intent filter dari aplikasi aplikasi yang bisa menangani action tersebut
                val dialPhoneintent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneintent)
            }


        }
    }
}
