# North American Landmark Identifier (Android App)

This Android application uses [TensorFlow Lite](https://www.tensorflow.org/lite) to identify **specific buildings and landmarks** in North America from video images. It leverages a custom-trained `.tflite` model to perform on-device image classification, enabling fast and private landmark recognition directly on the user's device.

## Features

- Identifies named landmarks and buildings across North America
- Uses TensorFlow Lite for fast, on-device machine learning
- Processes video frames in real-time
- Works entirely offline—no internet connection required
- Lightweight and efficient for mobile devices

## How It Works

1. The app captures frames from a live video feed or camera input.
2. Each frame is analyzed by a custom-trained TensorFlow Lite model (`namerica.tflite`).
3. The model returns the most likely name of the recognized landmark or building along with a confidence score.
4. The result is displayed in the app interface.

## Getting Started

### Prerequisites

- Android Studio
- Android device or emulator (API level 21+)
- TensorFlow Lite model file (`namerica.tflite`) placed in the `assets` directory

### Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/Chaz-Ortiz/AI-Architecture-Identification
   cd landmark-identifier
