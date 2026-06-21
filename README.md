# Fit & Fed 💪🍽️

A motivating, **offline-first** fitness & wellbeing app for everyday people —
workouts, wellness tracking, and budget-friendly meal planning, all in one place.
Built as a single self-contained web app that also wraps into an Android/iOS app.

> Made to help people stay consistent with movement, rest, and eating well —
> with real Nigerian foods and Naira budgeting baked in.

---

## ✨ Features

- **Workouts** — 9 guided routines + a 27-move exercise library with **animated
  demos**, timers, rest periods, and audio/vibration cues.
- **Wellness** — mood tracker with insights, hydration, sleep log + bedtime
  reminder, a skin-care helper, and office stretch breaks.
- **Eat** — a **₦ budget feeding planner** with affordable Nigerian shopping
  lists & meal ideas, a calorie counter (Nigerian foods), and a fasting timer.
- **Steps** — motion-sensor step counting plus manual logging.
- **Gamification** — XP, levels, coins, badges, daily challenges, and unlockable
  colour themes.
- **Optional login & cloud sync** — sign in (via Firebase) to sync progress
  across devices. **Works fully offline** without an account.
- **Private by default** — data stays on the device unless the user logs in.

## 🚀 Use it

- **Live web version:** (https://chimmysmallz.github.io/fit-and-fed/)
- **On your phone:** open the app in Chrome → menu → **Add to Home screen**.
  It gets an icon and works offline.

## 📱 Build as a native app

- **Android:** see [`HOW-TO-BUILD.md`](HOW-TO-BUILD.md)
- **Login & cloud sync:** see [`FIREBASE-SETUP.md`](FIREBASE-SETUP.md)
- **Publish to Play Store:** see [`PLAYSTORE-RELEASE-GUIDE.md`](PLAYSTORE-RELEASE-GUIDE.md)
- **Full roadmap:** see [`START-HERE-CHECKLIST.md`](START-HERE-CHECKLIST.md)

## 🛠️ Tech

Single-file **HTML + CSS + JavaScript** — no build step, no dependencies.
Login/sync is optional and uses the Firebase JavaScript SDK (loaded only when
online). Everything else runs offline from the device.

## ⚠️ Notes

- Food prices and calorie values are **estimates** for Nigerian/Lagos servings
  and are clearly labelled as guides in the app.
- This app is for general wellbeing and is **not medical advice**.

## 📄 License

Suggested: the **MIT License** (simple and permissive). Add a `LICENSE` file —
GitHub can create one for you: *Add file → Create new file → name it `LICENSE` →
"Choose a license template" → MIT.*
