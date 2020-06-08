package com.basalt.upper;

public class Upper {

  private String content;
  private String host;
  private int port;

  public String getContent() {
    return content;
  }

  public Upper setContent(String content) {
    this.content = content;
    return this;
  }

  public int getPort() {
    return port;
  }

  public String getHost() {
    return host;
  }

  public Upper setHost(String host) {
    this.host = host;
    return this;
  }

  public Upper setPort(int port) {
    this.port = port;
    return this;
  }

  @Override
  public String toString() {
    return "Upper{" +
      "content='" + content + '\'' +
      ", host='" + host + '\'' +
      ", port=" + port +
      '}';
  }
}
