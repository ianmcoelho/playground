package com.ianmedeiros.featuremodule2

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.ianmedeiros.coremodule.di.CompositionRoot
import com.ianmedeiros.coremodule.di.getApplicationRoot
import com.ianmedeiros.coremodule.feature.di.FeaturePresentationRoot
import com.ianmedeiros.featuremodule2.di.DaggerFeature2Component

class Feature2Activity : FragmentActivity(), CompositionRoot<FeaturePresentationRoot> {

    override val root: FeaturePresentationRoot by lazy {
        DaggerFeature2Component.factory().create(this, getApplicationRoot())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)
    }

}