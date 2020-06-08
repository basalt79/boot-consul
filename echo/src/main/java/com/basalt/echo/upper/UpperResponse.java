package com.basalt.echo.upper;

public class UpperResponse {

  private String content;
  private String host;
  private int port;

  public String getContent() {
    return content;
  }

  public UpperResponse setContent(String content) {
    this.content = content;
    return this;
  }

  public int getPort() {
    return port;
  }

  public String getHost() {
    return host;
  }

  public UpperResponse setHost(String host) {
    this.host = host;
    return this;
  }

  public UpperResponse setPort(int port) {
    this.port = port;
    return this;
  }

  @Override
  public String toString() {
    return "UpperResponse{" +
      "content='" + content + '\'' +
      ", host='" + host + '\'' +
      ", port=" + port +
      '}';
  }

}
