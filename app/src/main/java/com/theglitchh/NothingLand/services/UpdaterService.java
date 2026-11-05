package com.theglitchh.NothingLand.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

/**
 * Stripped UpdaterService that performs no network requests and immediately terminates
 * to prevent call errors and eliminate auto-update features.
 */
public class UpdaterService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Immediately stop the service execution to prevent any network connectivity
        stopSelf();
    }
}
