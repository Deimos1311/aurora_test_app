object Versions {
    const val buildTools = "7.0.3"
    const val kotlinPlugin = "1.5.31"
    const val gradlePlugin = "2.3.5"

    const val ktx = "1.7.0"
    const val appCompat = "1.3.1"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.1"
    const val junit = "4.13.2"
    const val testJunit = "1.1.3"
    const val testEspresso = "3.4.0"
    const val javaxInject = "1"

    //Navigation
    const val navigation = "2.3.5"

    //RxJava
    const val rxJava = "3.0.13"

    //Interceptor
    const val interceptor = "4.9.2"

    //Retrofit
    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"

    //Retrofit Adapter
    const val retrofitAdapter = "3.0.0"

    //Room
    const val room = "2.3.0"
    const val roomRxjava = "2.3.0"

    //RxJava Android
    const val rxJavaAndroid = "3.0.0"

    //Dagger
    const val dagger = "2.36"

    //Lifecycle
    const val lifecycle_version = "2.4.0"
    const val lifecycle_ext_version = "2.2.0"
}

object Deps {
    const val build_tools = "com.android.tools.build:gradle:${Versions.buildTools}"
    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinPlugin}"
    const val gradle_plugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.gradlePlugin}"

    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val app_compat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val test_junit = "androidx.test.ext:junit:${Versions.testJunit}"
    const val test_espresso = "androidx.test.espresso:espresso-core:${Versions.testEspresso}"
    const val javax_inject = "javax.inject:javax.inject:${Versions.javaxInject}"

    //Navigation
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_UI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //RxJava
    const val rxjava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"

    //Interceptor
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"

    //Retrofit Adapter
    const val retrofit_adapter = "com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.retrofitAdapter}"

    //Room
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_rxjava = "androidx.room:room-rxjava3:${Versions.roomRxjava}"

    //RxJava Android
    const val rxjava_android = "io.reactivex.rxjava3:rxandroid:${Versions.rxJavaAndroid}"

    //Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    //Lifecycle
    const val lifecycle_ext = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_ext_version}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
    const val lifecycle_viewmodel =  "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
}

object ConfigVersions {
    const val compileSdk = 31
    const val applicationId = "evgen.kolesnik.auroratestapp"
    const val minSdk = 21
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0"
}