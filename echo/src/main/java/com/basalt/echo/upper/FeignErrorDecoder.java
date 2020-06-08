package com.basalt.echo.upper;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    switch (response.status()){
      case 400:
        return new IllegalArgumentException("400 BAD REQUEST");
      case 404:
        return new IllegalArgumentException("404 NOT FOUND");
      default:
        return new Exception("Generic error");
    }
  }
}
