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

public class BusFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ListView listViewMetro;
        View view = inflater.inflate(R.layout.bus_activity,container,false);
        listViewMetro = view.findViewById(R.id.list_view_bus);
        //Tạo mảng và thêm dữ liệu
        ArrayList<CustomView> arrayListBus = new ArrayList<>();
        CustomView customViewBus1 = new CustomView("Tuyến 01", "BX Gia Lâm - BX Yên Nghĩa",R.drawable.metro);
        CustomView customViewBus2 = new CustomView( "Tuyến 02", "Bác cổ - BX Yên Nghĩa",R.drawable.metro);
        CustomView customViewBus3 = new CustomView("Tuyến 03A", "BX Giáp Bát - BX Gia Lâm",R.drawable.metro);
        CustomView customViewBus4 = new CustomView( "Tuyến 03B", "Bx Giáp Bát - Vincom - Phúc Lợi",R.drawable.metro);
        CustomView customViewBus5 = new CustomView("Tuyến 04", "Long Biên - BX Nước Ngầm",R.drawable.metro);
        CustomView customViewBus6 = new CustomView( "Tuyến 05", "Linh Đàm - Phú Diễn",R.drawable.metro);
        CustomView customViewBus7 = new CustomView( "Tuyến 06", "BX. Giáp Bát - Phú Minh (Phú Xuyên)",R.drawable.metro);
        CustomView customViewBus8 = new CustomView( "Tuyến 07", "Cầu Giấy - Nội Bài",R.drawable.metro);
        CustomView customViewBus9 = new CustomView( "Tuyến 08", "Long Biên - Đông Mỹ",R.drawable.metro);
        arrayListBus.add(customViewBus1);
        arrayListBus.add(customViewBus2);
        arrayListBus.add(customViewBus3);
        arrayListBus.add(customViewBus4);
        arrayListBus.add(customViewBus5);
        arrayListBus.add(customViewBus6);
        arrayListBus.add(customViewBus7);
        arrayListBus.add(customViewBus8);
        arrayListBus.add(customViewBus9);
        //Tạo dapter và thêm dữ liệu cho adapter
        CustomAdapter customAdapterBus = new CustomAdapter(getActivity(),R.layout.custom_view_activity,arrayListBus);
        listViewMetro.setAdapter(customAdapterBus);
        //Xử lý sự kiện khi 1 item trong adapter click
        listViewMetro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Tìm kiếm thông tin trên bản đồ
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+arrayListBus.get(position).getName());
                //tạo intent mới để gọi UD Map
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                Toast.makeText(getActivity(),"Đang tìm "+arrayListBus.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
