package org.lincks.maximilian.desktop;

import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

public class UiTexts {

  private final Map<String, String> uiTexts;

  public UiTexts(String resourcesRoot) {
    Map<String, String> tempTexts;
    try (Stream<String> lines = Files.lines(Path.of(resourcesRoot + "/config.txt"))) {
      tempTexts =
          lines
              .map(line -> line.split("=", 2))
              .collect(toMap(key -> key[0], val -> val[1].replaceFirst(";$", "")));
    } catch (IOException e) {
      tempTexts = Map.of();
    }
    uiTexts = tempTexts;
    System.out.println(uiTexts);
  }

  public String getText(String key) {
    return uiTexts.getOrDefault(key, key);
  }
}
