package com.example.demo_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val photoAdapter = PhotoAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        val photos = listOf(
            Photo(
                1,
                "Nguyen Van A",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                2,
                "Nguyen Van B",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                3,
                "Nguyen Van C",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                4,
                "Nguyen Van D",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                5,
                "Nguyen Van E",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                6,
                "Nguyen Van F",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                7,
                "Tran Van A",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                8,
                "Tran Van B",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                9,
                "Tran Van C",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                10,
                "Tran Van D",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                11,
                "Tran Van E",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            ),
            Photo(
                12,
                "Tran Van F",
                "https://www.nretnil.com/avatar/LawrenceEzekielAmos.png"
            )
        )
        photoAdapter.updateData(photos)
        //helllll
    }

    private fun initView() {
        recyclerViewPhotos.adapter = photoAdapter.apply {
            onItemClick = { item, position ->
                Toast.makeText(this@MainActivity, "Photo($position) : ${item.title}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}