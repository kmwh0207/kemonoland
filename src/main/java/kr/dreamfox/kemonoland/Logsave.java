package kr.dreamfox.kemonoland;

import java.io.PrintWriter;
//import java.io.StringWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import android.os.Environment;
import java.io.File;
import android.widget.Toast;
import android.content.Context;

public class Logsave {
    static String path = Environment.getDataDirectory().getAbsolutePath()+File.separator;
    
    public Logsave(){
        
    }
 
    static public void save(String e,Context context){
        makedir(context);
        try{
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(path+"report/error.txt",true));
            PrintWriter writer = new PrintWriter(bufferedwriter,true);
            writer.println(e);
            writer.close();
            bufferedwriter.close();
        }
        catch(Throwable a){
            Toast.makeText(context,"string 저장 실패",Toast.LENGTH_SHORT).show();
        }
    }
    
    
    static public void save(Throwable e,Context context){
        /*
        StackTraceElement[] elem = e.getStackTrace();
        for ( int i = 0; i < elem.length; i++ )
        {
            
        }
        */
       
       //e.getMessage()
       try{
            makedir(context);
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(path+"report/error.txt",true));
            PrintWriter writer = new PrintWriter(bufferedwriter,true);
            e.printStackTrace(writer); 
            
            writer.close();
            bufferedwriter.close();
        }
        catch(Throwable ex){
            Toast.makeText(context,"Throwable 에러 저장 실패",Toast.LENGTH_SHORT).show();
        }
    }
    
    static private void makedir(Context context){
        try{
            File dir = new File(path,"report");
           if(!dir.exists()){
               dir.mkdirs();
           }
        }
        catch(Throwable a){
            Toast.makeText(context,"디렉토리 생성 실패",Toast.LENGTH_SHORT).show();
        }
    }
}
