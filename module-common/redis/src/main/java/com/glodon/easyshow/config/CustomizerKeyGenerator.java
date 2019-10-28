package com.glodon.easyshow.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @ClassName CustomizerKeyGenerator
 * @Description 自定义key生成方式
 * @Author fanwd
 * @Date 2019/10/25 14:52
 **/
public class CustomizerKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        String simpleName = target.getClass().getSimpleName();

        String methodName = method.getName();

        if (params.length == 0) {
            return simpleName + ":" + methodName;
        }
        String param = StringUtils.arrayToCommaDelimitedString(params);

        return simpleName + ":" + methodName + "(" + param + ")";
    }
}
