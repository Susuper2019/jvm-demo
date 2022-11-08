package com.susuper.package1;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.util.List;

/**
 * @author gjd3
 */
public class Cmd {

  @Parameter(names = {"-?", "-help"}, description = "print helo message", order = 3, help = true)
  boolean helpFlag = false;
  @Parameter(names = "-version", description = "print version and exit", order = 2)
  boolean versionFlag = false;
  @Parameter(names = {"-cp", "-classpath"}, description = "classpath", order = 1)
  String clsspath;

  @Parameter(description = "main class and args")
  List<String> mainClasssAndArgs;

  boolean ok;

  String getMainClass() {
    return mainClasssAndArgs != null && !mainClasssAndArgs.isEmpty() ? mainClasssAndArgs.get(0)
        : null;
  }

  List<String> getAppArgs() {
    return mainClasssAndArgs != null && mainClasssAndArgs.size() > 1 ? mainClasssAndArgs.subList(1,
        mainClasssAndArgs.size()) : null;
  }

  static Cmd parse(String[] argv) {
    Cmd args = new Cmd();
    JCommander cmd = JCommander.newBuilder().addObject(args).build();
    cmd.parse(argv);
    args.ok = true;
    return args;
  }


}
