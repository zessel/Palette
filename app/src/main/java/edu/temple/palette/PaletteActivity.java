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

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ColorSelectedInterface ,
        CanvasFragment.CanvasReturnInterface {

    //public static final String SELECTED_COLOR = "edu.temple.palette.MESSAGE";

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
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.palette_layout, paletteFragment).commit();

    }

    @Override
    public void ColorSelected(int position) {
        if (position != 0) {
            String[] hexes = getResources().getStringArray(R.array.color_hexes);
            canvasFragment = CanvasFragment.newInstance(hexes[position]);
            fragmentManager.beginTransaction().add(R.id.palette_layout, canvasFragment).commit();
        }
    }

    @Override
    public void CanvasReturn() {
        String[] hexes = getResources().getStringArray(R.array.color_array);
        String[] colors= getResources().getStringArray(R.array.color_hexes);
        fragmentManager.beginTransaction().detach(canvasFragment).commit();
    }
}
