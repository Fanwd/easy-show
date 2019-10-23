package com.glodon.easyshow.series;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName SeriesJsCalcProperties
 * @Description TODO
 * @Author fanwd
 * @Date 2019/10/23 18:43
 **/
@Component
@ConfigurationProperties("design.series.calc")
public class SeriesJsCalcProperties {

    /**
     * js名称
     */
    private String jsName;

    /**
     * 对象名称
     */
    private String objectName;

    /**
     * 方法名称
     */
    private String methodName;

    public String getJsName() {
        return jsName;
    }

    public void setJsName(String jsName) {
        this.jsName = jsName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
