package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Set Adapter
        //Linear layout manager

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }

        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }
}

val contacts = listOf(
    Contact(
        name = "Roberta",
        phone = "(55) 11 816066562",
        icon = R.drawable.sample1
    ),
    Contact(
        name = "Denis",
        phone = "(55) 16 996066562",
        icon = R.drawable.sample2
    ),
    Contact(
        name = "Juliana",
        phone = "(55) 16 766066565",
        icon = R.drawable.sample3
    ),
    Contact(
        name = "Flavia",
        phone = "(55) 18 996088562",
        icon = R.drawable.sample4
    ),
    Contact(
        name = "Jenifer",
        phone = "(55) 22 995266564",
        icon = R.drawable.sample5
    ),
    Contact(
        name = "Leticia",
        phone = "(55) 87 998766511",
        icon = R.drawable.sample6
    ),
    Contact(
        name = "Viviane",
        phone = "(55) 15 996066987",
        icon = R.drawable.sample7
    ),
    Contact(
        name = "Mateus",
        phone = "(55) 16 978666523",
        icon = R.drawable.sample8
    ),
    Contact(
        name = "Felipe",
        phone = "(55) 21 764566549",
        icon = R.drawable.sample9
    ),
    Contact(
        name = "Alex",
        phone = "(55) 43 778966588",
        icon = R.drawable.sample10
    ),
    Contact(
        name = "Katsuko",
        phone = "(55) 77 456066555",
        icon = R.drawable.sample11
    ),
    Contact(
        name = "Mohamed",
        phone = "(87) 33 446234599",
        icon = R.drawable.sample12
    ),
    Contact(
        name = "Michele",
        phone = "(55) 12 786065462",
        icon = R.drawable.sample13
    ),
    Contact(
        name = "Pablo",
        phone = "(55) 11 923061262",
        icon = R.drawable.sample14
    ),
    Contact(
        name = "Jessica",
        phone = "(55) 11 986412577",
        icon = R.drawable.sample15
    ),
    Contact(
        name = "Maria",
        phone = "(55) 18 546072961",
        icon = R.drawable.sample16
    )
)