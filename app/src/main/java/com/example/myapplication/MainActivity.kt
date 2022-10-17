package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioButton
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    lateinit var ed_name: EditText
    lateinit var tv_text: TextView
    lateinit var tv_name: TextView
    lateinit var tv_winner: TextView
    lateinit var tv_mmora: TextView
    lateinit var tv_cmora: TextView
    lateinit var btn_scissor: RadioButton
    lateinit var btn_rock: RadioButton
    lateinit var btn_paper: RadioButton
    lateinit var btn_mora: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ed_name = findViewById(R.id.ed_name)
        tv_text = findViewById(R.id.tv_text)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)
        btn_scissor = findViewById(R.id.btn_scissor)
        btn_rock = findViewById(R.id.btn_rock)
        btn_paper = findViewById(R.id.btn_paper)
        btn_mora = findViewById(R.id.btn_mora)
        btn_mora.setOnClickListener(View.OnClickListener
        {
            if (ed_name.length() < 1)
            {
                tv_text.run { println("Please insert a name") }
            }
            else
            {
                tv_name.setText(String.format("Name\n%s",
                        ed_name.getText().toString()))
                if (btn_scissor.isChecked())
                    {
                        tv_mmora.setText("My Guess \n scissor")
                    }
                else if (btn_rock.isChecked())
                    {tv_mmora.setText("My Guess \n rock")}
                else
                    {tv_mmora.setText("My Guess \n paper")}

                val computer = (1..4).random()

                if (computer == 0)
                    {tv_cmora.setText("COM Guess \n scissor")}
                else if (computer == 1)
                    {tv_cmora.setText("COM Guess \n rock")}
                else
                    {tv_cmora.setText("COM Guess \n paper")}

                if (btn_scissor.isChecked() && computer == 2 ||
                        btn_rock.isChecked() && computer == 0 ||
                        btn_paper.isChecked() && computer == 1)
                {
                    tv_winner.setText("""Winner is  ${ed_name.getText()} """.trimIndent())
                    tv_text.setText("Congratulation!")
                } else if (btn_scissor.isChecked() && computer == 1 ||
                            btn_rock.isChecked() && computer == 2 ||
                            btn_paper.isChecked() && computer == 0)
                {
                    tv_winner.setText("""Winner is ${ed_name.getText()}""".trimIndent())
                    tv_text.setText("Congratulation!")
                } else
                {
                    tv_winner.setText("Winner \n draw")
                    tv_text.setText("Draw,try again")
                }
            }
        })
    }
}