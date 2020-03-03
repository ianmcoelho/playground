package com.ianmedeiros.featuremultibinding1

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.ianmedeiros.coremodule.di.getApplicationRoot
import com.ianmedeiros.featuremultibinding1.di.MultiBindingComponent
import kotlinx.android.synthetic.main.activity_multibinding.*
import javax.inject.Inject

class AchievementActivity : FragmentActivity() {

    @Inject
    lateinit var viewModel: AchievementUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_feature)
//        getApplicationRoot<MultiBindingComponent>().viewModelComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
//        findViewById<TextView>(R.id.textView).text = viewModel.text
    }
}

class MultibindingActivity : FragmentActivity() {

    @Inject
    lateinit var listUseCase: ListAchievementsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multibinding)
        getApplicationRoot<MultiBindingComponent>().viewModelComponent.inject(this)
    }

    override fun onStart() {
        super.onStart()
        listUseCase.achievementList.forEach { achievement ->
            val button = Button(this)
            button.text = achievement.text
            layoutRoot.addView(button)
        }
    }

}