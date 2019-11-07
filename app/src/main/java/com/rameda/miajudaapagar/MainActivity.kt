package com.rameda.miajudaapagar

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import android.graphics.Color.parseColor
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import br.com.cielo.librarycielolinkpagamentos.CieloPaymentsLinkCallbacks
import br.com.cielo.librarycielolinkpagamentos.CieloPaymentsLinkClient
import br.com.cielo.librarycielolinkpagamentos.models.CieloPaymentsLinkParameters
import br.com.cielo.librarycielolinkpagamentos.models.SaleType
import br.com.cielo.librarycielolinkpagamentos.models.Transaction
import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.recurrent.RecurrentInterval
import br.com.cielo.librarycielolinkpagamentos.models.paymentlink.shipping.ShippingType
import br.com.cielo.librarycielolinkpagamentos.service.Environment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bar = supportActionBar
        bar?.hide()
        getWindow()?.setStatusBarColor(Color.BLACK)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }
























    fun cielo(){
        val paymentsLink = CieloPaymentsLinkClient(
            environment= Environment.SANDBOX,
            clientID = "[CLIENT_ID]",
            clientSecret = "[CLIENT_SECRET]"
        )
        val parameters = CieloPaymentsLinkParameters(
            "nome_do_pedido", "400000", SaleType.DIGITAL, ShippingType.CORREIOS,
            "entrega_teste", "10000", recurrentInterval = RecurrentInterval.MONTHLY
        )

        paymentsLink.generateLink(parameters, object :
            CieloPaymentsLinkCallbacks {
            override fun onGetLink(response: Transaction) {
               // txt1.text = response.shortUrl
            }

            override fun onError(error: String) {
              //  txt1.text = "error generating link, $error"
            }
        })
    }
}
