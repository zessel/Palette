package edu.temple.palette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ColorSelectedInterface{

    FragmentManager fragmentManager;
    PaletteFragment paletteFragment;
    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] colors = getResources().getStringArray((R.array.color_array));
        final String[] hexes = getResources().getStringArray(R.array.color_hexes);

        paletteFragment = PaletteFragment.newInstance(colors, hexes);
        canvasFragment = CanvasFragment.newInstance();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.palette_layout, canvasFragment)
                .add(R.id.palette_layout, paletteFragment).commit();

    }

    @Override
    public void ColorSelected(String colorChosen) {
        canvasFragment.changeCanvasColor(colorChosen);
    }
}
