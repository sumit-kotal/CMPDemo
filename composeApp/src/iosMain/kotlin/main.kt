import androidx.compose.ui.window.ComposeUIViewController
import org.demo.multiplatform.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
