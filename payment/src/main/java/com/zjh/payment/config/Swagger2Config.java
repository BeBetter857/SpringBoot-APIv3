package com.zjh.payment.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configurable // 标注这是一个配置类
@EnableSwagger2 //开启Swagger2
public class Swagger2Config {
    /**
     *
     * @return Swagger中的文档对象
     */
    @Bean
    public Docket docket(Environment environment){
        //  根据当前环境判断是否开启 Swagger
        Profiles profile = Profiles.of("dev","test");
        boolean acceptsProfiles = environment.acceptsProfiles(profile);

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).enable(acceptsProfiles).select().apis(RequestHandlerSelectors.basePackage("com.zjh.paymentdemo")).build();
    }

    private ApiInfo apiInfo() {
        Contact contact=new Contact("作者名",
                "http://www.jianshu.com/u/f192766abeab","email地址");
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2")
                .description("Hello Swagger2")
                //.termsOfServiceUrl("http://www.jianshu.com/u/f192766abeab")
                //.contact("作者名")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
