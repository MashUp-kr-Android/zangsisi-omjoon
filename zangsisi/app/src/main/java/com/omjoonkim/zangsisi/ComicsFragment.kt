package com.omjoonkim.zangsisi

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.framgent_comics.*
import java.util.*

class ComicsFragment : Fragment() {

    val adapter: ComicsAdapter by lazy { ComicsAdapter() }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.framgent_comics, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view!!)
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

    private fun initRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(activity.applicationContext)
        adapter.setListener(object : ComicsAdapter.onAdapterEventListener {
            override fun onClick(item: ComicsAdapter.ViewItem) {
                startActivity(Intent(activity, ComicEpListActivity::class.java).putExtra("title", item.title))
            }
        })
        recyclerView.adapter = adapter

    }
}