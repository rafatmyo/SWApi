package com.soccer.rafat.myapplication;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchesListFragment extends ListFragment {


    public MatchesListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matches_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StarWarsAdapter adapter = getAdapter();
        setListAdapter(adapter); //Como se le da un adaptador a una lista
    }

    private StarWarsAdapter getAdapter(){
        StarWarsAdapter adapter = new StarWarsAdapter(
                getActivity(),R.layout.starwars_characters, new ArrayList<Match>());

        try {
            JSONObject jsonObject = new JSONObject(getJSOND());
            JSONArray jsonArray = jsonObject.getJSONArray("name");
            for(int i = 0; i < jsonArray.length();i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                JSONArray matches = jsonObject1.getJSONArray("matches");
                for (int j = 0; j < matches.length();j++){
                    JSONObject unMatch = matches.getJSONObject(j);
                    Match m = new Match();
                    m.name = unMatch.getString("name");
                    m.birth = unMatch.getString("birth");
                    adapter.add(m);

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return adapter;
    }


    private String getJSOND(){
        try {
            InputStream inputStream = getActivity().getAssets().open("liga.json");
            int s = inputStream.available();
            byte[] archivo = new byte[s];
            inputStream.read(archivo);
            inputStream.close();
            return new String(archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
