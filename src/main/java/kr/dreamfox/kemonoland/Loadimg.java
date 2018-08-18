package kr.dreamfox.kemonoland;

import java.io.InputStream;
import android.os.AsyncTask;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;


public class Loadimg extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;
    //public AsyncResponse delegate = null;
    
    public Loadimg(ImageView bmImage) {
        this.bmImage = bmImage;
        //delegate = A;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            //Log.e("Error", e.getMessage());
           // e.printStackTrace();
        }
        //bmImage.setImageBitmap(mIcon11);
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
        //delegate.processFinish(result);
    }
}
//이 소스들은 나중에 꼭 수정하자
