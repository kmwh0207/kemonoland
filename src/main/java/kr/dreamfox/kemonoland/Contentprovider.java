package kr.dreamfox.kemonoland;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
 //http://blog.naver.com/PostView.nhn?blogId=tkddlf4209&logNo=220739962733&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView
 
 //http://unikys.tistory.com/218
public class Contentprovider extends ContentProvider {
    
    private Uri contentUri = Uri.parse("kr.dreamfox.kemonoland.Contentprovider");
    private SQLiteDatabase db;
 
    @Override
    public boolean onCreate() {
        Context context = getContext();
        DbHelper mySQLiteOpenHelper = new DbHelper(context,"TestDb");
        db = mySQLiteOpenHelper.getWritableDatabase();
        return (db == null) ? false : true;
    }
 
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int id = db.delete("profiles", selection, selectionArgs);
        if (id > 0) {
            Uri muri = ContentUris.withAppendedId(contentUri, id);
            getContext().getContentResolver().notifyChange(muri, null);
        } else {
           //삭제 실패했을 경우
        }
        return id;
    }
 
    @Override
    public String getType(Uri uri) {
        return null;
    }
 
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri muri = null;
        long id = db.insert("profiles", "name", values);
        if (id > 0) {
            muri = ContentUris.withAppendedId(contentUri, id);
            getContext().getContentResolver().notifyChange(muri, null);
        } else {
           //삽입 실패했을 경우
        }
        return muri;
    }
 
 
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
 
        Cursor c = db.query("profiles", null, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }
 
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int id = db.update("profiles", values, selection, selectionArgs);
        if (id > 0) {
            Uri muri  = ContentUris.withAppendedId(contentUri, id);
            getContext().getContentResolver().notifyChange(muri, null);
        } else {
            //업데이트 실패했을 경우
        }
        return id;
    }
 
}
