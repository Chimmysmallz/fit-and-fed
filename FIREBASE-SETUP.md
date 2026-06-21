# Turn on login & cloud sync (Firebase)

This switches on accounts so people can **log in and sync their progress across
phones**. It's free for normal use. Takes about 10 minutes. You only do this once.

The app already has all the login code built in — you just need to create a
free Firebase project and paste 4 values into the app file.

---

## STEP 1 — Create a Firebase project
1. Go to **https://console.firebase.google.com** and sign in with a Google account.
2. Click **Add project** → give it a name (e.g. `Fit and Fed`) → **Continue**.
3. Google Analytics is optional — you can turn it **off** → **Create project**.
4. Wait for it to finish, then **Continue**.

## STEP 2 — Add a "Web app" and copy the config
1. On the project home, click the **`</>`** (Web) icon.
2. Give it a nickname (e.g. `Fit and Fed Web`) → **Register app**.
   (Leave "Firebase Hosting" unchecked.)
3. Firebase shows a `firebaseConfig` block. **Copy the values** — you need:
   `apiKey`, `authDomain`, `projectId`, `appId`.

> ❓ **"Web app — does that limit me to web?" No.** Your app is HTML/JavaScript
> running inside a WebView, so it uses Firebase's **JavaScript SDK** on *every*
> platform. This one Web config works in the Android app, an iOS app, the browser,
> and a PWA. The "Android"/"iOS" registration types are only for *fully native*
> (Kotlin/Swift) apps — not what you're building.
>
> Also: **accounts and the database belong to the project, not the app.** One set
> of users and one database is shared across all platforms, so a person can sign
> up on Android and log in on iOS to the same data. You can add native Android/iOS
> apps to this same project later without losing anything.

## STEP 3 — Paste the config into the app
1. Open **`fit-and-fed.html`** in any text editor (or in Android Studio).
2. Near the top, find the block that says `window.FIREBASE_CONFIG = {`.
3. Replace each `"PASTE_HERE"` with the matching value from Firebase. Example:
   ```js
   window.FIREBASE_CONFIG = {
     apiKey: "AIzaSyA....",
     authDomain: "fit-and-fed.firebaseapp.com",
     projectId: "fit-and-fed",
     appId: "1:1234567890:web:abc123..."
   };
   ```
4. Save the file. (If it's already in your Android Studio `assets` folder, just
   edit it there.)

> 🔒 Don't worry that these values are inside the app — Firebase config values
> are **not secret**. Your data is protected by the security rules in Step 6.

## STEP 4 — Turn on Email/Password login
1. In Firebase, left menu → **Build → Authentication** → **Get started**.
2. Open the **Sign-in method** tab.
3. Click **Email/Password** → toggle **Enable** → **Save**.

## STEP 5 — Create the database
1. Left menu → **Build → Firestore Database** → **Create database**.
2. Pick a location (choose the region closest to your users) → **Next**.
3. Choose **Start in production mode** → **Create**.

## STEP 6 — Lock the database to each user (important!)
1. In Firestore, open the **Rules** tab.
2. Replace everything with this and click **Publish**:
   ```
   rules_version = '2';
   service cloud.firestore {
     match /databases/{database}/documents {
       match /users/{uid} {
         allow read, write: if request.auth != null && request.auth.uid == uid;
       }
     }
   }
   ```
   This makes sure each person can only read/write **their own** data.

## STEP 7 — Test it
1. Rebuild/reopen the app. Go to the **Me** tab → you'll see a login box.
2. Tap **Create account**, enter an email + password.
3. Log a workout, then sign in on another device with the same account —
   your progress appears. ☁️ Done!

---

## Good to know
- **Email/password login** is used because it works reliably inside the Android
  app. (One-tap "Sign in with Google" needs extra native setup — ask me later if
  you want it; it's a bigger job.)
- **Offline still works.** With no internet, the app runs normally on the phone
  and syncs the next time the person is online and signed in.
- **Cost:** Firebase's free tier covers a lot of users. You'd only pay if the app
  gets very popular — and Firebase warns you long before that.
- **Forgot password** is built in — it emails a reset link.
