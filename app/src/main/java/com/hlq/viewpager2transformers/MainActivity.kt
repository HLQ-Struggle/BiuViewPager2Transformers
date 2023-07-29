package com.hlq.viewpager2transformers

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.hlq.page2_transformers.*

class MainActivity : AppCompatActivity() {

    var pager2: ViewPager2? = null
    var OrientationManager: RadioGroup? = null
    var transformerSelector: Spinner? = null
    var Transformers: ArrayList<ViewPager2.PageTransformer>? = null
    var transformerNameList = mutableListOf<String>()
    var PageImages = ArrayList<Int>()
    var pagerAdapter: Pager2RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitViews()
    }

    private fun InitViews() {
        Transformers = java.util.ArrayList()
        pager2 = findViewById(R.id.pager2)
        pager2?.offscreenPageLimit = 7
        OrientationManager = findViewById<RadioGroup>(R.id.orientation_group)
        transformerSelector = findViewById<Spinner>(R.id.transformer_selector)
        AddAllTransformers()
        setUpAdapters()
        setUpPagerOrientation()
    }

    private fun setUpAdapters() {
        PageImages.add(R.drawable.moon)
        PageImages.add(R.drawable.mountains)
        PageImages.add(R.drawable.plain)
        PageImages.add(R.drawable.river)
        PageImages.add(R.drawable.setting_sun)
        PageImages.add(R.drawable.snow)
        PageImages.add(R.drawable.volcano)
        pagerAdapter = Pager2RecyclerAdapter(PageImages, this)
        pager2!!.adapter = pagerAdapter
        val selectorAdapter =
            ArrayAdapter<String>(this, R.layout.layout_spinner_item, transformerNameList)
        transformerSelector!!.adapter = selectorAdapter
        transformerSelector!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                pager2 =
                    null //set viewpager2 to null to invalidate previous transformer effects and set new one
                pager2 = findViewById(R.id.pager2)
                pager2?.offscreenPageLimit = 7
                pager2?.adapter = pagerAdapter
                pager2?.setPageTransformer(Transformers!![position])
                OrientationManager!!.clearCheck()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun AddAllTransformers() {
        Transformers!!.add(Pager2_AccordionTransformer())
        transformerNameList.add(Pager2_AccordionTransformer::class.java.simpleName)
        Transformers!!.add(Pager2_AntiClockSpinTransformer())
        transformerNameList.add(Pager2_AntiClockSpinTransformer::class.java.simpleName)
        Transformers!!.add(Pager2_BackDrawTransformer())
        transformerNameList.add(Pager2_BackDrawTransformer::class.java.simpleName)
        Transformers!!.add(Pager2_BackgroundToForegroundTransformer())
        transformerNameList.add(Pager2_BackgroundToForegroundTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_ClockSpinTransformer())
        transformerNameList!!.add(Pager2_ClockSpinTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_CubeInDepthTransformer())
        transformerNameList!!.add(Pager2_CubeInDepthTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_CubeInScalingTransformer())
        transformerNameList!!.add(Pager2_CubeInScalingTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_CubeInTransformer())
        transformerNameList!!.add(Pager2_CubeInTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_CubeOutDepthTransformer())
        transformerNameList!!.add(Pager2_CubeOutDepthTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_CubeOutScalingTransformer())
        transformerNameList!!.add(Pager2_CubeOutScalingTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_CubeOutTransformer())
        transformerNameList!!.add(Pager2_CubeOutTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_DefaultTransformer())
        transformerNameList!!.add(Pager2_DefaultTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_DepthTransformer())
        transformerNameList!!.add(Pager2_DepthTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_DepthTransformer())
        transformerNameList!!.add(Pager2_DepthTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_FanTransformer())
        transformerNameList!!.add(Pager2_FanTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_FidgetSpinTransformer())
        transformerNameList!!.add(Pager2_FidgetSpinTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_ForegroundToBackgroundTransformer())
        transformerNameList!!.add(Pager2_ForegroundToBackgroundTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_GateTransformer())
        transformerNameList!!.add(Pager2_GateTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_HingeTransformer())
        transformerNameList!!.add(Pager2_HingeTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_HorizontalFlipTransformer())
        transformerNameList!!.add(Pager2_HorizontalFlipTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_ParallaxTransformer(R.id.page))
        transformerNameList!!.add(Pager2_ParallaxTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_PopTransformer())
        transformerNameList!!.add(Pager2_PopTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_RotateDownTransformer())
        transformerNameList!!.add(Pager2_RotateDownTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_RotateUpTransformer())
        transformerNameList!!.add(Pager2_RotateUpTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_SpinnerTransformer())
        transformerNameList!!.add(Pager2_SpinnerTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_StackTransformer())
        transformerNameList!!.add(Pager2_StackTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_TabletTransformer())
        transformerNameList!!.add(Pager2_TabletTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_TossTransformer())
        transformerNameList!!.add(Pager2_TossTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_VerticalFlipTransformer())
        transformerNameList!!.add(Pager2_VerticalFlipTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_VerticalShutTransformer())
        transformerNameList!!.add(Pager2_VerticalShutTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_ZoomInTransformer())
        transformerNameList!!.add(Pager2_ZoomInTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_ZoomOutTransformer())
        transformerNameList!!.add(Pager2_ZoomOutTransformer::class.java.getSimpleName())
        Transformers!!.add(Pager2_ZoomOutSlideTransformer())
        transformerNameList!!.add(Pager2_ZoomOutSlideTransformer::class.java.getSimpleName())
    }

    private fun setUpPagerOrientation() {
        OrientationManager!!.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.hori) {
                ResetPagerWithOrientation(ViewPager2.ORIENTATION_HORIZONTAL)
            } else if (checkedId == R.id.verti) {
                ResetPagerWithOrientation(ViewPager2.ORIENTATION_VERTICAL)
            }
        }
    }

    private fun ResetPagerWithOrientation(PAGER2_ORIENTATION: Int) {
        findViewById<ViewPager2>(R.id.pager2)?.apply {
            setOffscreenPageLimit(7)
            setAdapter(pagerAdapter)
            setPageTransformer(Transformers!![transformerSelector!!.selectedItemPosition])
            setOrientation(PAGER2_ORIENTATION)
        }
    }
}