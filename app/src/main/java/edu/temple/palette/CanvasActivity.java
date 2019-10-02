package edu.temple.palette;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        findViewById(R.id.canvas_layout).setBackgroundColor(Color.parseColor(getIntent().getStringExtra(PaletteActivity.SELECTED_COLOR)));
    }
}
