package com.siddhartha.com.clistview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.siddhartha.com.clistview.R;
import com.siddhartha.com.clistview.adapters.MyListAdapter;
import com.siddhartha.com.clistview.bean.Items;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Items> arrayList;
    MyListAdapter myListAdapter;
    ListView listView;
    Boolean cls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cls = false;
        initialize();
        loadItems();
        display();

    }

    private void display() {

        listView.setAdapter(myListAdapter);
    }

    private void loadItems() {
        for(int i=0;i<100;i++)
        {
            Items items = new Items();
            items.setNames("Name -> "+i);
            arrayList.add(items);
        }
        myListAdapter.notifyDataSetChanged();
    }

    private void initialize() {
        arrayList = new ArrayList<>();
        myListAdapter = new MyListAdapter(this,arrayList);
        listView = (ListView)findViewById(R.id.listView);
    }


    public void del_it(View view)
    {
        cls = true;
        Toast.makeText(MainActivity.this, "cls == true", Toast.LENGTH_SHORT).show();
        Log.e("Values --> ",cls.toString());
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
