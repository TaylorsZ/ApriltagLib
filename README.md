# ApriltagLib

ApriltagLib 是一个 Android 库，它通过 JNI 集成了 AprilTag3，提供高效的 AprilTag 目标检测功能。本项目支持通过 JitPack 发布，方便开发者集成到 Android 项目中。

## 特性
- 基于 AprilTag3 进行高效的目标检测。
- 使用 JNI 和 CMake 编译 native 代码，提高计算性能。
- 提供简洁的 Kotlin API，便于 Android 开发者调用。
- 通过 JitPack 托管，方便快速集成。

## 依赖环境
- Android Studio
- Gradle 7+
- NDK
- CMake

## 安装

### 1. 在 `settings.gradle.kts` 中添加 JitPack 仓库：
```kotlin
dependencyResolutionManagement {
    repositories {
        maven("https://jitpack.io")
    }
}
```

### 2. 在 `build.gradle.kts`（Module 级别）中添加依赖：
```kotlin
dependencies {
    implementation("com.github.TaylorsZ:ApriltagLib:3.4.3")
}
```

## 使用方法

### 1. 加载 Native 库
```kotlin
ApriltagNative.apriltagInit("tag36h11", 1, 1.0f, 0.0f, 4, 1, 0.25)
```

### 2. 进行 AprilTag 目标检测
```kotlin
val detections = ApriltagNative.apriltagDetectYuv(yuvData, "rear_camera", 0, 1, width, height)
```

## 本地构建与发布

### 1. 编译 JNI 代码
```sh
./gradlew assembleRelease
```

### 2. 发布到本地 Maven 仓库
```sh
./gradlew publishReleasePublicationToMavenLocal
```

### 3. 发布到 JitPack
确保你的 GitHub 仓库是公开的，并在 JitPack 上构建成功。

[JitPack 下载 ApriltagLib](https://jitpack.io/#TaylorsZ/ApriltagLib)

## 贡献
欢迎提交 issue 和 PR 来改进此项目！

## 许可证
本项目基于 MIT 许可证，详情请查看 LICENSE 文件。

