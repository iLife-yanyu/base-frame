# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 混淆通用配置
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose

# 混淆时保留所有的注解
-keepattributes *Annotation*

# 混淆时保留实现Parcelable接口的类成员
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# 混淆时保留Serializable的类成员
-keepclassmembers class * implements java.io.Serializable {
  static final long serialVersionUID;
  private static final java.io.ObjectStreamField[] serialPersistentFields;
  private void writeObject(java.io.ObjectOutputStream);
  private void readObject(java.io.ObjectInputStream);
  java.lang.Object writeReplace();
  java.lang.Object readResolve();
}

# 混淆时保留所有的Enum类成员
-keepclassmembers enum * {
  public static **[] values();
  public static ** valueOf(java.lang.String);
}

# 混淆时保留所有View的onClick方法
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# 混淆时保留所有Drawable的构造函数
-keepclassmembers class * extends android.graphics.drawable.Drawable {
  public void setAlpha(int);
}

# 混淆时保留所有自定义View的onSaveInstanceState、onRestoreInstanceState方法
-keepclassmembers class * extends android.view.View {
  void onSaveInstanceState(android.util.SparseArray);
  void onRestoreInstanceState(android.util.SparseArray);
}

# 混淆时保留所有本地方法不被混淆
-keepclasseswithmembernames class * {
  native <methods>;
}

# 混淆时保留所有使用了Android注解的类和类成员
-keep public class * {
  public <init>(org.androidannotations.api.AA);
}
-keep public class * extends android.app.Application {
  public <init>();
}
-keep public class * extends android.app.Service {
  public <init>();
}
-keep public class * extends android.content.BroadcastReceiver {
  public <init>();
}
-keep public class * extends android.content.ContentProvider {
  public <init>();
}
-keep public class * extends android.app.backup.BackupAgentHelper {
  public <init>();
}
-keep public class * extends android.preference.Preference {
  public <init>(android.content.Context);
  public <init>(android.content.Context, android.util.AttributeSet);
}
-keep public class com.android.vending.licensing.ILicensingService

# 混淆时保留所有ComponentName的构造方法
-keepclassmembers class * {
  public void *(android.content.Context, android.util.AttributeSet);
}

# 混淆时保留所有自定义控件类成员
-keepclassmembers class * extends android.widget.TextView {
  void setGravity(int);
}

# 混淆时保留所有Parcelable的子类成员
-keepclassmembers class * implements android.os.Parcelable {
  static android.os.Parcelable$Creator CREATOR;
}

# 混淆时保留所有自定义Enum类成员
-keepclassmembers enum * {
  public static **[] values();
  public static ** valueOf(java.lang.String);
}

-keepclassmembers class com.yanyu.data.room.beans.**

# 混淆时保留所有Json序列化类

-ignorewarnings
-keep class com.huawei.agconnect.**{*;}