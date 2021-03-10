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

public class HospitalFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ListView listViewhospital;
        View view =inflater.inflate(R.layout.hospital_activity,container,false);
        listViewhospital = view.findViewById(R.id.list_view_hospital);
        //Tạo mảng và thêm dữ liệu
        ArrayList<CustomView> arrayListHospital = new ArrayList<>();
        CustomView customViewHospital1 = new CustomView("Bệnh viện Bạch Mai", "78 – Đường Giải Phóng – Phương Mai – Đống Đa – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital2 = new CustomView("Bệnh Viện Hữu Nghị", "Số 1 – Trần Khánh Dư – Quận Hai Bà Trưng – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital3 = new CustomView("Bệnh Viện E, Hà Nội", "89 – Trần Cung – Nghĩa Tân – Cầu Giấy – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital4 = new CustomView("Viện Răng Hàm Mặt", "40B – Tràng Thi – Hoàn Kiếm – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital5 = new CustomView("Bệnh Viện Tai Mũi Họng Trung Ương", "78 – Đường Giải Phóng – Quận Đống Đa – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital6 = new CustomView("Bệnh Viện Mắt Trung Ương", "85 – Phố Bà Triệu – Quận Hai Bà Trưng – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital7 = new CustomView("Viện Y Học Cổ Truyền Trung Ương", "29 – Phố Nguyễn Bỉnh Khiêm – Quận Hai Bà Trưng – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital8 = new CustomView("Bệnh Viện Nội Tiết", "80 – Thái Thịnh II – Thịnh Quang – Đống Đa – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital9 = new CustomView("Bệnh Viện Việt Đức", "8 – Phố Phủ Doãn – Quận Hoàn Kiếm – Hà Nội",R.drawable.hospital);
        CustomView customViewHospital10 = new CustomView("Bệnh Viện Nhi Trung Ương", "18/879 – Đường La Thành – Quận Đống Đa – Hà Nội",R.drawable.hospital);
        arrayListHospital.add(customViewHospital1);
        arrayListHospital.add(customViewHospital2);
        arrayListHospital.add(customViewHospital3);
        arrayListHospital.add(customViewHospital4);
        arrayListHospital.add(customViewHospital5);
        arrayListHospital.add(customViewHospital6);
        arrayListHospital.add(customViewHospital7);
        arrayListHospital.add(customViewHospital8);
        arrayListHospital.add(customViewHospital9);
        arrayListHospital.add(customViewHospital10);
        //Tạo dapter và thêm dữ liệu cho adapter
        CustomAdapter customAdapterHospital = new CustomAdapter(getActivity(),R.layout.custom_view_activity,arrayListHospital);
        listViewhospital.setAdapter(customAdapterHospital);
        //Xử lý sự kiện khi 1 item trong adapter click
        listViewhospital.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Tìm kiếm thông tin trên bản đồ
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+arrayListHospital.get(position).getName());
                //tạo intent mới để gọi UD Map
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                Toast.makeText(getActivity(),"Đang tìm "+arrayListHospital.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
