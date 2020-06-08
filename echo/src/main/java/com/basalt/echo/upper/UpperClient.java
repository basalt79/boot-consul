package com.basalt.echo.upper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "upper")
public interface UpperClient {

  @RequestMapping(value = "/upper", method = RequestMethod.POST, consumes = "application/json")
  ResponseEntity<UpperResponse> upper(@RequestParam(value="value") String value);

}
