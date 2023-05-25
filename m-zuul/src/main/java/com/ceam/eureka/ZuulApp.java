package com.ceam.eureka;

import com.ceam.eureka.zuul.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author 曾帅
 * @date 2023/5/23 14:58
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApp {

  public static void main(String[] args) {
    SpringApplication.run(ZuulApp.class, args);
  }

  @Bean
  TokenFilter tokenFilter() {
    return new TokenFilter();
  }
}
