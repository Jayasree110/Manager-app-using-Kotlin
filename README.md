
# 📝 Task Manager App

A simple and modern Android app for managing tasks, built with **Jetpack Compose**, **Kotlin Flows**, and **Clean Architecture**. This project demonstrates best practices in state management, dependency injection with **Hilt**, and unit testing using **JUnit**, **MockK**, and **kotlinx-coroutines-test**.

---

## 🔧 Tech Stack

- **Kotlin**, **Coroutines**, **Flow**
- **Jetpack Compose** (UI)
- **MVVM** + **Clean Architecture**
- **Hilt** for Dependency Injection
- **StateIn** for reactive state management
- **Unit Testing** with:
  - JUnit 4
  - MockK
  - kotlinx-coroutines-test
  - androidx.arch.core:core-testing

---

## ✅ Features

- 📝 View all tasks
- ➕ Add new tasks
- ✅ Toggle task completion
- ❌ Delete tasks
- 🗃 In-memory data (easily swappable with Room or DataStore)
---

## 📸 Screenshot

![ss](https://github.com/user-attachments/assets/745a314a-51ad-449c-bc96-572efdd3f750)


---

## 📂 Project Structure

```
app/
├── data/           # In-memory repository
├── domain/         # Model + UseCases + Repository interface
├── di/             # Hilt modules
├── presentation/   # ViewModel + Compose UI
```

---

## 🛠️ Future Improvements

- Add persistent storage (Room or DataStore)
- Implement filtering or sorting
- Add UI tests with Jetpack Compose Test
- Polish the UI
