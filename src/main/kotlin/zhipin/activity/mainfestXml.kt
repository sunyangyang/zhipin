package zhipin.activity

fun manifestXml(packageName: String, activityClass: String) = """
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <application>
          <activity android:name="${packageName}.${activityClass}"
                       android:screenOrientation="portrait"
                       android:configChanges="screenLayout|screenSize|smallestScreenSize">
	    </activity>  
    </application>
</manifest>
"""