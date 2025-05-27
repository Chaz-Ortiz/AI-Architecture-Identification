@file:OptIn(ExperimentalMaterial3Api::class)

package edu.utsa.cs3343.chazai

// Be careful with this next line
//import edu.utsa.cs3343.chazai.data.TfLiteLandmarkClassifier
// the part after cs3343 NEEDS TO MATCH THE PROJECT NAME!

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import edu.utsa.cs3343.chazai.data.TfLiteLandmarkClassifier
import edu.utsa.cs3343.chazai.domain.Classification
import edu.utsa.cs3343.chazai.presentation.CameraPreview
import edu.utsa.cs3343.chazai.presentation.LandmarkImageAnalyzer
import edu.utsa.cs3343.chazai.ui.theme.CameraXGuideTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // check if we don't have the required permissions
        if (!hasCameraPermission()) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.CAMERA), 0  // this, arrayOf(Manifest.permission.Camera),
            )
        }

        setContent {
            CameraXGuideTheme {
                    var classifications by remember {
                        mutableStateOf(emptyList<Classification>())
                    }
                    val analyzer = remember {
                        LandmarkImageAnalyzer(
                            classifier = TfLiteLandmarkClassifier(
                                context = applicationContext
                            ),
                            onResults = {
                                classifications = it
                            }
                        )
                    }
                    val controller = remember {
                        LifecycleCameraController(applicationContext).apply {
                            setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
                            setImageAnalysisAnalyzer(
                                ContextCompat.getMainExecutor(applicationContext),
                                analyzer
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        CameraPreview(
                            controller, Modifier.fillMaxSize())

                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.TopCenter)
                            ) {
                                classifications.forEach {
                                    Text(
                                        text = it.name,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(MaterialTheme.colorScheme.primaryContainer)
                                            .padding(8.dp),
                                        textAlign = TextAlign.Center,
                                        fontSize = 20.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        }
                    }
                }
            }
            private fun hasCameraPermission() = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
}