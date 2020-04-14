package com.example.homework3;

import android.graphics.Typeface;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ChuckNorris extends AsyncTask<Void, Void, Void> {
    String data = "";
    String value = "";

    @Override
    //background thread
    protected Void doInBackground(Void... voids) {
        try {
            //import random quote Chuck Norris API url. url filtered for development category
            URL url = new URL("https://api.chucknorris.io/jokes/random?category=dev");
            //create http connection by opening a connection to the chuck norris url address
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //create input stream to allow data to be read
            InputStream inputStream = httpURLConnection.getInputStream();
            //buffer reader to read data from inputStream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //bufferedReader reads the generated line of the json file
            data = bufferedReader.readLine();

            //create JSONObject and add every line of the json file to it
            JSONObject jsonObject = new JSONObject(data);
            //parse value field from the API (the quote) into the JSONObject
            value = ""+ jsonObject.get("value");

        //catch all exceptions from the try statement
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //UI thread
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        //set text of quote TextView to the "value" field of the json file and add quotation marks around the value
        MainActivity.quote.setText("''" + this.value + "''");
        //set quote text to italics
        MainActivity.quote.setTypeface(null, Typeface.ITALIC);

    }
}
