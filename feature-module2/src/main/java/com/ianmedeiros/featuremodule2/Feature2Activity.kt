package com.ianmedeiros.featuremodule2

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.ianmedeiros.coremodule.di.CompositionRoot
import com.ianmedeiros.coremodule.di.getApplicationRoot
import com.ianmedeiros.coremodule.feature.di.FeatureComponent
import com.ianmedeiros.featuremodule2.di.Feature2ComponentRoot

class Feature2Activity : FragmentActivity(), CompositionRoot<FeatureComponent> {

    override val root: FeatureComponent by lazy {
        getApplicationRoot<Feature2ComponentRoot>().feature2Component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)
    }

}