package by.custom.calculatorutilsbor.view

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import by.custom.calculatorutilsbor.R
import by.custom.calculatorutilsbor.databinding.ActivityMainBinding
import by.custom.calculatorutilsbor.model.GeneratorID
import com.google.android.material.navigation.NavigationView
import com.tenjin.android.TenjinSDK
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import java.time.LocalDate
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_contacts, R.id.nav_main, R.id.nav_phones, R.id.nav_website
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        startTenjinSDK()
        startMetrikaCounter()
        val generator = GeneratorID()
        Toast.makeText(this, generator.createID(), Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun startTenjinSDK() {
        val instance: TenjinSDK = TenjinSDK.getInstance(this, "PSVFP1P6AUNJC45VCWGUPY17FWMAWZRK")
        instance.setAppStore(TenjinSDK.AppStoreType.googleplay)
        instance.connect()
    }

    private fun startMetrikaCounter() {
        val config: YandexMetricaConfig =
            YandexMetricaConfig.newConfigBuilder("1ca6aced-d37d-45f3-ab1e-6939d3c7ea03").build()
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(application)
    }
}
