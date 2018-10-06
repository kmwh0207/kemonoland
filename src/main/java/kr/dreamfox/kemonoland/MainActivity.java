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
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

//git설명서 https://medium.com/@joongwon/git-git-%EB%AA%85%EB%A0%B9%EC%96%B4-%EC%A0%95%EB%A6%AC-c25b421ecdbd
//git 삭제된 파일 되돌리기 http://kjjeon.blogspot.com/2015/04/git.html
//git config --global --unset credential.helper
//--system

//ㄴ리스트뷰 다양한 옵션들 http://recipes4dev.tistory.com/47
public class MainActivity extends Activity implements View.OnClickListener{
    
    static public MainActivity MainActivity;
    static public Sharedpref mpref; //설정파일
    static private Intent Login;
    static private Intent ModeSelect;
    static public Context context;
    static final int LOGINCODE = 1;
    protected TextView Startlogo;
    Animation logoImpact;
    static String ID = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mpref = Sharedpref.getInstance("pref",this);
        Login = new Intent(MainActivity.this,LoginActivity.class);
        //Login.setComponent(new ComponentName("kr.dreamfox.kemonoland", "kr.dreamfox.kemonoland.LoginActivity"));
        
        ModeSelect = new Intent(MainActivity.this,GameSelector.class);
       
        //startActivityForResult(Login,LOGINCODE);
        //Toast.makeText(context,"로그인",Toast.LENGTH_LONG).show();
        ImageView Mainbackground =(ImageView)findViewById(R.id.mainbackground);
        TextView LogoutBt =(TextView)findViewById(R.id.Logout);
        TextView Startlogo =(TextView)findViewById(R.id.StartLogo);
        Mainbackground.setOnClickListener(this);
        LogoutBt.setOnClickListener(this);
        Startlogo.setOnClickListener(this);
    }
    
    public void onStart(Bundle b){
        
    }
   
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
        switch (requestCode){
            case LOGINCODE :
                //LOGINCODE = 0;
                ID = data.getStringExtra("ID");
                break;
            }
        }
    }
    
    public void onClick(View v) {
        Toast.makeText(context,"click",Toast.LENGTH_LONG).show();
		//ViewGroup MainScrTouch=(ViewGroup)findViewById(R.id.Mainscrtouch);
		switch (v.getId()) {
    		case R.id.mainbackground:
    		    overridePendingTransition(R.anim.listanim,R.anim.listanimre);
    		    Toast.makeText(context,"메인화면터치",Toast.LENGTH_LONG).show();
    			//Intent menu = new Intent(;
    			if(ID == null){
    			    startActivityForResult(Login,LOGINCODE);
    			}
    			else{
        		    startActivityForResult(ModeSelect,LOGINCODE);
    			}

    			break;
    		case R.id.Logout:
    			startActivityForResult(Login,LOGINCODE);
    			Toast.makeText(context,"로그아웃터치",Toast.LENGTH_LONG).show();
    			break;
    		default:
    		    Toast.makeText(context,"알수없는",Toast.LENGTH_LONG).show();
    			break;
		}
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
        	final Animation logoImpact = AnimationUtils.loadAnimation(this,R.anim.logoanim);
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
                    //터치이벤트로 포커스 얻을경우 중단시킬것
                    try{
                        View focusview;
                	    if((focusview=getCurrentFocus()) != null){
                	        if(focusview.getId() == Startlogo.getId()){
                	            Startlogo.startAnimation(logoImpact);
                	        }
                        }else{
                            
                          //Startlogo.startAnimation(logoImpact);
                        }
                    }catch(Exception ex){
                        Toast.makeText(context,"포커스 에러",Toast.LENGTH_LONG).show();
                    }
                    //MainActivity.animcheck();
                    //intro1.putBooleanExtra("finish",false);
                    //intent.putExtra("isfinish",String.valueOf(editText.getText()));
                }
            });
            //logoImpact.setRepeatCount(Animation.INFINITE);
            //logoImpact.setRepeatMode(Animation.RESTART);
            Startlogo.startAnimation(logoImpact);
		}
	}
	public void animcheck(){
	    //View focusview = MainActivity.getCurrentFocus();
	    

                    
	}
	
    
}

