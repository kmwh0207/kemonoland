package kr.dreamfox.kemonoland;


import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import net.openhft.compiler.CompilerUtils;

public class GameLoad {
   /* 
     String className = "mypackage.MyClass";
     String javaCode = "package mypackage;\n" +
                      "public class MyClass implements Runnable {\n" +
                      "    public void run() {\n" +
                      "        System.out.println(\"Hello World\");\n" +
                      "    }\n" +
                      "}\n";
    public void LoadString(){
         try{
         Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
         Runnable runner = (Runnable) aClass.newInstance();
         runner.run();
         } catch(Exception ex){
             
         }
     }
*/
}
