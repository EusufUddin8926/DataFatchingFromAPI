package com.example.datafatchingfromapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.datafatchingfromapi.Login.LoginActivity;
import com.example.datafatchingfromapi.adapter.RecyclerAdapter;
import com.example.datafatchingfromapi.model.ItemClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mrecyclerview;
    private RecyclerAdapter mrecycleradapter;
    private ArrayList<ItemClass> mItemClassArrayList;
    private static String Jsonurl = "https://jsonplaceholder.typicode.com/photos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerview = findViewById(R.id.recycler_view);
        mItemClassArrayList = new ArrayList<>();




        ParseJson();





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.signout_view,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.signoutmenu){
            Intent intentmenu = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intentmenu);
        }
        return super.onOptionsItemSelected(item);
    }

    private void ParseJson() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, Jsonurl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject object = response.getJSONObject(i);

                                ItemClass itemClass = new ItemClass();
                                itemClass.setId(object.getInt("id"));
                                itemClass.setAlbumID(object.getInt("albumId"));
                                itemClass.setFirstimgURL(object.getString("url"));
                                itemClass.setSecoundimgURL(object.getString("thumbnailUrl"));
                                itemClass.setMtittle(object.getString("title").toString());

                                mItemClassArrayList.add(itemClass);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        mrecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        mrecyclerview.setHasFixedSize(true);
                        RecyclerAdapter adapter = new RecyclerAdapter(getApplicationContext(),mItemClassArrayList);
                        mrecyclerview.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: "+error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

    }

    @Override
    public void onBackPressed() {

    }
}
