package zhipin.recycleractivity

import java.io.File

fun activityXml() ="""
<?xml version="1.0" encoding="utf-8"?>
<androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <com.hpbr.bosszhipin.views.AppTitleView
        android:id="@+id/title_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent" />

    <FrameLayout
        android:id="@+id/fl_container"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:background="@color/app_white"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/title_view" />
</androidx.coordinatorlayout.widget.CoordinatorLayout>
"""