package ex.customplugin;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {


    Button btnShow;
    CustomPlugin plugin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button)findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);

        plugin = new CustomPlugin(this);

    }


    @Override public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.btnShow:
                    JSONArray ja = new JSONArray();
                    ja.put("ネイティブでノーティフィケーション");
                    ja.put("表示されるかな？");
                    plugin.execute(CustomPlugin.CMD_SHOW_NOTIFICATION, ja, null);
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
