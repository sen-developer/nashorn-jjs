package JSS;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JJSTest {
    public static void main(String[] args) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
        Bindings bindings = engine.createBindings();
        bindings.put("surname","Valodski");

        Object obj;
        Object test;
        Object result;

        try {
//            engine.eval("print('Hello World')");
//            engine.eval(new FileReader("src/geek.js"));


            engine.eval(new FileReader("src/geek.js"));
            Invocable invocable = (Invocable) engine;
//            result running sayHi function from js file with String Arguments;

            result = invocable.invokeFunction("sayHi","John","hello");

            test = invocable.invokeFunction("getPerson",new Person("John",45),bindings.get("surname"));

        } catch (ScriptException | FileNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        bindings.remove("surname");
        System.out.println(test);
    }
}
