package com.ianmedeiros.featuremultibinding1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.ianmedeiros.coremodule.di.getApplicationRoot
import com.ianmedeiros.featuremultibinding1.di.AchievementsComponent
import com.ianmedeiros.featuremultibinding1.domain.AchievementsType
import kotlinx.android.synthetic.main.activity_multibinding.*
import javax.inject.Inject

class AchievementActivity : FragmentActivity() {

    @Inject
    lateinit var viewModel: AchievementViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_feature)
        getApplicationRoot<AchievementsComponent>().fragmentComponent.create(type).inject(this)
    }

    val type: AchievementsType
        get() = AchievementsType.fromString(intent.extras!!.getString("TYPE")!!)

    override fun onStart() {
        super.onStart()
        findViewById<TextView>(R.id.textView).text = viewModel.text
    }
}

class AchievementListActivity : FragmentActivity() {

    @Inject
    lateinit var listUseCase: ListAchievementsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multibinding)
        getApplicationRoot<AchievementsComponent>().listComponent.inject(this)

        listUseCase.achievementList.forEach { achievement ->
            Button(this).apply {
                text = achievement.type.toString()
                setOnClickListener {
                    val intent = Intent(this@AchievementListActivity, AchievementActivity::class.java).apply {
                        putExtra("TYPE", achievement.type.toString())
                    }
                    startActivity(intent)
                }
                layoutRoot.addView(this)
            }
        }
    }

}