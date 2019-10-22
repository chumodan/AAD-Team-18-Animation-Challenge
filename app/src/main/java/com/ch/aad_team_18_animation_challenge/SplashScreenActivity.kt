package com.ch.aad_team_18_animation_challenge

import android.animation.Animator.DURATION_INFINITE
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        startSplashScreenAnimations()
        runLogoAnimation()
    }

    private fun startSplashScreenAnimations() {
        val animationDrawable = splash_layout.background as AnimationDrawable
        animationDrawable.apply {
            setEnterFadeDuration(AnimationConstants.ENTER_FADE_DURATION)
            setExitFadeDuration(AnimationConstants.EXIT_FADE_DURATION)
            start()
        }

    }

    private fun runLogoAnimation() {
        val topSet = AnimatorSet()
        val rotatexAnimator = ObjectAnimator.ofFloat(logo,"rotateX", 0.0f, 360.0f )
        rotatexAnimator.duration = 4000
        val rotateyAnimator = ObjectAnimator.ofFloat(logo,"rotateY", 0.0f, 360.0f )
        rotateyAnimator.duration = 4000
        val fadeInAnimator = ObjectAnimator.ofFloat(logo,"alpha", 0.2f, 1.0f)
        fadeInAnimator.apply {
            duration = 4000
            repeatMode = ObjectAnimator.REVERSE
            repeatCount = ObjectAnimator.INFINITE
        }

        val fadeInAnimator2 = ObjectAnimator.ofFloat(splash_title,"alpha", 0.2f, 1.0f)
        fadeInAnimator.apply {
            duration = 4000
            repeatMode = ObjectAnimator.REVERSE
            repeatCount= ObjectAnimator.INFINITE
        }
        val innerSet = AnimatorSet()
        innerSet.playTogether(rotatexAnimator, rotateyAnimator)
        topSet.playSequentially(innerSet,fadeInAnimator)
        topSet.start()
    }
}