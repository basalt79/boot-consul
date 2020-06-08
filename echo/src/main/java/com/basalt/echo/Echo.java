package com.basalt.upper;

public class Echo {

  private String content;
  private String host;
  private int port;

  public String getContent() {
    return content;
  }

  public Echo setContent(String content) {
    this.content = content;
    return this;
  }

  public int getPort() {
    return port;
  }

  public String getHost() {
    return host;
  }

  public Echo setHost(String host) {
    this.host = host;
    return this;
  }

  public Echo setPort(int port) {
    this.port = port;
    return this;
  }

  @Override
  public String toString() {
    return "Echo{" +
      "content='" + content + '\'' +
      ", host='" + host + '\'' +
      ", port=" + port +
      '}';
  }
}
