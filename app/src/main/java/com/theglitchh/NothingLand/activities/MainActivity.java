<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://android.com"
    xmlns:tools="http://android.com"
    package="com.theglitchh.NothingLand">

    <!-- Existing Core Permissions -->
    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
    <uses-permission android:name="android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS" />
    <uses-permission android:name="android.permission.RECORD_AUDIO" />
    <uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS" />
    <uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
    <uses-permission
        android:name="android.permission.READ_EXTERNAL_STORAGE"
        android:maxSdkVersion="32" />
    <uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
    <uses-permission
        android:name="android.permission.BLUETOOTH"
        android:maxSdkVersion="30" />
    <uses-permission
        android:name="android.permission.WRITE_SETTINGS"
        tools:ignore="ProtectedPermissions" />

    <!-- 🚀 Launcher-Specific & iOS System Overrides -->
    <uses-permission android:name="android.permission.QUERY_ALL_PACKAGES"
        tools:ignore="QueryAllPackagesPermission" /> 
    <uses-permission android:name="android.permission.EXPAND_STATUS_BAR" />
    <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />

    <application
        android:name=".App"
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:hardwareAccelerated="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.TheGlitchh"
        tools:targetApi="35">

        <service
            android:name=".services.UpdaterService"
            android:exported="false" />

        <!-- 📱 MAIN DASHBOARD: For settings, tweaking colors, enabling modules -->
        <activity
            android:name=".activities.MainActivity"
            android:exported="true"
            android:hardwareAccelerated="true">
            <intent-filter>
                <category android:name="android.intent.category.LAUNCHER" />
                <action android:name="android.intent.action.MAIN" />
            </intent-filter>
        </activity>

        <!-- 🚀 THE NEW iOS HOME SCREEN: Declared as Default Launcher -->
        <activity
            android:name=".activities.IosLauncherActivity"
            android:clearTaskOnLaunch="true"
            android:exported="true"
            android:hardwareAccelerated="true"
            android:launchMode="singleInstance"
            android:resumeWhilePausing="true"
            android:stateNotNeeded="true"
            android:windowSoftInputMode="adjustPan">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.HOME" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>

        <!-- 🔒 THE NEW iOS LOCK SCREEN: Sits securely over the UI -->
        <activity
            android:name=".activities.IosLockScreenActivity"
            android:exported="false"
            android:hardwareAccelerated="true"
            android:launchMode="singleTop"
            android:showWhenLocked="true"
            android:turnScreenOn="true" />

        <!-- Existing UI Control Configuration Panels -->
        <activity
            android:name=".activities.PermissionActivity"
            android:exported="false"
            android:hardwareAccelerated="false" />
        <activity
            android:name=".activities.OverlayLayoutSettingActivity"
            android:exported="false"
            android:hardwareAccelerated="false" />
        <activity
            android:name=".activities.AppearanceActivity"
            android:exported="false"
            android:hardwareAccelerated="false" />
        <activity
            android:name=".activities.GestureSettingsActivity"
            android:exported="false" />
        <activity
            android:name=".activities.NotificationManageActivity"
            android:exported="false" />

        <receiver
            android:name=".utils.DemoNotifications$DemoReceiver"
            android:exported="false" />

        <!-- Notification Listener Service -->
        <service
            android:name=".services.NotiService"
            android:enabled="true"
            android:exported="true"
            android:permission="android.permission.BIND_NOTIFICATION_LISTENER_SERVICE">
            <intent-filter>
                <action android:name="android.service.notification.NotificationListenerService" />
            </intent-filter>
        </service>

        <!-- Dynamic Control Center Drawers & Status Bar Engine -->
        <service
            android:name=".services.ControlCenterService"
            android:enabled="true"
            android:exported="false" />

        <!-- 🛠️ CRASH FIX: Removed android:process=":remote" so it handles overlays smoothly -->
        <service
            android:name=".services.OverlayService"
            android:enabled="true"
            android:exported="true"
            android:permission="android.permission.BIND_ACCESSIBILITY_SERVICE">
            <intent-filter>
                <action android:name="android.accessibilityservice.AccessibilityService" />
            </intent-filter>
            <meta-data
                android:name="android.accessibilityservice"
                android:resource="@xml/global_action_bar_service" />
        </service>

    </application>
</manifest>
