package com.susuper.package1.classpath.impl;

import com.susuper.package1.classpath.Entry;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author gjd3 zip 压缩文件路径方式获取
 */
public class ZipEntry implements Entry {

  private Path absolutePath;

  public ZipEntry(String path) {
    this.absolutePath = Paths.get(path).toAbsolutePath();
  }

  @Override
  public byte[] readClass(String className) throws IOException {
    try (FileSystem zipFs = FileSystems.newFileSystem(absolutePath, null)) {
      return Files.readAllBytes(zipFs.getPath(className));
    }
  }
}
