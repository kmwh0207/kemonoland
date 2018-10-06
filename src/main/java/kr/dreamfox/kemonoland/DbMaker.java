package kr.dreamfox.kemonoland;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.os.Environment; 
import java.io.File;

public class DbMaker {
    StringBuffer FILE_PATH;
       
    public void makeDir(String dir,String name){
        File dbpath = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator + dir);  
        if(!dbpath.exists()){
            dbpath.mkdirs();
        }
        FILE_PATH = new StringBuffer();
        FILE_PATH.append(dbpath+ File.separator + name);
    }
}
