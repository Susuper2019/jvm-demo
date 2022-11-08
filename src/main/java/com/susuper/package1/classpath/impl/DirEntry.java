package com.susuper.package1.classpath.impl;

import com.susuper.package1.classpath.Entry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author gjd3
 * 目录形式类转换
 */
public class DirEntry implements Entry {

  private Path absolutePath;

  public DirEntry(String path) {
    this.absolutePath = Paths.get(path).toAbsolutePath();
  }

  @Override
  public byte[] readClass(String className) throws IOException {
    return Files.readAllBytes(absolutePath.resolve(className));
  }
}
