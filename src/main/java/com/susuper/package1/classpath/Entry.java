package com.susuper.package1.classpath;

import com.susuper.package1.classpath.impl.CompositeEntry;
import com.susuper.package1.classpath.impl.DirEntry;
import com.susuper.package1.classpath.impl.WildcardEntry;
import com.susuper.package1.classpath.impl.ZipEntry;
import java.io.File;
import java.io.IOException;

/**
 * @author gjd3
 */
public interface Entry {

  byte[] readClass(String className) throws IOException;

  static Entry create(String path) {
    //路劲分隔符  区分 win/linux
    if (path.contains(File.pathSeparator)) {
      return new CompositeEntry(path);
    }
    if (path.endsWith("*")) {
      return new WildcardEntry(path);
    }
    if (path.endsWith(".jar") || path.endsWith(".JAR") || path.endsWith(".zip") || path.endsWith(
        ".ZIP")) {
      return new ZipEntry(path);
    }
    return new DirEntry(path);
  }
}
