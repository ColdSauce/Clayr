package dwai.clayr;

import android.net.Uri;

import org.json.JSONObject;

/**
 * Created by nick_000 on 9/14/2014.
 */
public abstract class ClayrDataListener {
    abstract void onData(JSONObject data);
    public String url;
    public Uri uri;
}
