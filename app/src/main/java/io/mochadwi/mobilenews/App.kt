package io.mochadwi.mobilenews

import android.support.multidex.MultiDexApplication
import io.mochadwi.mobilenews.domain.model.news_source.modules.SourcesItemModule
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by mochadwi on 3/15/18.
 */
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val configuration = RealmConfiguration.Builder()
                .name("app_news.realm")
                .schemaVersion(4)
                .deleteRealmIfMigrationNeeded()
                .modules(SourcesItemModule())
                .build()

        Realm.setDefaultConfiguration(configuration)
        Realm.getInstance(configuration)
    }

    override fun onTerminate() {
        Realm.getDefaultInstance().close()
        super.onTerminate()
    }
}
