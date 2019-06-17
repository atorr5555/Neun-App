package para.neun.smarthome;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "Neun";
    public static final String channelName = "Smart Home";

    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public NotificationCompat.Builder getChannelNotificationChangeConfig() {
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Smart Home")
                .setContentText("El perfil de configuración ha cambiado")
                .setSmallIcon(R.drawable.ic_android);
    }

    public NotificationCompat.Builder getChannelNotification(String alert) {
        return new NotificationCompat.Builder(getApplicationContext(), channelID)
                .setContentTitle("Smart Home")
                .setContentText(alert)
                .setSmallIcon(R.drawable.ic_android);
    }
}
