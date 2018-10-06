package kr.dreamfox.kemonoland;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.util.Log;
import android.widget.Toast;
import android.content.Context;
import android.os.AsyncTask;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;


public class Loadimg extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    Context context;
    //public AsyncResponse delegate = null;
    
    public Loadimg(ImageView bmImage,Context context) {
        this.bmImage = bmImage;
        this.context = context;
        //delegate = A;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap icon = null;
        try {
            URL url = new URL(urldisplay);
            //http 클라이언트 정의
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //통신개시
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode != 200){
                if(context != null){
                    Toast.makeText(context,"click",Toast.LENGTH_SHORT).show();
                }
                Log.d(Loadimg.class.getSimpleName(),"이미지 다운로드 연결 실패");
                return null;
            }
            //아래와 같은 코드
            //InputStream in = new URL(urldisplay).openStream();
            InputStream in = connection.getInputStream();
            icon = BitmapFactory.decodeStream(in);
            in.close();
            return icon;
        } catch (Exception e) {
            //Log.e("Error", e.getMessage());
           // e.printStackTrace();
           return null;
        }
        //bmImage.setImageBitmap(icon);
        
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
        //delegate.processFinish(result);
    }
}
//이 소스들은 나중에 꼭 수정하자
