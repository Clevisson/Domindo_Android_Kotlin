package dominando.android.basico

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.buttonToast)

        button.setOnClickListener {
            val text = editText.text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

        buttonTela2.setOnClickListener {
            val intent = Intent(this, Tela2Activity::class.java)
            startActivity(intent)
            intent.putExtra("nome", "Clévisson")
            intent.putExtra("idade", "26")
            startActivity(intent)
        }

        buttonParcel.setOnClickListener{
            val cliente = Cliente(1, "Clevisson")
            val intent = Intent(this, Tela2Activity::class.java)
            intent.putExtra("cliente", cliente)
            startActivity(intent)
        }
    }

    override fun onStart(){
        super.onStart()
        Log.i("NGVL," , "Tela1::onStart")

    }

    override fun onResume(){
        super.onResume()
        Log.i("NGVL", "tela1::onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("NGVL", "Tela1::onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("NVGL", "Tela1::OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("NGVL", "Tela1::OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("NGVL", "Tela1::onDestroy")
    }
}
