package com.ruchika.mytodoapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

;

//import com.activeandroid.ActiveAndroid;

//import com.activeandroid.ActiveAndroid;


public class MainActivity extends AppCompatActivity {

    //Select query returns List
    List<Item> itemsL;
    // Construct ArrayList for model type
    ArrayList<Item> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private final int REQUEST_CODE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize Active Android
        Configuration.Builder dbConfiguration = new Configuration.Builder(this);
        dbConfiguration.setDatabaseName("todo.db");
        dbConfiguration.addModelClass(Item.class);
        ActiveAndroid.initialize(dbConfiguration.create());


        setContentView(R.layout.activity_main);
        //Displays List field
        lvItems = (ListView) findViewById(R.id.lvItems);

        //items = new ArrayList<>();

      /* 2 readItems();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);*/

       /* items.add("First Item");
         items.add("Second Item");*/

       // 2setupListViewListener();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

   /* 2 private void setupListViewListener() {
        lvItems.setOnItemLongClickListener
                (
                        new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                                items.remove(pos);
                                itemsAdapter.notifyDataSetChanged();
                                //writeItems();
                                return true;
                            }
                        });
        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> padapter, View item, int pos, long id) {

                            Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                            i.putExtra("position", pos);
                            i.putExtra("value", items.get(pos).toString());
                        startActivityForResult(i, REQUEST_CODE);
                    }
                }
        );
    }
*/


    public void onAddItem(View V) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
      /*  if (TextUtils.isEmpty(name)) {
            etNewItem.requestFocus();
            Toast.makeText(context, R.string.please_enter_name, Toast.LENGTH_SHORT).show();
            return;
        }*/

        Item it = new Item();
        it.name = itemText;
        it.save();
       // itemsAdapter.add(itemText);
        etNewItem.setText("");
       // writeItems();
    }

   /*2 private void readItems() {
        try {


            // Construct adapter plugging in the array source
            itemsAdapter =
                    new ArrayAdapter<Item> (this, items);
            // Query ActiveAndroid for list of data
            List<TodoItem> queryResults = new Select().from(TodoItem.class)
                    .orderBy("Name ASC").limit(100).execute();
            // Load the result into the adapter using `addAll`
            adapterTodoItems.addAll(queryResults);




            itemsL = Item.getAll();


        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }*/

    /*private void writeItems() {
        //File filesDir = getFilesDir();
        //File todoFile = new File(filesDir, "todo.txt");

        try {
        //    FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    /*2

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            String updatedValue = data.getStringExtra("value");
            int pos = data.getIntExtra("position", 0);
            items.remove(pos);
            itemsAdapter.insert(updatedValue, pos);
           // writeItems();
        }

    }*/

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ruchika.mytodoapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ruchika.mytodoapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu, menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
