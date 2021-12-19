package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.handler.predicate.RoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 编码方式配置gateway路由断言规则（繁琐）
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了yigeid为route-name的路由规则，
     * 当访问地址http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder)     {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_news_baidu_guoji",r->r.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }

}
