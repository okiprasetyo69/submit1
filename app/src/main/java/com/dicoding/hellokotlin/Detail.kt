package com.dicoding.hellokotlin

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*

class Detail : AnkoComponent<ViewGroup>{
    companion object {
        val img = 1
        val name = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout{
            lparams(matchParent, wrapContent)
            padding = dip(16)

            imageView{
                id = img
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)

            }.lparams(width = matchParent){
                topMargin = dip(5)
            }

            textView{
                //name = name1
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
            }.lparams(width = matchParent){
                topMargin = dip(5)
            }
        }
    }
}