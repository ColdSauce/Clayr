package dwai.clayr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import dwai.clayr.R;

public class HistoryActivity extends Activity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent i = new Intent(HistoryActivity.this, DataLookActivity.class);
        startActivity(i);
    }

    public void takePicture(View v){
        // create Intent to take a picture and return control to the calling application
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); // create a file to save the image
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

        // start the image capture Intent
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }




    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(int type){
        Uri file = null;
        try {
            file = Uri.fromFile(getOutputMediaFile(type));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return file;
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type) throws FileNotFoundException{
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        if(!Environment.getExternalStorageState().equals("mounted")){
            throw new FileNotFoundException();
        }

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Clayr");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("Clayr", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_"+ timeStamp + ".jpg");
        } else if(type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_"+ timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent

            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
    }

    private class ImageTask extends AsyncTask<Uri,Void,String> {
        @Override
        protected String doInBackground(Uri...u) {
            Uri uri = u[0];

            Bitmap bmp = BitmapFactory.decodeFile(uri.getPath());
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            HttpClient httpClient = new DefaultHttpClient();
            //TODO: Put an actual url here.
            String urlToPostTo = "";
            HttpPost httpPost = new HttpPost(urlToPostTo);
            httpPost.setEntity(new ByteArrayEntity(byteArray));
            HttpResponse response = null;
            try{
                 response = httpClient.execute(httpPost);
            }
            catch (IOException e){
                e.printStackTrace();
            }

            String returnedString = "";
            String line = "";
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                while ((line = in.readLine()) != null) {
                    returnedString += line;
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return returnedString;
        }



        @Override
        protected void onPostExecute(String jsonData) {


        }
    }

    private class HistoryTask extends AsyncTask<CustomGridView,Void,String> {
         @Override
        protected String doInBackground(CustomGridView...v) {
           try {

                String getOfImage = "";
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(getOfImage).getContent());
                v[0].addGridElement(new GridElement(getApplicationContext(),bitmap));


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "200";

        }

         @Override
        protected void onPostExecute(String requestCode){
           if(requestCode.equals("200")){
                return;
            }

        }
    }
}
