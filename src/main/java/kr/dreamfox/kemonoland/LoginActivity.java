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

public class LoginActivity extends Activity{
    static String ID = "test";
    static char[] PW = "Password".toCharArray();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
    }

    public void successLogin(View v){
        Intent account = new Intent();
        account.putExtra("ID",ID);
        setResult(RESULT_OK,account);
        //Activity.RESULT_OK
        finish();
    }

    
}
