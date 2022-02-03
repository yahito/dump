package com.yahito.kibanaplugin.config

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import java.util.stream.Collectors

@State(name = "KibanaPluginProjectSettings", storages = [Storage("kibana-plugin.json")])
class KibanaPluginProjectSettings : PersistentStateComponent<Settings> {

    private var settings: Settings = Settings()

    companion object {
        fun getInstance(): KibanaPluginProjectSettings {
            return ServiceManager.getService(KibanaPluginProjectSettings::class.java)
        }
    }

    override fun loadState(settings: Settings) {
        this.settings = settings
    }

    override fun getState(): Settings {
        return settings;
    }

    fun list(): MutableList<String?>? {
        return settings.envs.stream().map { p -> p.name }.collect(Collectors.toList())
    }
}