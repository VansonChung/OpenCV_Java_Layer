# OpenCV
Simple java layer porting

1. Download the opencv library (https://sourceforge.net/projects/opencvlibrary/files/)
```py
ex : opencv-4.4.0-android-sdk.zip
```
2. Android studio File -> New -> Import Module -> Select path to opencv-4.4.0-android-sdk/OpenCV-android-sdk/sdk/java -> Module name : xxxxx
3. Modify xxxxx build.gradle
```py
apply plugin: 'com.android.library'
delete defaultConfig { xxxxxxxxxxxxxxxxxxx }
```
4. Modify app build.gradle
```py
implementation project(':xxxxx')
```
5. Android studio File -> New -> Folder -> JNI Folder -> Change Folder Loaction to src/main/jniLibs/  
   app build.gradle will add
```py
sourceSets {
    main {
        jni {
            srcDirs 'src/main/jni', 'src/main/jniLibs/'
        }
    }
}
```
6. Copy opencv-4.4.0-android-sdk/OpenCV-android-sdk/sdk/native/libs/ to jniLibs/
```py
ex : arm64-v8a, armeabi-v7a, x86, x86_64
```
7. Android studio File -> Project Structure -> SDK Location -> Select NDK path
8. Test
```py
val openCVLoader = OpenCVNativeLoader()
openCVLoader.init()
```

Fixed java.lang.UnsatisfiedLinkError: dlopen failed: library "libc++_shared.so" not found

Solution 1

Find libc++_shared.so under NDK folder and copy to arm64-v8a, armeabi-v7a, x86, x86_64
```py
ex : ./sources/cxx-stl/llvm-libc++/libs/arm64-v8a/libc++_shared.so  
     ./sources/cxx-stl/llvm-libc++/libs/x86_64/libc++_shared.so  
     ./sources/cxx-stl/llvm-libc++/libs/armeabi-v7a/libc++_shared.so  
     ./sources/cxx-stl/llvm-libc++/libs/x86/libc++_shared.so
```

Solution 2

https://stackoverflow.com/questions/57698796/cannot-detect-opencv-libs-after-update-form-3-4-3-to-4-1-1
https://github.com/jnfran92/NativeTongue


