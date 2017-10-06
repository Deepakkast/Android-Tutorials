package aknay.realmdatabasetutorialpartone;

import android.app.Application;

import io.realm.Realm;

public class RealmDatabaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}