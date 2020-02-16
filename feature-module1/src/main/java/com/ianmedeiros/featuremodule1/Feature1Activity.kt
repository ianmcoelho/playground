package com.ianmedeiros.featuremodule1

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.ianmedeiros.coremodule.di.CompositionRoot
import com.ianmedeiros.coremodule.di.getApplicationRoot
import com.ianmedeiros.coremodule.feature.di.FeaturePresentationRoot
import com.ianmedeiros.featuremodule1.di.DaggerFeature1Component

class Feature1Activity : FragmentActivity(), CompositionRoot<FeaturePresentationRoot> {

    override val root: FeaturePresentationRoot by lazy {
        DaggerFeature1Component.factory().create(this, getApplicationRoot())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)
    }

}