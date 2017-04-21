package com.atf.pokemove.assessor.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.atf.pokemove.assessor.model.PokeData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainViewModel extends BaseObservable {
    private Context context;
    private String pokeName, pokeMove, nameType, moveType;
    private final String urlMove = "https://pokeapi.co/api/v2/move/", urlName = "https://pokeapi.co/api/v2/pokemon/";
    private RequestQueue requestQueue;
    private PokeData poke;
    public ObservableInt determineValueVisibility;
    public ObservableField<String> determineValue;

    public MainViewModel(Context context){
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
        poke = new PokeData();
        determineValueVisibility = new ObservableInt(View.INVISIBLE);
        determineValue = new ObservableField<>("Results here!");
    }

    public TextWatcher getPokeNameEditTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                poke.setName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    public TextWatcher getPokeMoveEditTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                poke.setMove(pokeMove = charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    public void nameRequest(View view){
        JsonObjectRequest name = new JsonObjectRequest(Request.Method.GET, urlName + poke.getName(), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray types = response.getJSONArray("types");
                            JSONObject obj = types.getJSONObject(0);
                            JSONObject subObj = obj.getJSONObject("type");
                            poke.setNameType(subObj.getString("name"));
                            moveRequest();
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error){
                        error.printStackTrace();
                    }
                });
        requestQueue.add(name);
    }

    public void moveRequest(){
        JsonObjectRequest move = new JsonObjectRequest(Request.Method.GET, urlMove + poke.getMove(), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONObject obj = response.getJSONObject("type");
                            poke.setMoveType(obj.getString("name"));
                            determineValue.set(poke.determineVulnerability());
                            determineValueVisibility.set(View.VISIBLE);
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error){
                        error.printStackTrace();
                    }
                });
        requestQueue.add(move);
    }

}
