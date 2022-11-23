package com.example.task5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.task5.SecondActivity.Companion.modal
import com.example.task5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val secondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    companion object{
      var modal=ArrayList<DaysData>()
    }

    var modalclone=ArrayList<DaysData>()

    private var checked : String =""
    private var boolean : Boolean =false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(secondBinding.root)

        secondBinding.btnDone.setOnClickListener {
            if (secondBinding.personName.text.isEmpty()){
                Toast.makeText(this, "Pls enter your name", Toast.LENGTH_SHORT).show()
            } else{

             val name = secondBinding.personName.text.trim().toString()
                val intent = Intent(this,MainActivity::class.java)

                val sunday = secondBinding.sun.isChecked
                val monday = secondBinding.mon.isChecked
                val tuesday = secondBinding.tue.isChecked
                val wednesday = secondBinding.wed.isChecked
                val thursday = secondBinding.thu.isChecked
                val friday = secondBinding.fri.isChecked
                val saturday = secondBinding.sat.isChecked

               checked = (if (sunday)  "SUN,"  else "") +
                       (if (monday) "MON," else "") +
                       (if (tuesday) "TUE," else "")+
                       (if (wednesday) "WED," else "")+
                       (if (thursday) "THU," else "")+
                       (if (friday) "FRI," else "")+
                       (if (saturday) "SAT," else "")

                if (MainActivity.output.isNotEmpty()) {
                        for(j in 0 until modal.size){
                           if (j==MainActivity.pos){
                            modal.set(index = MainActivity.pos,(DaysData(name, checked)))
                                Log.d("manoj", modal.toString())
                            } else {

                            }
                        }
                }else{
                        modal.add(DaysData(name,checked))
                    }
                }



                onBackPressed()
            }
        }

    override fun onStart() {
        super.onStart()
        var s = ""
        val check: ArrayList<String> = ArrayList()
        for (i in 0 until MainActivity.output.size){
            for (k in 0 until modal.size) {
                if (MainActivity.output[i].personName == modal[k].personName) {
                    secondBinding.personName.setText(MainActivity.output[i].personName)
                    s = MainActivity.output[i].days
                    for (j in s.split(',')) {
                        if (j != "") {
                            check.add(j)
                        }
                    }
                }

                for (i in check) {
                    when (i) {
                        "SUN" -> {
                            secondBinding.sun.isChecked = true
                        }
                        "MON" -> {
                            secondBinding.mon.isChecked = true
                        }
                        "TUE" -> {
                            secondBinding.tue.isChecked = true
                        }
                        "WED" -> {
                            secondBinding.wed.isChecked = true
                        }
                        "THU" -> {
                            secondBinding.thu.isChecked = true
                        }
                        "FRI" -> {
                            secondBinding.fri.isChecked = true
                        }
                        else -> {
                            secondBinding.sat.isChecked = true
                        }
                    }
                }
            }
            }
    }
}

