package org.lincks.maximilian.desktop.core.notification;

import org.lincks.maximilian.desktop.App;
import org.lincks.maximilian.desktop.ClosedWindowAdapter;
import org.lincks.maximilian.desktop.core.notification.provider.NotificationProvider;
import org.lincks.maximilian.desktop.core.notification.provider.ProviderManager;

import javax.swing.*;
import java.time.Duration;
import java.util.List;


public class NotificationManager {
    private final JFrame frame = new JFrame("");
    private final JPanel panel = new JPanel();
    private final ProviderManager providerManager;

  private final Duration minDuration = Duration.ofMinutes(App.minDuration);
    private final Duration maxDuration = Duration.ofMinutes(App.maxDuration);

    private final Duration initialDelay = Duration.ofMinutes(App.delay);

    public NotificationManager(List<NotificationProvider> providers) throws InterruptedException {
        providerManager = new ProviderManager(providers);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new ClosedWindowAdapter(this, minDuration, maxDuration));
        frame.add(panel);

        System.out.println("Starting loop...");
        Thread.sleep(initialDelay.toMillis());

        addRandomNotification();
    }

    public static void show(JFrame frame) {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void clearPanel() {
        panel.removeAll();
    }

    public void addRandomNotification() {
        addNotification(randomNotification());
    }

    public Notification randomNotification() {
        return providerManager.randomNotification();
    }

    public void addNotification(Notification notification) {
        panel.add(notification.create());
        notification.setUp().accept(frame, panel);
        show(frame);
    }
}
