# Compose Multiplatform Demo App

This is a Compose Multiplatform app demonstrating a product catalog with login and profile functionality. It uses a mock API served locally via [Mountebank](https://www.mbtest.org/) and is built following modern Android and multiplatform practices.

---

##  Tech Stack

- **Compose Multiplatform** – Shared UI for Android and IOS
- **Voyager** – Navigation
- **Ktor Client** – Networking
- **Koin** – Dependency Injection
- **Coil v3** – Image loading
- **Mountebank** – Local mock API

---

##  Project Features

- Login screen with validation
- Home screen with product listing
- Profile screen with user data
- Bottom navigation
- Offline-ready with mock API
- Smooth image loading with placeholder and error handling

---

##  Requirements

- **Java 17+**
- **Android Studio Bumblebee or newer**
- **Node.js v16** (via `nvm`)
- **npm v8.4.1**
- **Mountebank** (installed globally)

---

##  Setup Guide

### 1. Install Node.js and Mountebank

Open terminal and run:

```bash
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.1/install.sh | bash
source ~/.nvm/nvm.sh
nvm install 16
nvm use 16
npm install -g npm@8.4.1
npm install -g mountebank
npm audit fix
```

---

### 2. Start Mountebank Server

From the project root:

```bash
mb --configfile imposters.ejs --ip 0.0.0.0
```

- Admin UI: `http://localhost:2525`
- Mock API: `http://localhost:2727`

---

### 3. Configure API Base URL in App

#### a. Emulator

```kotlin
 val BASE_URL = "http://10.0.2.2:2727"
```

#### b. Physical Device

1. Ensure laptop and device are on the same Wi-Fi.
2. Find your laptop’s IP (e.g., `192.168.0.102`).
3. Update base URL:

```kotlin
 val BASE_URL = "http://192.168.0.102:2727"
```

> Make sure firewall allows incoming traffic on port `2727`.

---

### 4. Build & Run the App

1. Open the project in Android Studio.
2. Select your target (emulator or device).
3. Run the app. It should fetch data from the Mountebank server.

---

##  Project Structure

- `presentation/` – UI screens (Home, Profile, Login)
- `domain/` – Data models
- `data/` – Ktor client setup
- `di/` – Koin modules
- `imposters.ejs` – Mountebank configuration

---

##  Troubleshooting

| Issue                       | Fix                                                                  |
|-----------------------------|----------------------------------------------------------------------|
| Cannot connect to API       | Ensure correct base URL and Mountebank is running                    |
| Physical device not working | Verify IP, firewall, and network are properly set                    |
| Images not loading          | Ensure URLs are public and Coil is configured with placeholder/error |

---

##  Support

**Sumit Kotal**  
📧 kotalsumit@gmail.com  
📱 +91 9930884866
