package dominando.android.textview

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtStrike.paintFlags = txtStrike.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        val htmlTxt = """
            <html>
            <body>Html em <b>Negrito</b>, <i>Itálico<i/>
            e <u>Sublinhado</u>.br
            
            Mario:<img src='mario.png' /><br>
            Yoshi:<img src='yoshi.png' /><br>
                    
            um texto depois da imagem
            </body>
            </html>"""

        val imgGetter = Html.ImageGetter { source ->
            try {
                val bmp = BitmapFactory.decodeStream(assets.open(source))
                val drawable = BitmapDrawable(resources, bmp)
                drawable.setBounds(0, 0, bmp.width, bmp.height)
                drawable
            } catch (e: IOException) {
                e.printStackTrace()
                null
            }
        }
        txthtml.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(htmlTxt, Html.FROM_HTML_MODE_COMPACT, imgGetter, null)
        } else {
            Html.fromHtml(htmlTxt, imgGetter, null)
        }
    }
}


