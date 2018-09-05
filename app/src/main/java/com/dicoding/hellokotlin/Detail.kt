package com.dicoding.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class Detail : AppCompatActivity(){
    companion object {
         val NAME = "name"
         val IMAGE = "image"
         val DESC = "description"
    }

    private var nama_team: String = ""
    private var image_team: Int=0
    private var desc_team: String=""

    lateinit var image_v : ImageView
    lateinit var name_v : TextView
    lateinit var desc_v : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        verticalLayout{
            padding = dip(15)

            image_v = imageView().lparams(width = dip(100),
                            height = wrapContent) {
                        gravity = Gravity.CENTER
                    }
            name_v = textView().lparams(width = wrapContent) {
                        gravity = Gravity.CENTER
                        topMargin = dip(12)
                    }

            desc_v = textView().lparams(width = wrapContent) {
                        margin = dip(20)
                    }
        }
        nama_team = intent.getStringExtra(NAME)
        image_team = intent.getIntExtra(IMAGE,0)
        desc_team = intent.getStringExtra(DESC)

        name_v.text = nama_team
        Glide.with(image_v).load(image_team).into(image_v)
        desc_v.text = desc_team
    }
}