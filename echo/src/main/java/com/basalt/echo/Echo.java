package com.basalt.echo;

public class Echo {

  private String content;
  private String upperContent;
  private String configValue;
  private String host;
  private int port;

  public String getContent() {
    return content;
  }

  public Echo setContent(String content) {
    this.content = content;
    return this;
  }

  public String getUpperContent() {
    return upperContent;
  }

  public Echo setUpperContent(String upperContent) {
    this.upperContent = upperContent;
    return this;
  }

  public String getConfigValue() {
    return configValue;
  }

  public Echo setConfigValue(String configValue) {
    this.configValue = configValue;
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
      ", upperContent='" + upperContent + '\'' +
      ", configValue='" + configValue + '\'' +
      ", host='" + host + '\'' +
      ", port=" + port +
      '}';
  }
}
