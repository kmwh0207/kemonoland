package kr.dreamfox.kemonoland;

import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.content.Context;

public class Characterview extends SurfaceView implements SurfaceHolder.Callback{
    
    private SurfaceHolder surfaceholder;
    //public characterThread thread;
    //holder.setFormat(PixelFormat.TRANSLUCENT);
    public Characterview (Context context){
        super(context);
        this.setZOrderOnTop(true);
        
        
        
    }
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
	}

}

//public class characterThread extends Thread {
    
//}
