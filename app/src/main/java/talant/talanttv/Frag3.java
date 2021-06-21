package talant.talanttv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Frag3 extends Fragment implements View.OnClickListener {

    Button virginB;
    Button freeviewB;
    Button rokuB;
    Button macB;

    RadioGroup rg;
    View root;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_3, container, false);

        virginB = root.findViewById(R.id.virginB);
        virginB.setOnClickListener(this);

        freeviewB = root.findViewById(R.id.freeviewB);
        freeviewB.setOnClickListener(this);

        rokuB = root.findViewById(R.id.rokuB);
        rokuB.setOnClickListener(this);

        macB = root.findViewById(R.id.macB);
        macB.setOnClickListener(this);

        rg = root.findViewById(R.id.RG);

        return root;
    }

    @Override
    public void onClick(View v) {
        Button b = v.findViewById(v.getId());
        String clickbtn_tag = b.getTag().toString();
        Button selectedradioButton = root.findViewById(rg.getCheckedRadioButtonId());
        String combined = selectedradioButton.getTag().toString() + "_" + clickbtn_tag;
        RemoteFunc.doCode(3, combined);
    }
}