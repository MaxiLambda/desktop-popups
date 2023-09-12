package org.lincks.maximilian.desktop.core.notification.provider;

import org.lincks.maximilian.desktop.core.notification.Notification;

public interface NotificationProvider {
    Notification random();

    int weight();
}
