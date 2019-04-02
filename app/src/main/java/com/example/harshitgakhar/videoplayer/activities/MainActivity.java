package com.example.harshitgakhar.videoplayer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.harshitgakhar.videoplayer.R;
import com.example.harshitgakhar.videoplayer.adapters.RecycleViewAdapter;
import com.example.harshitgakhar.videoplayer.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final String JSON_URL = "https://interview-e18de.firebaseio.com/media.json?print=pretty";
    private JsonArrayRequest request;
    private RequestQueue requestqueue;
    private List<Anime> lstAnime;
    private RecyclerView recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      lstAnime = new ArrayList<>();
        recyclerview = findViewById(R.id.recyclerview_id);
        jsonrequest();
    }

    private void jsonrequest() {
        request =new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject= null;

                for (int i =0; i<response.length();i++)
                {

                    try {
                        jsonObject=response.getJSONObject(i);
                        Anime anime=new Anime();
                        anime.setTitle(jsonObject.getString("title"));
                        anime.setDesc(jsonObject.getString("description"));
                        anime.setThumbnail(jsonObject.getString("thumb"));
                        lstAnime.add(anime);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(lstAnime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestqueue = Volley.newRequestQueue(MainActivity.this);
        requestqueue.add(request);
    }

    private void setuprecyclerview(List<Anime> lstAnime) {
        RecycleViewAdapter myadapter= new RecycleViewAdapter(this,lstAnime);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        recyclerview.setAdapter(myadapter);

    }
}
