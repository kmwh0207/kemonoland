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



//http://blog.naver.com/PostView.nhn?blogId=tkddlf4209&logNo=220739962733&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView
//이거 꼭 읽기

//경로 바꾸기 http://caliou.tistory.com/156

public class DbHelper extends SQLiteOpenHelper {
 
    
    public class ProfileContract{
        public class ProfileEntry implements BaseColumns{
            //객체 생성 방지
            private ProfileEntry(){}
            
                public static final String TABLE_NAME = "profiles";
                public static final String _ID = "ID" ;
                public static final String COLUMN_NAME_NAME = "name";
                public static final String COLUMN_NAME_EMAIL = "email";
                public static final String COLUMN_NAME_PHONE = "phone";
            
        }
    }
    
    //DB SQL명령
    //profiles 테이블 생성 구문 정의
    private static final String SQL_CREATE_PROFILE_TABLE =
        "create table " + ProfileContract.ProfileEntry.TABLE_NAME + " (" +
        ProfileContract.ProfileEntry._ID + "text ,"+
        ProfileContract.ProfileEntry.COLUMN_NAME_NAME  + "text,"+
        ProfileContract.ProfileEntry.COLUMN_NAME_EMAIL + "text,"+
        ProfileContract.ProfileEntry.COLUMN_NAME_PHONE + "text"+ ")";
        
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "profile.db";
    
    public static String File_path = Environment.getDataDirectory().getAbsolutePath()+ File.separator + R.string.app_name+ File.separator;
    // public static String File_path = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator + R.string.app_name+ File.separator;
    //아래거로 수정
    public DbHelper(Context context, String name, CursorFactory factory, int version) {
        super(context,File_path+name, factory, version);
        
        // TODO Auto-generated constructor stub
    }
    public DbHelper(Context context, String name) {
        super(context,File_path+name, null,DB_VERSION);
        // TODO Auto-generated constructor stub
    }
    public DbHelper(Context context) {
        //super(context, name, factory, version);
        super (context,File_path+"profile.db",null,DB_VERSION);
        // TODO Auto-generated constructor stub
    }
     
    

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //테이블 생성 명령
        db.execSQL(SQL_CREATE_PROFILE_TABLE);
        //테스트 코드
        //db.execSQL("insert into "+ ProfileContract.ProfileEntry.TABLE_NAME +"("+ProfileContract.ProfileEntry.COLUMN_NAME_NAME+") values('굿햄')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        
    }
    
    public ContentValues getProfile(long rowId){
        SQLiteDatabase db = getReadableDatabase();
        if(db==null){
            throw new SQLiteCantOpenDatabaseException();
        }
        
        String table = ProfileContract.ProfileEntry.TABLE_NAME;
       //테이블 열 선택  
       String[] columns = {ProfileContract.ProfileEntry._ID,  ProfileContract.ProfileEntry.COLUMN_NAME_NAME,
         ProfileContract.ProfileEntry.COLUMN_NAME_EMAIL,  ProfileContract.ProfileEntry.COLUMN_NAME_PHONE};
        //sql질의 조건 설정
        String selection = ProfileContract.ProfileEntry._ID +"=?";
        String[] selectionArgs = {String.valueOf(rowId)};
        //질의 실행
        Cursor cursor = db.query(table,columns,selection, selectionArgs, null, null, null);
        
        
        //커서에서 정보 추출
        String name = getStringFromCursor(cursor, ProfileContract.ProfileEntry.COLUMN_NAME_NAME);
        String email = getStringFromCursor(cursor, ProfileContract.ProfileEntry.COLUMN_NAME_EMAIL);
        String phone = getStringFromCursor(cursor, ProfileContract.ProfileEntry.COLUMN_NAME_EMAIL);
        //ContentValues에 담기
        ContentValues values = new ContentValues();
        values.put(ProfileContract.ProfileEntry.COLUMN_NAME_NAME, name);
        values.put(ProfileContract.ProfileEntry.COLUMN_NAME_NAME, email);
        values.put(ProfileContract.ProfileEntry.COLUMN_NAME_NAME, phone);
        
        return values;
    }
    
    public long setProfile(String name, String email, String phone){
        SQLiteDatabase db = getWritableDatabase();
        if(db == null){
            throw new SQLiteCantOpenDatabaseException();
        }
        //ContentValues에 담기
        ContentValues values = new ContentValues();
        values.put(ProfileContract.ProfileEntry.COLUMN_NAME_NAME, name);
        values.put(ProfileContract.ProfileEntry.COLUMN_NAME_NAME, email);
        values.put(ProfileContract.ProfileEntry.COLUMN_NAME_NAME, phone);
        //DB 테이블에 정보 삽입
        long rowId = db.insert(ProfileContract.ProfileEntry.TABLE_NAME, null, values);
        return rowId;
    }
        
    private String getStringFromCursor(Cursor cursor, String columnName){
        
        return cursor.getString(cursor.getColumnIndexOrThrow(columnName));
    }
}