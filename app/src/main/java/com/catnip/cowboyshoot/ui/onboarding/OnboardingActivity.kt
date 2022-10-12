package com.catnip.cowboyshoot.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.catnip.cowboyshoot.R
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment

class OnboardingActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        if (currentFragment is OnFinishNavigateListener){
            currentFragment.onFinishNavigateListener()
        }
    }

    private fun setupSliderFragment(){
        isSkipButtonEnabled = false
        addSlide(AppIntroFragment.createInstance(
            title = getString(R.string.text_title_onboarding_1),
            description = getString(R.string.text_desc_onboarding_1),
            imageDrawable = R.drawable.ic_cowboy_left_shoot_true,
            titleTypefaceFontRes = R.font.pixelated_font,
            descriptionTypefaceFontRes = R.font.pixelated_font,
            titleColorRes = R.color.white
        ))
        addSlide(AppIntroFragment.createInstance(
            title = getString(R.string.text_title_onboarding_2),
            description = getString(R.string.text_desc_onboarding_2),
            imageDrawable = R.drawable.ic_cowboy_left_shoot_true,
            titleTypefaceFontRes = R.font.pixelated_font,
            descriptionTypefaceFontRes = R.font.pixelated_font,
            titleColorRes = R.color.white
        ))
    }
}

interface OnFinishNavigateListener{
    fun onFinishNavigateListener()
}