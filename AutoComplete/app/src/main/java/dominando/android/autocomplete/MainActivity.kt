package dominando.android.autocomplete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cities = listOf<String>(
            "Pedra Azul",
            "Almenara",
            "Jequitinhonha",
            "Vitória da Conquista"
        )
        val adapter = CitySearchAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)
        actCities.setAdapter(adapter)
    }
}

