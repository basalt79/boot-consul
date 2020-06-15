package com.basalt.echo.upper;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    return switch (response.status()) {
      case 400 -> new ResponseStatusException(HttpStatus.BAD_REQUEST, response.body().toString());
      case 404 -> new ResponseStatusException(HttpStatus.NOT_FOUND, response.body().toString());
      case 500 -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, response.body().toString());
      default -> new ResponseStatusException(HttpStatus.BAD_REQUEST);
    };
  }
}
