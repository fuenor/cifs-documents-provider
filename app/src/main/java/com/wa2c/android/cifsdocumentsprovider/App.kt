package com.wa2c.android.cifsdocumentsprovider

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.akexorcist.localizationactivity.ui.LocalizationApplication
import com.wa2c.android.cifsdocumentsprovider.common.utils.initLog
import com.wa2c.android.cifsdocumentsprovider.domain.repository.AppRepository
import com.wa2c.android.cifsdocumentsprovider.presentation.ui.common.mode
import dagger.hilt.android.HiltAndroidApp
import java.util.*
import javax.inject.Inject

@HiltAndroidApp
class App: LocalizationApplication() {

    @Inject
    lateinit var repository: AppRepository

    override fun getDefaultLanguage(context: Context): Locale {
        return Locale.getDefault()
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(repository.uiTheme.mode) // Set theme

        repository.migrate()

        initLog(BuildConfig.DEBUG)
    }
}
