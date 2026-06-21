# Publishing "Fit & Fed" to the Google Play Store

This is the full path from "app on my phone" to "app anyone can download". Plan
for a few hours of setup spread over a couple of weeks (there's a required
testing period — see Step 6).

---

## STEP 1 — Create a Google Play developer account
1. Go to **https://play.google.com/console** and sign in with the Google account
   you want to publish under.
2. Pay the **one-time $25** registration fee.
3. Complete **identity verification** (Google now requires this — you'll provide
   your name, address, and sometimes a photo ID). Approval can take 1–3 days.

## STEP 2 — Host your privacy policy at a public link
Google requires a **public URL** to your privacy policy.
- Fill in the `PRIVACY-POLICY.md` template (replace every [BRACKET]).
- Put it on any free public page and copy its link, e.g.:
  - **Google Sites** (sites.google.com) — paste the text, publish, copy the URL; or
  - **GitHub Pages**, or any simple website you control.
- Keep that URL handy — you'll paste it into Play Console.

## STEP 3 — Build a signed release file (AAB)
The Play Store needs a signed **Android App Bundle (.aab)**, not the debug APK.

In Android Studio (the laptop where you built the app):
1. Menu → **Build → Generate Signed Bundle / APK**.
2. Choose **Android App Bundle** → **Next**.
3. Under "Key store path", click **Create new…** and fill it in:
   - Choose a file location and password for the **keystore**.
   - Add a **key alias** and key password.
   - Fill the certificate name fields (your name is fine).
   - ⚠️ **BACK UP THIS KEYSTORE FILE AND PASSWORDS FOREVER.** If you lose them,
     you can never update your app again. Save copies in 2 safe places.
4. Click **Next** → select **release** → **Finish**.
5. Your file appears at: `app/release/app-release.aab`.

> Tip: leave **Play App Signing** enabled in the Console (default) — Google
> securely manages the final signing key; you just keep your upload keystore.

## STEP 4 — Create the app in Play Console
1. In Play Console → **Create app**.
2. Set the name (**Fit & Fed**), default language, app type **App**, and
   **Free**. Accept the declarations → **Create**.

## STEP 5 — Fill in the required sections
Play Console gives you a checklist ("Set up your app"). You'll complete:
- **Store listing:**
  - Short description (max 80 chars) and full description (max 4000).
  - **App icon:** 512×512 PNG.
  - **Feature graphic:** 1024×500 PNG.
  - **Screenshots:** at least 2 phone screenshots (just screenshot the app on
    your phone). I can help you write the descriptions and make the graphics.
- **Privacy policy:** paste the public URL from Step 2.
- **Data safety form:** declare what you collect. For this app, tick:
  - *Email address* (account management),
  - *Health & fitness* info, and *App activity*;
  - data is **encrypted in transit**, and users **can request deletion**.
- **Content rating:** answer the questionnaire (it's a wellness app, no mature
  content) → you'll get a rating.
- **Target audience:** choose your age group (match your privacy policy).
- **Ads:** declare **No ads**.
- **App category:** Health & Fitness.

## STEP 6 — The testing requirement (important, plan ahead)
If your developer account is **new/personal**, Google requires a **closed test
with at least 12 testers who stay opted in for 14 days** before you can publish
to full production.
1. Create a **Closed testing** release: upload your `app-release.aab`.
2. Add testers by email (friends, family, colleagues) or a Google Group.
3. Send them the opt-in link; have them install and keep it for 14 days.
4. After the 14 days and Google's review, you unlock **Production** access.

(Established company accounts may not face this — but assume you will, and line
up your 12 testers early.)

## STEP 7 — Go to Production
1. Create a **Production** release → upload the AAB (or promote the tested one).
2. Add release notes → review the summary → **Roll out to production**.
3. Google reviews it (usually a few hours to a few days). Once approved, your app
   is **live on the Play Store** for anyone to download. 🎉

---

## A note on WebView apps & approval
Your app wraps a web page, which Google allows **when it delivers real value**
(yours does — full offline features, tracking, login). To stay safely within
policy, keep the experience rich and self-contained (which it is) rather than a
thin shell pointing at a public website. If a review ever flags it, tell me and
I'll help you respond.

## Keeping it updated
To release an update later: rebuild a new signed AAB (Step 3, **same keystore**),
bump the **version code** in Android Studio (`build.gradle` → `versionCode` +1),
upload it as a new release, and roll out.
