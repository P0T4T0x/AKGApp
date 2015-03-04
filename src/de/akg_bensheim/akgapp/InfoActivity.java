package de.akg_bensheim.akgapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.widget.TextView;
import android.app.Activity;

public class InfoActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(Html.fromHtml(readFile(R.raw.info)));
        Linkify.addLinks(textView, Linkify.ALL);
    }

    // Liest eine per ID übergebene Datei in einen String
    public String readFile(int id) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this
                .getApplicationContext().getResources().openRawResource(id)));
        String line;
        StringBuilder text = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null)
                text.append(line);
        } catch (IOException e) {
            return null;
        }
        return text.toString();
    }

}
