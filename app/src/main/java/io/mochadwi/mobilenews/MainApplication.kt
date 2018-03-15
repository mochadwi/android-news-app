package io.mochadwi.mobilenews

import android.app.Application
import android.support.multidex.MultiDexApplication
import io.mochadwi.mobilenews.util.RealmMigrations
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by mochadwi on 3/15/18.
 */
class MainApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val configuration = RealmConfiguration.Builder()
                .name("mobilenews.realm")
                .schemaVersion(2)
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(configuration)
        Realm.getInstance(configuration)
    }

    override fun onTerminate() {
        Realm.getDefaultInstance().close()
        super.onTerminate()
    }
}
