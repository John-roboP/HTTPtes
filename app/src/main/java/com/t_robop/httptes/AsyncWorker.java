package com.t_robop.httptes;

import android.content.AsyncTaskLoader;
import android.content.Context;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;


//非同期処理
/**
 * Created by Ryo on 2016/06/25.
 */
public class AsyncWorker extends AsyncTaskLoader<String> {

    private JSONObject tx0;
   private String url;

    String Myname="AAAA";
    JSONObject json = new JSONObject();

    public AsyncWorker(Context context) {
       super(context);
       // this.url = url;
    }

    @Override
    public String loadInBackground() {
        //非同期でインターネット接続



        HttpURLConnection connection = null;
        try {

            // URLの作成
            URL url = new URL("http://192.168.0.31/");

// 接続用HttpURLConnectionオブジェクト作成
            connection = (HttpURLConnection) url.openConnection();
// リクエストメソッドの設定
            connection.setRequestMethod("GET");
// リダイレクトを自動で許可しない設定
            connection.setInstanceFollowRedirects(false);
// ヘッダーの設定(複数設定可能)
            connection.setRequestProperty("Accept-Language", "jp");

// 接続
            connection.connect();



            try {

                //url からJsonを取得する処理・・・

                JSONArray datase = json.getJSONArray("datas");

                for (int i = 0; i < datase.length(); i++) {
                    JSONObject data =datase.getJSONObject(i);

                    // 名前を取得
                    Myname = data.getString("name");
                    // 年齢を取得
                    // String age = data.getString("age");

                    //   tv0.setText(Myname);


                }

            } catch (JSONException e) {
                e.printStackTrace();
            }



        } catch (Exception e) {

            e.printStackTrace();
        }

        return Myname;
    }

}