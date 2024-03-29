plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.bigfish1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bigfish1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-runtime:2.7.6")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.drawerlayout:drawerlayout:1.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
    implementation ("com.google.android.material:material:1.2.0")


    implementation ("com.squareup.retrofit2:retrofit:2.5.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.1.0")
    implementation ("com.squareup.okhttp:okhttp:2.0.0")
    implementation ("com.google.code.gson:gson:2.8.6")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.squareup.picasso:picasso:2.5.2")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.5") // Use the latest version
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5") // Use the latest version


    //noinspection GradleCompatible

}