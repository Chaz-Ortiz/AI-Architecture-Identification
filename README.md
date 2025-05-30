# North American Landmark Identifier (Android App)

[🏛️ **See it in action below!**](#-screenshots)
![ChazAIWaltDisney](https://github.com/user-attachments/assets/af2a2689-5ed6-432b-b585-63618ad23391)
![ChazAIAlamo](https://github.com/user-attachments/assets/fcb5b557-3419-44da-85c2-62fcf684e252)


This Android application uses [TensorFlow Lite](https://www.tensorflow.org/lite) to identify **specific buildings and landmarks** in North America from live video. It leverages a custom-trained `.tflite` model to perform on-device image classification, enabling **fast**, **private**, and **offline** landmark recognition directly on the user's device.

---

## 🤖 AI & Machine Learning

This app showcases the power of **mobile machine learning** using **TensorFlow Lite**. The model was trained on a curated dataset of well-known North American landmarks and optimized for deployment on Android.

By running inference entirely on the device:
- No internet is needed — protecting user privacy
- Latency is reduced for **real-time predictions**
- Battery usage and computational cost are minimized due to model quantization and mobile optimizations

TensorFlow Lite provides an ideal framework for such applications, enabling developers to bring advanced AI capabilities to smartphones, IoT devices, and embedded systems.

---

## ✨ Features

- 📸 Identifies landmarks and buildings across North America
- ⚡ Uses TensorFlow Lite for on-device machine learning
- 🕵️‍♂️ Works in real time using live video frames
- 📴 Fully offline — no data connection required
- 📱 Optimized for mobile performance and size

---

## ⚙️ How It Works

1. The app captures frames from the camera in real time
2. Each frame is analyzed by the custom TensorFlow Lite model (`namerica.tflite`)
3. The model returns the most probable landmark along with a confidence score
4. The results are displayed in the app interface

---

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio)
- Android device or emulator (API level 21+)
- `namerica.tflite` model file placed in the `assets` directory

### Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/Chaz-Ortiz/AI-Architecture-Identification
   cd landmark-identifier
