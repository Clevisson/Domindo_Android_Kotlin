package dominando.android.basico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_tela2.*

class Tela2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)
        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        val cliente = intent.getParcelableExtra<Cliente>("cliente")
        textMensagem.text = if (cliente != null) {
            "Nome:${cliente.nome} / Código: ${cliente.codigo}"
        } else {
            "Nome:$nome / Idade: $idade"
        }
    }
    override fun onStart(){
        super.onStart()
        Log.i("NGVL," , "Tela2::onStart")

    }

    override fun onResume(){
        super.onResume()
        Log.i("NGVL", "tela2::onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("NGVL", "Tela2::onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("NVGL", "Tela2::OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("NGVL", "Tela2::OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("NGVL", "Tela2::onDestroy")
    }
}

