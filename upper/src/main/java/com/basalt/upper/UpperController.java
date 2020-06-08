package com.basalt.upper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

@RestController
public class UpperController {

  private Logger logger = LoggerFactory.getLogger(UpperController.class);

  @Autowired
  Environment environment;

  @RequestMapping("upper")
  public Upper upper(@RequestParam("value") String value) throws UnknownHostException {
    // TODO handle style
    var style = Style.valueOf(environment.getProperty("upper.style"));
    var port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
    var host = InetAddress.getLocalHost().getHostAddress();
    Upper upper = new Upper()
      .setHost(host)
      .setPort(port)
      .setContent(value.toUpperCase());

    logger.info("upper called, will return " + upper.toString());
    return upper;
  }

}
