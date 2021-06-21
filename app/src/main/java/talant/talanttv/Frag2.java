package talant.talanttv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


public class Frag2 extends Fragment implements View.OnClickListener {

    Button homeB;
    Button searchB;
    Button backB;
    Button selectB;
    Button downB;
    Button leftB;
    Button rightB;
    Button upB;
    Button playB;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_2, container, false);

        homeB = root.findViewById(R.id.homeB);
        homeB.setOnClickListener(this);

        searchB = root.findViewById(R.id.searchB);
        searchB.setOnClickListener(this);

        backB = root.findViewById(R.id.backB);
        backB.setOnClickListener(this);

        upB = root.findViewById(R.id.upB);
        upB.setOnClickListener(this);

        downB = root.findViewById(R.id.downB);
        downB.setOnClickListener(this);

        leftB = root.findViewById(R.id.leftB);
        leftB.setOnClickListener(this);

        rightB = root.findViewById(R.id.rightB);
        rightB.setOnClickListener(this);

        selectB = root.findViewById(R.id.selectB);
        selectB.setOnClickListener(this);

        playB = root.findViewById(R.id.playB);
        playB.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        Button b = v.findViewById(v.getId());
        String btn_tag = b.getTag().toString();

        RemoteFunc.doCode(2, btn_tag);

    }
}