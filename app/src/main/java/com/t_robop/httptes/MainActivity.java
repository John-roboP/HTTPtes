package com.t_robop.httptes;


import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>  {

  String json="BBB";
    TextView tv0;

    Bundle args = new Bundle(1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv0 = (TextView) findViewById(R.id.textView0);

        getSupportLoaderManager().initLoader(0, args, this);//onCreateLoader起動




    }

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {

        AsyncWorker loader = new AsyncWorker(getApplication());
        loader.forceLoad(); //これでロードが始まる。AsyncTaskLoader#onStartLoading内に実装するのも可。
        return null;//ここの返り値はnullでいいのだろうか・・・
        /**  String urlStr = args.getString(KEY_URL_STR);
       // if (! TextUtils.isEmpty(urlStr)) {
         return new AsyncWorker(getApplicationContext(),json);
    //    }

        **/

    }

    @Override
    public void onLoadFinished(Loader<String> loader, String Myname) {

       json=Myname;
        json="CCC";//確認のためCCCを代入
    }

    @Override
    public void onLoaderReset(Loader<String> arg0) {
        //今回は使わない
    }

    public void button00(View v){

        tv0.setText(json);
        //これでデータが表示できたらOKだが今の段階だとボタンを押すとBBBになる。onLoadfinishedが呼ばれていないのかも
        /**
         *
         *
         * apache2のログからインターネットに接続できているのは確認済み、JSONの取得コードが未完成**/
    }



}





