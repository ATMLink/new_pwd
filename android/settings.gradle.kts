pluginManagement {
  // 1. 读取 Flutter SDK 路径
  val flutterSdkPath = run {
    val props = java.util.Properties()
    file("local.properties").inputStream().use { props.load(it) }
    props.getProperty("flutter.sdk")
      ?: error("flutter.sdk not set in local.properties")
  }

  // 2. 引入 Flutter 自带的 Gradle 插件
  includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

  // 3. 插件仓库（优先国内镜像）
  repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
    maven { url = uri("https://maven.aliyun.com/repository/google") }
    google()
    mavenCentral()
    gradlePluginPortal()
  }

  // 4. 声明 Flutter Plugin Loader
  plugins {
    id("dev.flutter.flutter-plugin-loader") version "1.0.0"
  }
}

include(":app")
