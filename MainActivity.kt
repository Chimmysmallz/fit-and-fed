// ============================================================================
//  Fit & Fed — MainActivity
// ----------------------------------------------------------------------------
//  ⚠️  IMPORTANT: Do NOT copy the very first "package ..." line from this file.
//
//  When Android Studio creates your project it already puts a line at the very
//  top of MainActivity.kt that looks like:
//
//        package com.example.fitandfed
//
//  KEEP that line. Then delete everything BELOW it and paste in everything
//  below the long dashed line in THIS file (the imports + the class).
// ============================================================================

// ----------------------- paste from here downwards --------------------------

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var web: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        web = WebView(this)
        val s = web.settings
        s.javaScriptEnabled = true          // the app is built in JavaScript
        s.domStorageEnabled = true          // lets your progress save on the phone

        // Make the "🎬 Video" buttons open YouTube in the phone's browser
        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, req: WebResourceRequest): Boolean {
                val url = req.url.toString()
                return if (url.startsWith("http")) {
                    startActivity(Intent(Intent.ACTION_VIEW, req.url))
                    true
                } else false
            }
        }

        // Load the app file that lives inside app/src/main/assets/
        web.loadUrl("file:///android_asset/fit-and-fed.html")

        setContentView(web)
    }

    // Make the phone's Back button move back inside the app instead of closing it
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (web.canGoBack()) web.goBack() else super.onBackPressed()
    }
}
