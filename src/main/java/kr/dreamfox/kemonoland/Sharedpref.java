package kr.dreamfox.kemonoland;

import android.content.SharedPreferences;
import android.content.Context;

public class Sharedpref {
    public static Sharedpref minstance;
    
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    // 값 불러오기
    private Sharedpref(Context context){
        pref = context.getSharedPreferences("pref",context.MODE_PRIVATE);
        editor = pref.edit();
    }
    
    protected static Sharedpref getInstance(Context context){
        if(minstance ==null){
            minstance = new Sharedpref(context);
        }
        return minstance;
    }
        
    public int getPref(){
        return pref.getInt("pref",0);
    }
     
    // 값 저장하기
    public void setPref(int num){
        editor.putInt("pref",num);
        editor.commit();
    }
     
    // 값(Key Data) 삭제하기
    public void removePref(){
        editor.remove("pref");
        editor.commit();
    }
     
    // 값(ALL Data) 삭제하기
    public void removeAllPref(){
        editor.clear();
        editor.commit();
    }
}
