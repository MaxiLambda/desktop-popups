package org.lincks.maximilian.desktop;

import javax.swing.*;
import java.time.Duration;


public class NotificationManager {
    private final JFrame frame = new JFrame("");
    private final JPanel panel = new JPanel();

    public NotificationManager() throws InterruptedException {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new ClosedWindowAdapter(this, Duration.ofSeconds(3), Duration.ofSeconds(5)));
        frame.add(panel);

        System.out.println("Starting loop...");
        Thread.sleep(Duration.ofSeconds(0).toMillis());
        addNotification(Messages.random());
    }

    public void clearPanel() {
        panel.removeAll();
    }

    public void addNotification(Notification notification){
        panel.add(notification.create());
        notification.setUp().accept(frame, panel);
        show(frame);
    }

    public static void show(JFrame frame) {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
