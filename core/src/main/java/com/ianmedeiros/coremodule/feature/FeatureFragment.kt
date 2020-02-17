package com.ianmedeiros.coremodule.feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ianmedeiros.corecontracts.FeatureInteractor
import com.ianmedeiros.coremodule.R
import com.ianmedeiros.coremodule.di.getPresentationRoot
import com.ianmedeiros.coremodule.feature.di.FeatureComponent
import kotlinx.android.synthetic.main.fragment_feature.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeatureFragment : Fragment() {

    @Inject
    lateinit var interactor: FeatureInteractor

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getPresentationRoot<FeatureComponent>().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_feature, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            textView.text = interactor.loadFeatureContent().text
        }
    }
}