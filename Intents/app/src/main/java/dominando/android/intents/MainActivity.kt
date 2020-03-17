package dominando.android.intents

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.intents_actions))
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            openIntentAtPosition(position)
        }
    }

    private fun openIntentAtPosition(position: Int) {
        val uri: Uri?
        val intent: Intent?

        when (position) {
            0 -> {// Abrindo Url
                uri = Uri.parse("https://www.helibras.com.br")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }

            1 -> {// Realiza uma chamada
                uri = Uri.parse("tel: (33)999487596")
                intent = Intent(Intent.ACTION_DIAL, uri)
                openIntent(intent)
            }
            2 -> {// Pesquisa uma posicao do mapa
                uri = Uri.parse("geo: 0,0?q=Rua+Amelia,Recife")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            3 -> {// AbrindoEditorSms
                uri = Uri.parse("sms: 12345")
                intent = Intent(Intent.ACTION_VIEW, uri)
                    .putExtra("sms_body", "Corpo do SMS")
                openIntent(intent)
            }

            4 -> {// Compartilhar
                intent = Intent()
                    .setAction(Intent.ACTION_SEND)
                    .putExtra(Intent.EXTRA_TEXT, "Compartilhando via Intent.")
                    .setType("text/plain")
                openIntent(intent)
            }

            5 -> {// Alarme
                intent = Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar Android")
                    .putExtra(AlarmClock.EXTRA_HOUR, 19)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 0)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                    .putExtra(AlarmClock.EXTRA_DAYS, arrayListOf(
                        Calendar.MONDAY,
                        Calendar.WEDNESDAY,
                        Calendar.FRIDAY)
                    )
                openIntent(intent)
            }

            6 -> {// Busca na web
                intent = Intent(Intent.ACTION_SEARCH)
                    .putExtra(SearchManager.QUERY, "Kotlin")
                openIntent(intent)
            }

            7 -> {// Configuraçções do aparelho
                intent = Intent(Settings.ACTION_SETTINGS)
                openIntent(intent)
            }

            8 -> {// Ação customizada 1
                intent = Intent("dominando.android.CUSTOM_ACTION")
                openIntent(intent)
            }

            9 -> {//Açao personalizada 2
                uri = Uri.parse("produto//Macbook/Air")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            else -> finish()
        }
    }

    private fun openIntent(intent: Intent){
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }  else {
            Toast.makeText(this, R.string.error_intent, Toast.LENGTH_SHORT).show()
        }
    }
}

