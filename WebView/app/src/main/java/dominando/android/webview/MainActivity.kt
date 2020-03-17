package dominando.android.webview

import android.annotation.TargetApi
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //EXEMPLO DA PÁGINA 215 ATÉ 217
        /*webView.loadUrl("https://www.jetbrains.com/")
        webView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView, url: String) : Boolean {
                view.loadUrl(url)
                return false
            }

            @TargetApi(Build.VERSION_CODES.N)
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                view.loadUrl(request.url.toString())
                return false
            }
        }
    }*/
        //EXEMPLO PÁGINA 218 ATÈ 219
      val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.addJavascriptInterface(this, "dominando")
        webView.loadUrl("file:android_asset/app_page.html")
}
    @JavascriptInterface
    fun showToast(s: String, t: String){
    Toast.makeText(this, "Nome: $s Idade: $t", Toast.LENGTH_SHORT).show()
    }}

