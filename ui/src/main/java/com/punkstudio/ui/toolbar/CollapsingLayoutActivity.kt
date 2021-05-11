package com.punkstudio.ui.toolbar

import android.annotation.SuppressLint
import android.os.Bundle
import com.punkstudio.basic.activity.BaseActivity
import com.punkstudio.ui.R
import kotlinx.android.synthetic.main.activity_collapsing.*

/**
 * Date:2021/2/8-10:26 AM
 * @author Mason
 */
class CollapsingLayoutActivity : BaseActivity() {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing)
        toolbar.apply {
            title = "HD TEST"
            navigationIcon = getDrawable(android.R.drawable.ic_menu_add)
        }
    }
}