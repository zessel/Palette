package edu.temple.palette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    public static final String SELECTED_COLOR = "edu.temple.palette.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, CanvasActivity.class);

        Spinner spinner = findViewById(R.id.spinner);

        final String colors[] = getResources().getStringArray(R.array.color_array);
        final String hexes[] = getResources().getStringArray(R.array.color_hexes);

        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors, hexes);

        spinner.setAdapter(colorAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                    String selectedColor = hexes[position];
                    intent.putExtra(SELECTED_COLOR,selectedColor);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        }); 
    }

}
