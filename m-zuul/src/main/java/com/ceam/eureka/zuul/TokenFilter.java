package com.ceam.eureka.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 曾帅
 * @date 2023/5/23 14:58
 */
public class TokenFilter extends ZuulFilter {

  /**
   * 过滤器类型 PRE：这种过滤器在请求被路由调用之前调用。我们可利用这种过滤器实现身份验证、再集群中选择请求的微服务、记录调试信息等。
   * ROUTING：这种过滤器将请求路由到微服务。用于构建发送给微服务的请求，并使用Apache HttpClient或Netflix Ribbon构建和发送原始HTTP请求的位置。
   * POST：请求在路由到微服务之后执行。示例包括向响应添加标准HTTP标头、收集统计信息和指标、以及将响应从源传输到客户端。 ERROR：过滤器在其中一个阶段发生错误时执行
   *
   * @return
   */
  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }

  /**
   * 过滤器执行顺序 当一个请求在同一个阶段存在多个过滤器的时候 过滤器的执行顺序
   */
  @Override
  public int filterOrder() {
    return 0;
  }

  /**
   * 是否开启过滤
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /**
   * 编写过滤器拦截业务逻辑代码
   */
  @Override
  public Object run() throws ZuulException {
    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest request = requestContext.getRequest();
    String ip = request.getRemoteAddr();
    System.out.println(ip);
//		requestContext.setResponseBody("访问成功");
//		if (StringUtils.isEmpty(token)) {
//			requestContext.setSendZuulResponse(false);
//			requestContext.setResponseBody("token is null");
//			requestContext.setResponseStatusCode(401);
//		}
    return null;
  }
}