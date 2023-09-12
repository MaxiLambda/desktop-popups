package org.lincks.maximilian.desktop.core.notification;

import javax.swing.*;
import java.util.function.BiConsumer;


public interface Notification {
    JPanel create();

    BiConsumer<JFrame, JPanel> setUp();


}

