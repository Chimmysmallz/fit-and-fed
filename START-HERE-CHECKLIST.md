# Fit & Fed — Full Journey Checklist (START HERE)

This is your map from "app file" to "live on the Play Store with logins".
Do the phases in order. Each phase points to its detailed guide in this folder.

Files in this folder:
- `fit-and-fed.html` — the app
- `MainActivity.kt` — the Android wrapper code
- `HOW-TO-BUILD.md` — build the Android app
- `FIREBASE-SETUP.md` — turn on login + sync
- `PRIVACY-POLICY.md` — your privacy policy template
- `PLAYSTORE-RELEASE-GUIDE.md` — publish to the Play Store
- this checklist

---

## ☐ PHASE 1 — Turn on login (do this first, while editing the HTML)
→ Guide: **FIREBASE-SETUP.md**
- [ ] Create a free Firebase project
- [ ] Add a Web app, copy the config
- [ ] Paste the 4 config values into `fit-and-fed.html`
- [ ] Enable Email/Password sign-in
- [ ] Create the Firestore database + paste the security rules
- [ ] Test: create an account, log a workout, sign in on another device

*Why first: you want login working inside the HTML before you bundle it into the
Android app.*

## ☐ PHASE 2 — Build the Android app
→ Guide: **HOW-TO-BUILD.md**
- [ ] New project in Android Studio (**Empty Views Activity**, Kotlin)
- [ ] Paste in `MainActivity.kt`
- [ ] Put your **updated** `fit-and-fed.html` (with Firebase config) into `assets`
- [ ] Run it on your phone and confirm login works
- [ ] (Optional) add a custom app icon

## ☐ PHASE 3 — Write & publish your privacy policy
→ Guide: **PRIVACY-POLICY.md** + Step 2 of the Play Store guide
- [ ] Fill in every [BRACKET] in the policy
- [ ] Publish it at a public link (free Google Sites works) and save the URL

## ☐ PHASE 4 — Open a Play developer account
→ Guide: **PLAYSTORE-RELEASE-GUIDE.md** Step 1
- [ ] Pay the one-time **$25**
- [ ] Complete identity verification (allow 1–3 days)

## ☐ PHASE 5 — Make the signed release file
→ Guide: **PLAYSTORE-RELEASE-GUIDE.md** Step 3
- [ ] Generate a signed **AAB** in Android Studio
- [ ] 🔒 **Back up your keystore file + passwords in 2 safe places** (critical)

## ☐ PHASE 6 — Create the store listing
→ Guide: **PLAYSTORE-RELEASE-GUIDE.md** Steps 4–5
- [ ] App name, short + full description
- [ ] Icon (512×512), feature graphic (1024×500), 2+ screenshots
- [ ] Privacy policy URL, Data safety form, content rating, category
- [ ] *(I can write the descriptions and help with the graphics — just ask)*

## ☐ PHASE 7 — Closed testing (plan ahead!)
→ Guide: **PLAYSTORE-RELEASE-GUIDE.md** Step 6
- [ ] Line up **12 testers**
- [ ] Upload AAB to a closed test, send the opt-in link
- [ ] Keep them testing for **14 days**

## ☐ PHASE 8 — Go live
→ Guide: **PLAYSTORE-RELEASE-GUIDE.md** Step 7
- [ ] Create a Production release, upload the AAB
- [ ] Roll out → wait for Google's review → **live!** 🎉

## ☐ PHASE 9 — Keep it going
- [ ] For updates: rebuild the AAB with the **same keystore**, bump the version
      number, upload a new release
- [ ] Watch Firebase usage (you'll get free-tier alerts long before any cost)

---

### Rough cost summary
| Item | Cost |
|---|---|
| Google Play developer account | **$25 once** |
| Firebase (login + sync) | **Free** for normal use |
| Privacy policy hosting | **Free** (Google Sites / GitHub Pages) |
| Android Studio | **Free** |

### What I can do for you next
- Write your **store descriptions** and design the **icon + feature graphic**
- Help fill the **Data safety form** answers
- Add **"Sign in with Google"** (needs extra native setup)
- Walk you through any phase live, step by step

Just tell me which one and we'll keep moving. 💪
