package com.glodon.easyshow.js;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.script.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CalcJsTest
 * @Description js计算
 * @Author fanwd
 * @Date 2019/10/23 9:27
 **/
public class CalcJsTest {

    private static final List<Project> projectList = new ArrayList<>();

    static {
        projectList.add(new Project(1L, "龙城小区", "辽宁省", "沈阳市", 160.0, 200.0, 500.0, "在建"));
        projectList.add(new Project(2L, "城市公园", "辽宁省", "沈阳市", 450.0, 570.0, 800.0, "在建"));
        projectList.add(new Project(3L, "滨海共路", "辽宁省", "大连市", 370.0, 490.0, 630.0, "完工"));
        projectList.add(new Project(4L, "健身公园", "河北省", "唐山市", 190.0, 250.0, 410.0, "在建"));
        projectList.add(new Project(5L, "长河大厦", "河北省", "邯郸市", 520.0, 410.0, 940.0, "完工"));
        projectList.add(new Project(6L, "城市月光", "河南省", "郑州市", 390.0, 590.0, 730.0, "在建"));
        projectList.add(new Project(7L, "长远天地", "陕西省", "西安市", 410.0, 690.0, 860.0, "完工"));
        projectList.add(new Project(8L, "城南嘉园", "山东省", "济南市", 290.0, 970.0, 420.0, "在建"));
        projectList.add(new Project(9L, "城市芳庭", "山东省", "青岛市", 810.0, 360.0, 910.0, "在建"));
    }

    public static void main(String[] args) throws IOException, ScriptException, NoSuchMethodException {

        String design = "{\"xAxisConfig\":{\"typeField\":{\"field\":\"province\",\"aliasName\":\"省份\",\"sort\":{\"sortBy\":\"x\",\"sortName\":\"省份\",\"sortType\":\"asc\"},\"filter\":[]},\"seriesField\":{}},\"yAxisConfig\":[{\"type\":\"field\",\"name\":\"planValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"计划产值\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]},{\"type\":\"field\",\"name\":\"realValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"实际产值\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]},{\"type\":\"field\",\"name\":\"constructValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"合同额\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]}]}";

        // js引擎
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");

        // js文件
        InputStream resourceAsStream = CalcJsTest.class.getClassLoader().getResourceAsStream("calcjs/EasyDashboard.umd.min.js");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        engine.eval(inputStreamReader);

        if (engine instanceof Invocable) {
            // 执行js
            Invocable invocable = (Invocable) engine;

            Map<String, String> map = new HashMap<>();
            map.put("key", "5daae43a50ef314a68d292eb");
            map.put("dom", "document.body");

            Object obj = engine.get("EasyDashboard");
            Object result = invocable.invokeMethod(obj, "init", map);
//            Object result = invocable.invokeFunction("obj.test", design, projectList);
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("执行结果" + objectMapper.writeValueAsString(result));
        }
    }

    private static void runOri() throws ScriptException, NoSuchMethodException {
        String design = "{\"xAxisConfig\":{\"typeField\":{\"field\":\"province\",\"aliasName\":\"省份\",\"sort\":{\"sortBy\":\"x\",\"sortName\":\"省份\",\"sortType\":\"asc\"},\"filter\":[]},\"seriesField\":{}},\"yAxisConfig\":[{\"type\":\"field\",\"name\":\"planValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"计划产值\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]},{\"type\":\"field\",\"name\":\"realValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"实际产值\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]},{\"type\":\"field\",\"name\":\"constructValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"合同额\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]}]}";

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");

        InputStream resourceAsStream = CalcJsTest.class.getClassLoader().getResourceAsStream("calcjs/series.js");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);

        engine.eval(inputStreamReader);
        if (engine instanceof Invocable) {
            Invocable invocable = (Invocable) engine;

            for (int i = 0; i < 1000; i++) {
                Object result = invocable.invokeFunction("parseConfig", design, projectList);
                System.out.println("--" + result);
            }
        }
    }

    private static void runCompil() throws ScriptException, NoSuchMethodException {
        String design = "{\"xAxisConfig\":{\"typeField\":{\"field\":\"province\",\"aliasName\":\"省份\",\"sort\":{\"sortBy\":\"x\",\"sortName\":\"省份\",\"sortType\":\"asc\"},\"filter\":[]},\"seriesField\":{}},\"yAxisConfig\":[{\"type\":\"field\",\"name\":\"planValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"计划产值\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]},{\"type\":\"field\",\"name\":\"realValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"实际产值\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]},{\"type\":\"field\",\"name\":\"constructValue\",\"showType\":\"bar\",\"yIndex\":\"0\",\"aliasName\":\"合同额\",\"calcType\":\"\",\"isVisible\":true,\"filter\":[]}]}";

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("js");

        InputStream resourceAsStream = CalcJsTest.class.getClassLoader().getResourceAsStream("calcjs/series.js");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);

        if (engine instanceof Compilable) {
            Compilable compilable = (Compilable) engine;
            CompiledScript compiledScript = compilable.compile(inputStreamReader);
            compiledScript.eval();
            ScriptEngine scriptEngine = compiledScript.getEngine();
            if (scriptEngine instanceof Invocable) {
                Invocable invocable = (Invocable) scriptEngine;
                for (int i = 0; i < 1000; i++) {
                    Object result = invocable.invokeFunction("parseConfig", design, projectList);
                    System.out.println("--" + result);
                }
            }
        }
    }
}
