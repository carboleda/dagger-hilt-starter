# dagger-hilt-starter
Example about how to setup and implement Dagger Hilt in order to understand the basic concepts

![alt text](images/1613338594810.png "Screenshot")

## Setup
1. ### build.gradle
    You can check up the last plugin version on [Maven](https://mvnrepository.com/artifact/com.google.dagger/hilt-android)
    ```kotlin
    buildscript {
        ...
        ext.hilt_version = "2.31.2-alpha"
        ...
        repositories {
            // other repositories...
            mavenCentral()
        }
        dependencies {
            // other plugins...
            classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
        }
    }
    ```

1. ### app/build.gradle
    ```kotlin
    plugins {
        ...
        id "org.jetbrains.kotlin.kapt"
        id "dagger.hilt.android.plugin"
    }

    ...

    dependencies {
        ...
        implementation "com.google.dagger:hilt-android:$hilt_version"
        kapt "com.google.dagger:hilt-android-compiler:$hilt_version"

        // For instrumentation tests
        androidTestImplementation  "com.google.dagger:hilt-android-testing:$hilt_version"
        kaptAndroidTest "com.google.dagger:hilt-android-compiler:$hilt_version"

        // For local unit tests
        testImplementation "com.google.dagger:hilt-android-testing:$hilt_version"
        kaptTest "com.google.dagger:hilt-android-compiler:$hilt_version"

        // Activity KTX for viewModels()
        implementation "androidx.activity:activity-ktx:1.2.0"
        ...
    }

    kapt {
        correctErrorTypes true
    }
    ```

## Implementation

1. ### Application class
    ```kotlin
    @HiltAndroidApp
    class MyApplication : Application()
    ```