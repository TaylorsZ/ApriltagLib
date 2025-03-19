# 保持所有 native 方法的原始签名
-keepclasseswithmembers class * {
    native <methods>;
}

# 保持 JNI 相关类的字段名和方法名
-keep class com.taylorz.apriltag.** { *; }