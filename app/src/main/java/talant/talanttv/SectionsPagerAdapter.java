package talant.talanttv;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class SectionsPagerAdapter extends FragmentStateAdapter {

    public SectionsPagerAdapter(FragmentActivity fa, FragmentManager supportFragmentManager) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0 :
                fragment = new Frag1();
                break;

            case 1 :
                fragment = new Frag2();
                break;

            case 2 :
                fragment = new Frag3();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}