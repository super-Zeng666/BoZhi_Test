package com.ceam.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

  @RequestMapping(path = "/hello")
  public String test() {
    return "hello world!";
  }
}
