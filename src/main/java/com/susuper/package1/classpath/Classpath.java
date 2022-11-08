package com.susuper.package1.classpath;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author gjd3
 */
public class Classpath {

  private Entry boostrapClassPath; //启动类路径
  private Entry extensionClasPath; //扩展类路径
  private Entry userClassPath;// 用户类路径

  public Classpath(String jrePath, String cpOption) {

  }

  private void boostraoAndExtensionClassPath(String jreOption) {
    String jreDir = getJreDir(jreOption);

  }

  private static String getJreDir(String jreOption) {
    if (jreOption != null && Files.exists(Paths.get(jreOption))) {
      return jreOption;
    }
    //todo add
    throw new RuntimeException("Can not find JRE folder!");
  }
}
