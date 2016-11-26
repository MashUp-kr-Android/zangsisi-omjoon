package com.omjoonkim.zangsisi

import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ComicsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActionbar()
        initTabLayout()
    }

    private fun initActionbar() {

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Zangsisi"
    }

    private fun initTabLayout() {
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.setupWithViewPager(viewPager)
    }


    class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment = MainTab.values()[position].fragment


        override fun getCount(): Int = MainTab.values().size


        override fun getPageTitle(position: Int): CharSequence =MainTab.values()[position].title

    }

    enum class MainTab(var fragment: Fragment, var title: String) {

        UnCompleted(ComicsFragment(), "미완결"),
        Completed(ComicsFragment(), "완결")
    }
}