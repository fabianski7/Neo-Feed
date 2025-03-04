package com.saulhdev.feeder

import com.jakewharton.threetenabp.AndroidThreeTen
import com.saulhdev.feeder.plugin.PluginFetcher
import com.saulhdev.feeder.utils.OverlayBridge
import ua.itaysonlab.hfsdk.HFPluginApplication

class NFApplication : HFPluginApplication() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        instance = this
        PluginFetcher.init(instance)
    }

    companion object {

        lateinit var instance: NFApplication
        val bridge = OverlayBridge()
    }
}