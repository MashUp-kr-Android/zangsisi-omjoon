package com.omjoonkim.zangsisi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_comic_ep_list.*
import java.util.*

class ComicEpListActivity : AppCompatActivity() {

    val adapter: ComicsAdapter by lazy { ComicsAdapter(null) }

    var title: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_ep_list)
        title = intent.getStringExtra("title")

        initActionbar()
        initRecyclerView()
        setDummyData()
    }

    private fun setDummyData() {

        adapter.setDatas(getDummyListData())
        adapter.notifyDataSetChanged()
    }

    fun getDummyListData(): List<ComicsAdapter.ViewItem> {

        val dummyListData = ArrayList<ComicsAdapter.ViewItem>()
        val item = ComicsAdapter.ViewItem()
        item.title = "title"
        item.lecture = "lecture"
        dummyListData.add(item)
        dummyListData.add(item)
        dummyListData.add(item)
        dummyListData.add(item)
        dummyListData.add(item)
        dummyListData.add(item)

        return dummyListData
    }

    private fun initActionbar() {

        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.home, android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}