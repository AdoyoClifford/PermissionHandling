package com.adoyo.ultimatepermissionhandling

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val visiblePermissionDialogQueue = mutableStateListOf<String>()

    fun dismissDialog() {
        visiblePermissionDialogQueue.removeFirst()
    }

    fun onPermissionResult(permission: String, isGranted: Boolean) {
        if (!isGranted && visiblePermissionDialogQueue.contains(permission)) {
            visiblePermissionDialogQueue.add(permission)

        }
    }
}