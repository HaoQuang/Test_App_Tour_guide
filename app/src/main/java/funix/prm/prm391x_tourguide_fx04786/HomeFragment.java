package funix.prm.prm391x_tourguide_fx04786;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    //chứa fragment mặc định
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_main,container,false);

        return view;
    }
}
