package com.glodon.easyshow.config;

import com.google.common.collect.Ordering;
import org.springframework.beans.factory.FactoryBean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Operation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName SwaggerApiDocketFactoryBean
 * @Description: 自定义swagger文档docket bean
 * @Author: fanwd
 * @Date: Create in 0:16 2019/10/16
 */
public class SwaggerApiDocketFactoryBean implements FactoryBean<Docket> {

    private String prefix;
    private String groupName;

    public SwaggerApiDocketFactoryBean(String prefix, String groupName) {
        this.prefix = prefix;
        this.groupName = groupName;
    }

    @Override
    public Docket getObject() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket = docket.groupName(groupName)
                .operationOrdering(new Ordering<Operation>() {
                    @Override
                    public int compare(Operation left, Operation right) {
                        // api排序规则
                        return left.getMethod().name().compareTo(right.getMethod().name());
                    }
                })
                .apiInfo(
                        new ApiInfoBuilder()
                                .title(groupName)
                                .description(groupName)
                                .version("1.0")
                                .build()
                )
                .select()
                .apis((input) -> {
                    String className = input.declaringClass().getName();
                    String methodName = input.getName();
                    String fullName = className + "." + methodName;
                    if (fullName.startsWith(prefix)) {
                        return true;
                    }
                    return false;
                }).paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Override
    public Class<?> getObjectType() {
        return Docket.class;
    }
}
