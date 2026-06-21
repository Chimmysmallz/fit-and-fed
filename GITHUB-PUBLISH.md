# Put "Fit & Fed" on GitHub (and get a free live link)

Two things you can do — do both:
- **A) Host the code on GitHub** (visible, backed up, shareable)
- **B) Turn on GitHub Pages** → a free public web link people can open & install

You do **not** need Git or any commands — this uses the GitHub website only.

---

## A) Put your code on GitHub

### 1. Create a free account
Go to **https://github.com** and sign up (free) if you don't have an account.

### 2. Create a repository
1. Click the **+** (top-right) → **New repository**.
2. **Repository name:** `fit-and-fed`
3. **Description:** e.g. "Offline-first fitness & wellbeing app"
4. Choose **Public** or **Private**:
   - **Public** — anyone can see the code; needed for the free live link in part B.
   - **Private** — only you can see it (you can still build the app, but the free
     live link in part B won't be available).
   - 🔒 *Public is fine for this app:* your Firebase config keys are **not secret**
     (your Firestore security rules are what protect data). See FIREBASE-SETUP.md.
5. Leave the rest as-is → **Create repository**.

### 3. Upload your files (drag & drop)
1. On the new repo page, click **uploading an existing file** (or **Add file →
   Upload files**).
2. Drag in the files from this folder — at minimum `fit-and-fed.html` and
   `README.md`. You can include the guides too (they'll show nicely on GitHub).
3. Scroll down → **Commit changes**.

That's it — your app is now on GitHub. The `README.md` becomes your repo's front
page automatically. 🎉

---

## B) Get a free live link (GitHub Pages)

This publishes a public web address anyone can open in a browser and install on
their phone.

### 1. (Recommended) Make the app the homepage
For a clean link, rename your web copy so it opens at the root URL:
1. In the repo, click **`fit-and-fed.html`** → the **pencil (Edit)** icon →
   change the filename at the top to **`index.html`** → **Commit changes**.
2. *(This only affects the GitHub copy. Your Android app keeps its own
   `fit-and-fed.html` in its `assets` folder — leave that one as-is.)*

### 2. Turn on Pages
1. In the repo, go to **Settings** → **Pages** (left menu).
2. Under **Source**, choose **Deploy from a branch**.
3. **Branch:** `main`, folder **`/ (root)`** → **Save**.
4. Wait ~1 minute. The page will show your live URL, like:
   **`https://YOUR-USERNAME.github.io/fit-and-fed/`**

### 3. Use it
- Open that link on any phone → menu → **Add to Home screen** to install it.
- Paste the link into your `README.md` where it says "add your link here".

---

## If you're using login (Firebase)

- A live **HTTPS** link (GitHub Pages) actually works **better** with Firebase
  than opening a local file. Email/password login needs nothing extra.
- If you later add **"Sign in with Google"**, you must allow your Pages domain:
  Firebase → **Authentication → Settings → Authorized domains → Add domain** →
  enter `YOUR-USERNAME.github.io`.

## Bonus: host your privacy policy here too

GitHub Pages can also host the privacy policy you'll need for the Play Store.
Add a `privacy.html` (or upload `PRIVACY-POLICY.md`) to the same repo, and its
link becomes your public privacy-policy URL — one less thing to set up elsewhere.

## Updating later

To change anything: open the file on GitHub → pencil **Edit** → make changes →
**Commit**. The live site updates automatically within a minute.
*(Prefer a desktop workflow? Install **GitHub Desktop** and drag the folder in —
optional, not required.)*
