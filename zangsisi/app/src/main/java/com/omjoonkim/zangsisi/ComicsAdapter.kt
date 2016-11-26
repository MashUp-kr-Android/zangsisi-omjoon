package com.omjoonkim.zangsisi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.viewholder_main_item.view.*
import java.util.*

class ComicsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    interface onAdapterEventListener {

        fun onClick(item: ViewItem)
    }

    var datas: List<ViewItem> = ArrayList()
    lateinit var listener: onAdapterEventListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemView =
            ItemView(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_main_item, parent, false), listener)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ItemView)
            holder.bindView(datas[position])
    }

    fun setDatas(datas: List<ViewItem>): ComicsAdapter {

        this.datas = datas
        return this
    }

    override fun getItemCount(): Int {

        return datas.size
    }

    fun setListener(listener: onAdapterEventListener): ComicsAdapter {

        this.listener = listener
        return this
    }

    class ViewItem {

        internal var title: String? = null
        internal var image: Int = 0
        internal var lecture: String? = null
    }

    class ItemView(itemView: View, var listener: onAdapterEventListener) : RecyclerView.ViewHolder(itemView) {

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bindView(item: ViewItem) {

            itemView.textView_title?.text = item.title
            itemView.textView_lecture?.text = item.lecture

            itemView.setOnClickListener { listener.onClick(item) }
        }
    }
}