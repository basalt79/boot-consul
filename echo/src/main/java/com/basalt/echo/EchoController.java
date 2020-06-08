package com.basalt.upper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

@RestController
public class EchoController {

  private Logger logger = LoggerFactory.getLogger(EchoController.class);

  @Autowired
  Environment environment;

  @RequestMapping("echo")
  public Echo echo() throws UnknownHostException {
    var content = environment.getProperty("echo.value");
    var port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
    var host = InetAddress.getLocalHost().getHostAddress();
    Echo echo = new Echo()
      .setHost(host)
      .setPort(port)
      .setContent(content);

    logger.info("echo called, will return " + echo.toString());
    return echo;
  }

}
