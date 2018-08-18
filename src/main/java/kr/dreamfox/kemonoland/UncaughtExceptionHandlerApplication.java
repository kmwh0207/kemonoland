package kr.dreamfox.kemonoland;

import android.util.Log;
import android.widget.Toast;
import android.content.Context;

public class UncaughtExceptionHandlerApplication implements Thread.UncaughtExceptionHandler{
    
    private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    Context context;
    
    public UncaughtExceptionHandlerApplication(Context context){
        this.context=context;
    }
    
    
    private String getStackTrace(Throwable throwable) {
        
        if(throwable == null){
            return "finish/n";
        }
        return Log.getStackTraceString(throwable);

        /*
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
    
        Throwable cause = th;
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        final String stacktraceAsString = result.toString();
        printWriter.close();
    
        return stacktraceAsString;
        */
    }
    
    //apache 라이브러리 필요
    /*
    private void savelogs(Throwable throwable){
        for (final String element : ExceptionUtils.getRootCauseStackTrace(e)) {
           System.out.println(element);
        }
    }
    */

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try{
           
            Logsave.save(getStackTrace(ex),context);
            Logsave.save(getStackTrace(ex.getCause()),context);
        }
        catch(Throwable e){
            Toast.makeText(context,R.string.reporterror,Toast.LENGTH_SHORT).show();
        }
        finally{
            mUncaughtExceptionHandler.uncaughtException(thread, ex);
        }


        //예외처리를 하지 않고 DefaultUncaughtException으로 넘긴다.
        
        
        //android.os.Process.killProcess(android.os.Process.myPid());
        //System.exit(0);
    }
}
