package com.yh.demo.webwiththymeleaf;

import com.yh.demo.webwiththymeleaf.common.Constant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.yh.demo.webwiththymeleaf.common.Constant.PROJECT_TITLE;

/**
 * web-with-thymeleaf-SwaggerConfig
 * swagger配置类
 *
 * @author yh
 * @since 0.0.1 2017-08-20 21:58
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(Constant.PACKAGE_NAME))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(Constant.PROJECT_TITLE)
                .description(Constant.PROJECT_DESCRIPTION)
                //.termsOfServiceUrl("http://blog.didispace.com/")
                .contact(Constant.AUTHOR)
                .version(Constant.VERSION)
                .build();
    }
}
