package com.basalt.echo.upper;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "upper")
public interface UpperClient {

  @RequestMapping(value = "/upper", method = RequestMethod.POST, consumes = "application/json")
  ResponseEntity<UpperResponse> upper(@RequestParam(value="value") String value);

}

@Component
class UpperClientFallbackFactory implements FallbackFactory<UpperClient> {
  @Override
  public UpperClient create(Throwable cause) {
    return value -> ResponseEntity.of(Optional.of(new UpperResponse().setContent("fallback; reason was: " + cause.getMessage())));
  }
}

