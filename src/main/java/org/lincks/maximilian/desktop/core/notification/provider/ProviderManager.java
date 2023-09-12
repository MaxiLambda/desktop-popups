package org.lincks.maximilian.desktop.core.notification.provider;

import org.lincks.maximilian.desktop.core.notification.Notification;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ProviderManager {
    private final HashMap<Integer, NotificationProvider> providers = new HashMap<>();
    private final Random random = new Random();
    private final int totalWeight;

    public ProviderManager(List<NotificationProvider> providers) {
        int totalWeight = 0;
        for (NotificationProvider provider : providers) {
            if (provider.weight() > 0) {
                totalWeight += provider.weight();
                this.providers.put(totalWeight, provider);
            }
        }
        this.totalWeight = totalWeight;
    }

    public Notification randomNotification() {
        int value = random.nextInt(totalWeight);
        return providers
                .keySet()
                .stream()
                .filter(weight -> weight > value)
                .sorted()
                .findFirst()
                .map(index -> providers.get(index).random())
                .orElseThrow();
    }
}
