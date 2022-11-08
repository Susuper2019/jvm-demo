package com.susuper.package1.classpath.impl;

import com.susuper.package1.classpath.Entry;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author gjd3 适配符路径
 */
public class WildcardEntry extends CompositeEntry {

  public WildcardEntry(String path) {
    super(toPathList(path));
  }

  private static String toPathList(String wildCardPath) {
    String baseDir = wildCardPath.replace("*", ""); //remove *
    try {
      String collect = Files.walk(Paths.get(baseDir))
          .filter(Files::isRegularFile)
          .map(Path::toString)
          .filter(p -> p.endsWith(".jar") || p.endsWith(".JAR"))
          .collect(Collectors.joining(File.pathSeparator));
      return collect;
    } catch (IOException e) {
      return "";
    }
  }
}
