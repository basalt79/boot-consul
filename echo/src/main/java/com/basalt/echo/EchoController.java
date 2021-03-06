package com.basalt.echo;

import com.basalt.echo.upper.UpperClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

@RestController
public class EchoController {

  private final Logger logger = LoggerFactory.getLogger(EchoController.class);
  private final Environment environment;
  private final UpperClient upperClient;

  public EchoController(Environment environment, UpperClient upperClient) {
    this.environment = environment;
    this.upperClient = upperClient;
  }

  @RequestMapping("echo")
  public Echo echo(@RequestParam(name = "value") String value) throws UnknownHostException {
    var configValue = environment.getProperty("echo.value");
    var upperResponse = upperClient.upper(value);
    var port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
    var host = InetAddress.getLocalHost().getHostAddress();
    Echo echo = new Echo()
      .setHost(host)
      .setPort(port)
      .setConfigValue(configValue)
      .setContent(value)
      .setUpperContent(upperResponse.getBody().getContent());
    logger.info("echo called, will return " + echo.toString());
    return echo;
  }

}
