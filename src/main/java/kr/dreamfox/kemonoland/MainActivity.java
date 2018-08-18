package kr.dreamfox.kemonoland;

import android.app.Activity;
import android.app.ActionBar;
import android.os.Bundle;
import android.os.Build;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.ArrayList;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.Handler;
import android.graphics.Bitmap;
import java.util.*;
import android.net.Uri;
import android.widget.Toast;
import android.provider.Settings;
import android.content.Context;
import android.content.ComponentName;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

//git설명서 https://medium.com/@joongwon/git-git-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%A0%95%EB%A6%AC-c25b421ecdbd
//git 삭제된 파일 되돌리기 http://kjjeon.blogspot.com/2015/04/git.html
//git config --global --unset credential.helper
//--system

public class MainActivity extends Activity {
    
    static public MainActivity MainActivity;
    static public Sharedpref mpref; //설정파일
    static private Intent Login;
    static public Context context;
    static final int LOGINCODE = 1;
    protected TextView Startlogo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mpref = Sharedpref.getInstance(this);
        Login = new Intent();
        Login.setComponent(new ComponentName("kr.dreamfox.kemonoland", "kr.dreamfox.kemonoland.LoginActivity"));
        //startActivityForResult(Login,LOGINCODE);
        //Toast.makeText(context,"로그인",Toast.LENGTH_LONG).show();
    }
    
    public void onStart(Bundle b){
        
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
    }


    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
	public void onWindowFocusChanged(boolean hasFocus) {
	    super.onWindowFocusChanged(hasFocus);
		if( hasFocus ) {
        	context = this.getApplicationContext();
        	Toast.makeText(context,"로그인 완료",Toast.LENGTH_LONG).show();
        	Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerApplication(this.getApplicationContext()));
        	
        	Startlogo = (TextView)findViewById(R.id.StartLogo);
        	Animation logoImpact = AnimationUtils.loadAnimation(this,R.anim.logoanim);
            logoImpact.setAnimationListener(new Animation.AnimationListener(){
                @Override
                public void onAnimationStart(Animation arg0) {
                    //introimg.setVisibility(View.VISIBLE);
                    
                }           
                @Override
                public void onAnimationRepeat(Animation arg0) {
                }           
                @Override
                public void onAnimationEnd(Animation arg0) {
    
                    //intro1.putBooleanExtra("finish",false);
                    //intent.putExtra("isfinish",String.valueOf(editText.getText()));
                   
                }
            });
            logoImpact.setRepeatCount(Animation.INFINITE);
            logoImpact.setRepeatMode(Animation.RESTART);
            Startlogo.startAnimation(logoImpact);
		}
	}
    
}

