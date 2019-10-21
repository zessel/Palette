package edu.temple.palette;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteFragment extends Fragment {

    private String[] colors;
    private String[] hexes;

    private final static String COLOR_KEY = "colors";
    private final static String HEX_KEY = "hexes";

    private ColorSelectedInterface parentActivity;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ColorSelectedInterface)
            parentActivity = (ColorSelectedInterface) context;
        else
            throw new RuntimeException("Activity doesn't implement fragment interface");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_palette, container, false);


        Spinner spinner = fragmentView.findViewById(R.id.fragmentSpinner);
        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), colors, hexes);
        spinner.setAdapter(colorAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.ColorSelected(hexes[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return fragmentView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // What does this do?
        Bundle bundle = getArguments();
        if (bundle != null) {
            colors = bundle.getStringArray(COLOR_KEY);
            hexes = bundle.getStringArray(HEX_KEY);
        }
    }

    static PaletteFragment newInstance(String[] colors, String[] hexes) {
        PaletteFragment paletteFragment = new PaletteFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray(COLOR_KEY, colors);
        bundle.putStringArray(HEX_KEY, hexes);
        paletteFragment.setArguments(bundle);
        return paletteFragment;
    }

    public interface ColorSelectedInterface {
        void ColorSelected(String chosenColor);
    }
}
