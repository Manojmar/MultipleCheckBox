package com.example.task5

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object{
        var output=ArrayList<DaysData>()
        var pos:Int=0
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        mainBinding.btnAdd.setOnClickListener {
            output.clear()
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        mainBinding.recyclerview.adapter = ListAdapter(SecondActivity.modal,::onClcik)
        mainBinding.recyclerview.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
    }

    private fun onClcik(daysData: DaysData,position:Int) {
      output.clear()
      output.add(daysData)
        pos=position
    }

}