# Build the "Fit & Fed" Android app (APK)

You only need the 3 files in this folder:
- `fit-and-fed.html`  → the actual app
- `MainActivity.kt`   → the code to paste
- this guide

**The short version:** make a new project → paste one code file → drop the HTML
into an `assets` folder → add one internet-permission line → press Run.
About 15 minutes the first time.

> 💡 **Do login first.** If you want accounts/sync, follow **FIREBASE-SETUP.md**
> and paste your Firebase config into `fit-and-fed.html` **before** Step 3 below,
> so the version you bundle already has login switched on. (Skipping this is fine
> too — the app still works offline; you can rebuild later once login is set up.)

---

## STEP 1 — Create a new project

1. Open **Android Studio** → **New Project**.
2. From the templates, choose **Empty Views Activity**.
   ⚠️ Pick **Empty *Views* Activity** — NOT "Empty Activity". This matters.
3. Click **Next** and set:
   - **Name:** `Fit and Fed`  (this becomes the app's name on the phone)
   - **Language:** **Kotlin**
   - **Minimum SDK:** leave the default (API 24 is fine)
   - Leave the package name as it is (e.g. `com.example.fitandfed`).
4. Click **Finish**. Wait for it to finish loading / "Gradle sync" at the bottom.
   If it asks to download/install anything (SDK, build tools), say **yes/accept**.

---

## STEP 2 — Paste in the app code

1. In the left panel (Project view), open:
   `app` → `src` → `main` → `java` (or `kotlin`) → your package → **MainActivity.kt**
2. Look at the **very first line** — it says `package com.example.something`.
   **Keep that one line.**
3. **Delete everything below that package line.**
4. Open the `MainActivity.kt` file from this folder, copy everything **below the
   dashed "paste from here" line**, and paste it right under your package line.
5. Save (Ctrl+S / Cmd+S).

Don't worry about red underlines for a second — they clear once you sync.

---

## STEP 3 — Add the app file (the HTML)

1. In the left panel, right-click the **`app`** folder →
   **New** → **Folder** → **Assets Folder** → **Finish**.
   (This creates `app/src/main/assets`.)
2. On your computer, copy **`fit-and-fed.html`** from this folder.
3. Paste it **into that new `assets` folder** in Android Studio
   (right-click `assets` → **Paste**, or just drag the file in).
4. Make sure the file is named exactly **`fit-and-fed.html`** — it must match
   the name in the code.

---

## STEP 4 — Allow internet (needed for login & sync)

The offline app works without this, but **login, cloud sync and the 🎬 Video
buttons need internet permission**. Add one line:

1. In the left panel open: `app` → `src` → `main` → **AndroidManifest.xml**.
2. Find the line that starts with `<application`.
3. **Just above** that line, add:
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   ```
   So it looks like:
   ```xml
   <manifest ...>
       <uses-permission android:name="android.permission.INTERNET" />
       <application ...>
   ```
4. Save.

---

## STEP 5 — Run it

**Easiest — run on your own phone:**
1. On your Android phone: Settings → About phone → tap "Build number" 7 times to
   unlock **Developer options**, then turn on **USB debugging**.
2. Plug the phone into the laptop with a USB cable, allow the prompt on the phone.
3. In Android Studio, pick your phone at the top, then press the green **▶ Run**.
   The app installs and opens on your phone. Done! 🎉

**Or run on the built-in emulator:**
- Press **▶ Run** and pick / create a virtual device when asked.

---

## STEP 6 — Make a shareable APK file (optional)

To get an `.apk` you can copy to any phone:

1. Menu: **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**.
2. When it finishes, a small popup appears bottom-right → click **locate**.
3. The file is `app-debug.apk` (in `app/build/outputs/apk/debug/`).
4. Send that file to any Android phone. To install it, the phone will ask to
   allow "install from unknown sources" for your file manager — allow it, then
   tap the apk to install.

This debug APK is perfect for yourself, family and friends. (Putting it on the
**Google Play Store** is a separate step that needs a one-time ~$25 Google
developer account and a "signed release" build — ask me and I'll walk you
through it when you're ready.)

---

## If something goes wrong

- **Blank white screen:** the HTML isn't being found. Check the file is in
  `app/src/main/assets/` and is named exactly `fit-and-fed.html`.
- **Red errors on `AppCompatActivity`:** you picked the wrong template. Make a
  new project with **Empty Views Activity** and try again.
- **Progress doesn't save:** make sure the line `s.domStorageEnabled = true`
  is present in MainActivity (it is, in the file provided).
- **"🎬 Video" buttons do nothing:** they need internet — they open YouTube in
  your browser. Everything else works offline.
- **Login / sync doesn't work:** check two things — (1) you added the
  `INTERNET` permission in Step 4, and (2) you pasted your Firebase config into
  `fit-and-fed.html` and set it up per **FIREBASE-SETUP.md**. With no internet,
  login is simply skipped and the app still runs offline.
- **Gradle sync keeps spinning:** give it time on first run (it downloads
  components), and accept any SDK install prompts.

---

## Want a custom app icon?

After it runs, in Android Studio: right-click `app` → **New** → **Image Asset**
→ choose an image → Finish. Then Run again. (Optional — the app works fine with
the default icon.)
