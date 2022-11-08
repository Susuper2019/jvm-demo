package com.susuper.package1.classpath.impl;

import com.susuper.package1.classpath.Entry;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gjd3
 */
public class CompositeEntry implements Entry {

  private final List<Entry> entryList = new ArrayList<>();


  public CompositeEntry(String pathList) {
    String[] pathLists = pathList.split(File.pathSeparator);
    for (String path : pathLists) {
      entryList.add(Entry.create(path));
    }
  }

  @Override
  public byte[] readClass(String className) throws IOException {
    for (Entry entry : entryList) {
      return entry.readClass(className);
    }
    throw new IOException("class not found " + className);
  }
}
