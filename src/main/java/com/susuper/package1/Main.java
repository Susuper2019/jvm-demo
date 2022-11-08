package com.susuper.package1;

/**
 * @author gjd3
 */
public class Main {

  public static void main(String[] args) {
    Cmd cmd = Cmd.parse(args);
    if (cmd.ok == false || cmd.helpFlag) {
      System.out.println("Usage: <main class> [-options] class [args...]");
      return;
    }
    if (cmd.versionFlag) {
      System.out.println("java version \"1.8.0\"");
      return;
    }
    startJvm(cmd);
  }

  private static void startJvm(Cmd cmd) {
    System.out.printf("classpath:%s class:%s args:%s\n", cmd.clsspath, cmd.getMainClass(),
        cmd.getAppArgs());
  }
}
