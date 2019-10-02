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
        final String colors[] = {"Select a color", "Red", "Magenta", "Yellow", "Green", "Blue", "Cyan", "White", "Gray",
                "Lime", "Olive", "Purple", "Teal"};
        Spinner spinner = findViewById(R.id.spinner);

        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner.setAdapter(colorAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0){
                    String selectedColor = colors[position];
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
