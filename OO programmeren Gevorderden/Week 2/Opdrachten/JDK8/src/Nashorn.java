import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

/**
 * Created by xaviergeerinck on 20/11/13.
 */
public class Nashorn {
    public static void main(String args[]) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        engine.eval("function hello_world(msg) { print(msg); }");

        Invocable inv = (Invocable) engine;
        inv.invokeFunction("hello_world", "Hello World!");
    }
}
