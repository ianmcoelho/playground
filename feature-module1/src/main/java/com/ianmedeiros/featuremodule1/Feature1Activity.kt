package com.ianmedeiros.featuremodule1

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.ianmedeiros.coremodule.di.CompositionRoot
import com.ianmedeiros.coremodule.di.getApplicationRoot
import com.ianmedeiros.coremodule.feature.di.FeatureComponent
import com.ianmedeiros.featuremodule1.di.Feature1ComponentRoot

class Feature1Activity : FragmentActivity(), CompositionRoot<FeatureComponent> {

    override val root: FeatureComponent by lazy {
        getApplicationRoot<Feature1ComponentRoot>().feature1Component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)
    }

}