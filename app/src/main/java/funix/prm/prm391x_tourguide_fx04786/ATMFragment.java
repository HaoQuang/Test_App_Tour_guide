package funix.prm.prm391x_tourguide_fx04786;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class ATMFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ListView listViewAtm;
        View view =inflater.inflate(R.layout.atm_activity,container,false);
        listViewAtm = view.findViewById(R.id.list_view_atm);
        //Tạo mảng và thêm dữ liệu
        ArrayList<CustomView> arrayListAtm = new ArrayList<>();
        CustomView customViewAtm1 = new CustomView("ATM Hoàn Kiếm", "17 phố Lý Thường Kiệt, Phường Phan Chu Trinh, Quận Hoàn Kiếm, Hà Nội",R.drawable.atm_machine);
        CustomView customViewAtm2 = new CustomView("ATM Đinh Tiên Hoàng", "7 Đinh Tiên Hoàng, Quận Hoàn Kiếm, Hà Nội",R.drawable.atm_machine);
        CustomView customViewAtm3 = new CustomView("ATM Hội sở", "57 Lý Thường Kiệt, Quận Hoàn Kiếm, Hà Nội",R.drawable.atm_machine);
        CustomView customViewAtm4 = new CustomView("ATM Nam Hà Nội", "236 Lê Thanh Nghị, Quận Hai Bà Trưng, Hà Nội",R.drawable.atm_machine);
        CustomView customViewAtm5 = new CustomView("ATM Hai Bà Trưng","300-302 Trần Khát Chân, Quận Hai Bà Trưng, Hà Nội",R.drawable.atm_machine);
        CustomView customViewAtm6 = new CustomView("ATM Lê Ngọc Hân", "44 Lê Ngọc Hân, Quận Hai Bà Trưng, Hà Nội",R.drawable.atm_machine);
        CustomView customViewAtm7 = new CustomView("ATM Thăng Long", "129-131 Hoàng Quốc Việt, Quận Cầu Giấy, Hà Nội",R.drawable.atm_machine);
        CustomView customViewAtm8 = new CustomView("ATM Phạm Hùng", "Tòa nhà FPT Phạm Hùng, Quận Cầu Giấy, Hà Nội",R.drawable.atm_machine);
        CustomView customViewAtm9 = new CustomView("ATM Khâm Thiên","158 Khâm Thiên, Quận Đống Đa, Hà Nội",R.drawable.atm_machine);
        arrayListAtm.add(customViewAtm1);
        arrayListAtm.add(customViewAtm2);
        arrayListAtm.add(customViewAtm3);
        arrayListAtm.add(customViewAtm4);
        arrayListAtm.add(customViewAtm5);
        arrayListAtm.add(customViewAtm6);
        arrayListAtm.add(customViewAtm7);
        arrayListAtm.add(customViewAtm8);
        arrayListAtm.add(customViewAtm9);
        //Tạo dapter và thêm dữ liệu cho adapter
        CustomAdapter customAdapterAtm = new CustomAdapter(getActivity(),R.layout.custom_view_activity,arrayListAtm);
        listViewAtm.setAdapter(customAdapterAtm);
        //Xử lý sự kiện khi 1 item trong adapter click
        listViewAtm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Tìm kiếm thông tin trên bản đồ
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+arrayListAtm.get(position).getName());
                //tạo intent mới để gọi UD Map
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                Toast.makeText(getActivity(),"Đang tìm "+arrayListAtm.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
