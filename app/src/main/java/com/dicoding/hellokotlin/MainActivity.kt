package com.dicoding.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.dicoding.hellokotlin.R.array.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initData()


        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items){itemClicked(it)
        }

    }

    private fun itemClicked(item: Item){
        startActivity<Detail>(Detail.NAME to item.name,
                    Detail.IMAGE to item.image,
                    Detail.DESC to item.desc)
    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val desc =  resources.getStringArray(club_desc)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0), desc[i]))
        }

        //Recycle the typed array
        image.recycle()
    }
}