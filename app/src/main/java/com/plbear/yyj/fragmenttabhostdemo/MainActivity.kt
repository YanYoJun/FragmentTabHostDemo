package com.plbear.yyj.fragmenttabhostdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var titles = arrayOf("tab1","tab2","tab3","tab4")
    var tabImg = arrayOf(R.drawable.tab,R.drawable.tab,R.drawable.tab,R.drawable.tab)
    var fragments = arrayOf(MyFragment1::class.java, Fragment2::class.java, Fragment3::class.java, Fragment4::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTabWidget()
    }

    fun initTabWidget(){
        tab_host.setup(this,supportFragmentManager,android.R.id.tabcontent)

        for(i in 0..3){
            var v = layoutInflater.inflate(R.layout.layout_tab,null)
            var img = v.findViewById<android.widget.ImageView>(R.id.iv_tab)
            var lab = v.findViewById<TextView>(R.id.tv_tab)
            img.setImageResource(tabImg[i])
            lab.setText(titles[i])
            tab_host.addTab(tab_host.newTabSpec(""+i).setIndicator(v),fragments[i],null)
        }
        tab_host.setCurrentTabByTag("1")
    }
}
