package edu.temple.palette;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    private final static String HEX_CHOSEN_KEY = "hexChosen";

    private String hexChosen;

    CanvasReturnInterface fragmentParent;
    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof CanvasReturnInterface)
            fragmentParent = (CanvasReturnInterface) context;

        else
            throw new RuntimeException("Didn't implement CanvasReturnInterface");
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // What does this do?
        Bundle bundle = getArguments();
        if (bundle != null) {
            hexChosen = bundle.getString(HEX_CHOSEN_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_canvas, container, false);

        view.setBackgroundColor(Color.parseColor(hexChosen));

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentParent.CanvasReturn();
            }
        });

        return view;
    }

    public static CanvasFragment newInstance(String hexChosen)
    {
        CanvasFragment canvasFragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putString(HEX_CHOSEN_KEY, hexChosen);
        canvasFragment.setArguments(bundle);
        return canvasFragment;
    }

    public interface CanvasReturnInterface
    {
        void CanvasReturn();
    }
}
