package com.biz.demo.web;

import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.time.Duration;

/**
 * @author: 软件手
 * @date: 2022/8/5 9:42
 * @description:
 */
public class test {
    // SpringBoot对静态资源的映射规则 自动配置  org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (!this.resourceProperties.isAddMappings()) {
//            logger.debug("Default resource handling disabled");
//            return;
//        }
//        Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
//        CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
//        if (!registry.hasMappingForPattern("/webjars/**")) {
//            customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
//                    .addResourceLocations("classpath:/META-INF/resources/webjars/")
//                    .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
//        }
//        String staticPathPattern = this.mvcProperties.getStaticPathPattern();
//        if (!registry.hasMappingForPattern(staticPathPattern)) {
//            customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
//                    .addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
//                    .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
//        }
//    }
}
