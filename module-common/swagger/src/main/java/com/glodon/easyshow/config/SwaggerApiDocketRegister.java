package com.glodon.easyshow.config;

import com.glodon.easyshow.anno.EnableSwaggerDoc;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SwaggerApiDocketRegister
 * @Description: 自动注册swagger
 * @Author: fanwd
 * @Date: Create in 0:15 2019/10/16
 */
public class SwaggerApiDocketRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        Map<String, Object> annotationAttributesMap = annotationMetadata.getAnnotationAttributes(EnableSwaggerDoc.class.getName());
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(annotationAttributesMap);

        String prefix = annotationAttributes.getString("prefix");
        String groupName = annotationAttributes.getString("groupName");

        // 通过FactoryBean自定义docket生成规则
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(SwaggerApiDocketFactoryBean.class);
        ConstructorArgumentValues constructorArgumentValues = genericBeanDefinition.getConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0, prefix);
        constructorArgumentValues.addIndexedArgumentValue(1, groupName);
        genericBeanDefinition.setPrimary(true);
        beanDefinitionRegistry.registerBeanDefinition(groupName, genericBeanDefinition);
    }
}
