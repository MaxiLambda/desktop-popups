package org.lincks.maximilian.desktop;

import javax.swing.*;
import java.util.function.BiConsumer;


public interface Notification {
    JPanel create();
    BiConsumer<JFrame, JPanel> setUp();


}

