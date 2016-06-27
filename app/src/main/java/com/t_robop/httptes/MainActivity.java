package com.t_robop.httptes;


import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

//TODO コードは藤田ので動くかも jsonの書き方が間違ってたっぽい
public class MainActivity extends Activity
        implements LoaderCallbacks<JSONObject>{


    private static final int ADDRESSLOADER_ID = 0;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView0);

        getLoaderManager().restartLoader(ADDRESSLOADER_ID, null, this);

    }

    @Override
    public Loader<JSONObject> onCreateLoader(int id, Bundle args) {
        // TODO 自動生成されたメソッド・スタブ

        String url = "http://t-robop.org/test/test2.json";

        return new AsyncWorker(this, url);
    }

    @Override
    public void onLoadFinished(Loader<JSONObject> loader, JSONObject data) {
        // TODO 自動生成されたメソッド・スタブ
        if (data != null) {

            try {

                JSONObject jsonObject = data.getJSONObject("pidatas");
                //String date = jsonObject.getString("date");
                //textView.append(date);

                //JSONObject jsDataList = jsonObject.getJSONObject("temperature");


//                for (int i = 0; i < jsDataList.length(); i++) {
//
//                    JSONObject jsData = jsDataList.getJSONObject(i);
//
//                    String start_time = jsData.getString("start_time");
//                    String end_time = jsData.getString("end_time");
//                    String title = jsData.getString("title");
//                    String subtitle = jsData.getString("subtitle");
//
//                    String text =
//                            start_time + "\n" +
//                                    end_time + "\n" +
//                                    title + "\n" +
//                                    subtitle + "\n";
//            }



            } catch (JSONException e) {
                Log.d("onLoadFinished","JSONのパースに失敗しました。 JSONException=" + e);
            }


        }else{
            Log.d("onLoadFinished", "onLoadFinished error!");
        }
    }

    @Override
    public void onLoaderReset(Loader<JSONObject> loader) {
        // TODO 自動生成されたメソッド・スタブ

    }

}