# Build "Fit & Fed" for iPhone (iOS)

Same idea as the Android build: a tiny wrapper app that displays your
`fit-and-fed.html` inside a web view. You reuse the **exact same app file and
Firebase config** — only the wrapper differs.

## What you need first (the honest bit)
- **A Mac** with **Xcode** (free from the Mac App Store). You cannot build iOS
  apps on Windows or on Android Studio — Apple requires a Mac.
- **To test on your own iPhone:** a free Apple ID is enough (apps signed with a
  free account expire after 7 days — fine for trying it).
- **To publish on the App Store:** the **Apple Developer Program — $99 / year**
  (recurring, unlike Google's one-time $25).

> 💡 Do **FIREBASE-SETUP.md** first and paste your config into `fit-and-fed.html`,
> so the file you bundle already has login switched on.

---

## STEP 1 — Create the project
1. Open **Xcode** → **File → New → Project** → **App** → **Next**.
2. Set:
   - **Product Name:** `Fit and Fed`
   - **Interface:** **SwiftUI**
   - **Language:** **Swift**
3. Pick a folder → **Create**.

## STEP 2 — Add your app file
1. Drag **`fit-and-fed.html`** from Finder into the Xcode left panel (drop it
   under the project's main folder).
2. In the dialog: tick **Copy items if needed**, and make sure your app target is
   **checked** under "Add to targets" → **Finish**.

## STEP 3 — Paste in the web-view code
1. In the left panel, open **`ContentView.swift`**.
2. Select **all** of it and replace everything with the code below:

```swift
import SwiftUI
import WebKit

struct WebView: UIViewRepresentable {
    func makeCoordinator() -> Coordinator { Coordinator() }

    func makeUIView(context: Context) -> WKWebView {
        let config = WKWebViewConfiguration()
        config.defaultWebpagePreferences.allowsContentJavaScript = true
        let web = WKWebView(frame: .zero, configuration: config)
        web.navigationDelegate = context.coordinator
        web.uiDelegate = context.coordinator
        if let url = Bundle.main.url(forResource: "fit-and-fed", withExtension: "html") {
            web.loadFileURL(url, allowingReadAccessTo: url.deletingLastPathComponent())
        }
        return web
    }

    func updateUIView(_ uiView: WKWebView, context: Context) {}

    class Coordinator: NSObject, WKNavigationDelegate, WKUIDelegate {
        // Open the "🎬 Video" links (window.open) in Safari
        func webView(_ webView: WKWebView,
                     createWebViewWith configuration: WKWebViewConfiguration,
                     for navigationAction: WKNavigationAction,
                     windowFeatures: WKWindowFeatures) -> WKWebView? {
            if let url = navigationAction.request.url { UIApplication.shared.open(url) }
            return nil
        }
        // Open normal external http(s) links in Safari too
        func webView(_ webView: WKWebView,
                     decidePolicyFor navigationAction: WKNavigationAction,
                     decisionHandler: @escaping (WKNavigationActionPolicy) -> Void) {
            if let url = navigationAction.request.url,
               (url.scheme == "http" || url.scheme == "https"),
               navigationAction.navigationType == .linkActivated {
                UIApplication.shared.open(url)
                decisionHandler(.cancel)
                return
            }
            decisionHandler(.allow)
        }
    }
}

struct ContentView: View {
    var body: some View {
        WebView().ignoresSafeArea()
    }
}
```

3. Save (**⌘S**). You don't need to touch any other file — the app's entry point
   already shows `ContentView`.

## STEP 4 — Run it
- **On the simulator:** pick an iPhone at the top → press **▶ Run**.
- **On your iPhone:** plug it in, select it at the top, set your free Apple ID
  under **Signing & Capabilities** if asked, then **▶ Run**.

Your progress saving (localStorage) and login (Firebase) both work — WKWebView
keeps storage between launches, and iOS allows the internet by default (no extra
permission step like Android needs).

---

## STEP 5 — Add the app icon
1. In the left panel open **Assets** (Assets.xcassets) → **AppIcon**.
2. Drag **`app-icon-1024-ios.png`** (in your output folder, the full-bleed
   1024×1024 one) onto the large "1024pt" App Store slot. Modern Xcode generates
   the smaller sizes for you.

## STEP 6 — Publish to the App Store (needs the $99 account)
1. Join the **Apple Developer Program** ($99/year) and sign in to
   **App Store Connect** (appstoreconnect.apple.com).
2. In App Store Connect, **create a new app** record (name, bundle ID, etc.).
3. In Xcode: **Product → Archive** → when it finishes, the **Organizer** opens →
   **Distribute App → App Store Connect → Upload**.
4. Back in App Store Connect, fill the listing (you can reuse the text from
   `STORE-LISTING.md` and the screenshots you take) and **Submit for review**.
5. Apple reviews it (often 1–3 days).

> ⚠️ **Apple is stricter than Google about web-view apps** (App Store Guideline
> 4.2, "minimum functionality"). Pure website wrappers get rejected — but apps
> with real, app-like features generally pass. Yours qualifies: it's a full
> offline experience with workouts, trackers, timers, and login. If a reviewer
> ever pushes back, tell me and I'll help you respond.

---

## Reusing your assets across both stores
| Asset | Android (Play) | iOS (App Store) |
|---|---|---|
| App file | `fit-and-fed.html` | same file |
| Firebase config | same | same |
| Icon | `app-icon-512.png` | `app-icon-1024-ios.png` |
| Listing text | `STORE-LISTING.md` | reuse the same |
| Privacy policy URL | same hosted link | same hosted link |

One app, one account system, two stores. 🎉
