plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "com.taylorz.apriltag"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
        ndk {
            //noinspection ChromeOsAbiSupport
            abiFilters += listOf("arm64-v8a") // 选择需要的架构
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
//            isShrinkResources = false // 关闭资源优化
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    externalNativeBuild {
        cmake {
            path = file("CMakeLists.txt")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}

afterEvaluate {
    android.libraryVariants.forEach { variant ->
        publishing.publications.create<MavenPublication>(variant.name) {
            from(components.findByName(variant.name))
            groupId = "com.taylorz"
            artifactId = "apriltag"
            version = "3.4.3"
        }
    }
}