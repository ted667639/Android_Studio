package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)

        btn_mora.setOnClickListener{
            if (ed_name.length()<1){
                tv_text.text="請輸入玩家姓名"
                return@setOnClickListener
            }
            val playername = ed_name.text
            val commora = (Math.random()*3).toInt()
            val plaermoratext = when{
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "布"
            }
            val commratext = when(commora){
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }
            tv_name.text = "名字\n$playername"
            tv_mmora.text = "我方出拳\n$plaermoratext"
            tv_cmora.text = "電腦出拳\n$commratext"
            when {
                btn_scissor.isChecked && commora == 2 ||
                        btn_stone.isChecked && commora == 0 ||
                        btn_paper.isChecked && commora == 1 ->{
                    tv_winner.text = "勝利者\n$playername"
                    tv_text.text = "恭喜你獲勝!!!"
                }
                btn_scissor.isChecked && commora == 1 ||
                        btn_stone.isChecked && commora == 2 ||
                        btn_paper.isChecked && commora == 0 ->{
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "可惜，電腦獲勝了!"
                }
                else -> {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局，請在試一次"
                }
            }
        }
    }
}