# ZenApp Android build starter

This is an Android Studio/Gradle project with a GitHub Actions workflow that can compile a debug APK. It is **not yet a working messaging app APK**: the APK currently shows a setup screen because the ZenApp server has not been deployed to an HTTPS address.

## Build APK without owning a computer
1. On your Android phone, sign in to GitHub in Chrome and create a new repository.
2. Upload the contents of this project to the repository (keep the `.github/workflows/build-apk.yml` path).
3. Open the repository's **Actions** tab and run **Build ZenApp Android APK** (or push to `main`).
4. Open the successful workflow run and download the `ZenApp-debug-apk` artifact. GitHub may require you to sign in.
5. Extract the downloaded artifact ZIP and tap `app-debug.apk`. Android may ask you to allow Chrome or Files to install unknown apps.

## Important
For actual registration, messaging, and other users to work, deploy the existing ZenApp Node.js server to a secure HTTPS host, then put that HTTPS URL in `ZENAPP_SERVER_URL` in `MainActivity.java` and rebuild. Do not use the app for sensitive conversations: the existing encryption prototype has not had independent security review. This workflow creates a debug APK, not a Play Store release.
