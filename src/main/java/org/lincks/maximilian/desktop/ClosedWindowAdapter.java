package org.lincks.maximilian.desktop;

import org.lincks.maximilian.desktop.core.notification.NotificationManager;

import java.awt.event.WindowAdapter;
import java.time.Duration;
import java.util.Random;


public class ClosedWindowAdapter extends WindowAdapter {

    private final Random random = new Random();
    private final NotificationManager manager;
    private final Duration min;
    private final Duration max;

    public ClosedWindowAdapter(NotificationManager manager, Duration min, Duration max) {
        super();
        this.manager = manager;
        this.min = min;
        this.max = max;
    }

    @Override
    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
        manager.clearPanel();
        try {
            Thread.sleep(random.nextLong(min.toMillis(), max.toMillis()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        manager.addRandomNotification();
    }


}
