package edu.temple.palette;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    private View view;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_canvas, container, false);
        return view;
    }

    static CanvasFragment newInstance()
    {
        return new CanvasFragment();
    }

    void changeCanvasColor(String hex_color)
    {
        view.setBackgroundColor(Color.parseColor(hex_color));
    }

}
