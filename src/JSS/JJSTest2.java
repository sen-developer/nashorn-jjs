package JSS;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JJSTest2 {
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
        Compilable compilableEngine = (Compilable) engine;
        Random r = new Random();
        StringBuilder script = new StringBuilder("var joj = function(){return 5}; joj();");
        ScriptContext context = engine.getContext();
        context.setAttribute("name","John",ScriptContext.ENGINE_SCOPE);
        int[] numArr = {5,4,3,2,1,10,-10};

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numList.add(i*r.nextInt(5));
        }
        Object result;
        Object result2;
        Object result3;
        Object result4;
        Object arrayToArrayResult;
        try {
            engine.eval(new FileReader("src/jjstest2.js"));
            CompiledScript compiledScript = compilableEngine.compile(script.toString());
            Invocable invocable = (Invocable) engine;
//            result2 = invocable.invokeFunction("foo", numList);
//            result = compiledScript.eval();
            arrayToArrayResult = invocable.invokeFunction("arrayToJavaArrayList",numList);
//            result3 = invocable.invokeFunction("getHello",context.getAttribute("name"));
            result4 = invocable.invokeFunction("arrayToJavaArray",numArr);

        } catch (ScriptException | FileNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
//        int[] arr = {Integer.parseInt(result4.toString().split(",")[0])};
        int[] newArr = new int[result4.toString().split(",").length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = Integer.parseInt(result4.toString().split(",")[i]);
        }

        System.out.println(Arrays.toString(newArr));
        System.out.println(arrayToArrayResult.getClass());
//        System.out.println(result);
//        System.out.println(result2);
//        System.out.println(result3);
    }
}
