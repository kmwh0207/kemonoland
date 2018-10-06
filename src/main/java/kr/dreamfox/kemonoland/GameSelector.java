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
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;


public class GameSelector extends Activity {
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameselector);
        sqLiteOpenHelper = new DbHelper(this,"mode"); //db헬퍼에 다른 테이블 생성시 작업가능하도록 수정할것
        
        // 중요!!! DB파일 다른 경로에 만들기 http://drkein.tistory.com/161
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
 
        List<String> list = new ArrayList<String>();
        
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Modechoose",null);
        //Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        if(!cursor.moveToFirst()) {
            if(!cursor.moveToNext()){
                //키 값 대입
                sqLiteDatabase.execSQL("create table Modechoose(_id INTEGER PRIMARY KEY AUTOINCREMENT,name text);");
                
                sqLiteDatabase.execSQL("insert into Modechoose(name) values('게임 시작')");
                sqLiteDatabase.execSQL("insert into Modechoose(name) values('아이템')");
                sqLiteDatabase.execSQL("insert into Modechoose(name) values('네트워크')");
                sqLiteDatabase.execSQL("insert into Modechoose(name) values('종료')");
            }

        }
        while(cursor .moveToNext()){
                list.add(cursor.getString(cursor .getColumnIndex("name")));
        }
        
 
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_expandable_list_item_2,cursor ,new String[]{"_id","name"},
                new int[]{android.R.id.text1, android.R.id.text2},0);
 
        ListView listView = (ListView)findViewById(R.id.modeitem);
        listView.setAdapter(cursorAdapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
                 
            }
        });
 
    }
    
     public void onPause() {
        super.onPause();
        // Remove the activity when its off the screen
        sqLiteOpenHelper.close();
        finish();
     }
    
}
