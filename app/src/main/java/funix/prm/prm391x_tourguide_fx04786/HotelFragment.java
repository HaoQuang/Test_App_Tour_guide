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

public class HotelFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ListView listViewHotel;
        View view =inflater.inflate(R.layout.hotel_activity,container,false);
        //Tạo mảng và thêm dữ liệu
        listViewHotel = view.findViewById(R.id.list_view_hotel);
        ArrayList<CustomView> arrayListHotel = new ArrayList<>();
        CustomView customViewHotel1 = new CustomView("The Queen Hotel & Spa", "67 Thuốc Bắc, Hàng Bồ, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam",R.drawable.hotel);
        CustomView customViewHotel2 = new CustomView("Hanoi Nostalgia Hotel & Spa", "13-15 Luong Ngoc Quyen, Hang Buom, Hoan Kiem, Hàng Buồm, Quận Hoàn Kiếm, Hà Nội, Việt Nam",R.drawable.hotel);
        CustomView customViewHotel3 = new CustomView("Church Legend Hotel Hanoi", "46 Ấu Triệu, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam",R.drawable.hotel);
        CustomView customViewHotel4 = new CustomView("Little Hanoi Diamond Hotel", "11 Bát Đàn, Quận Hoàn Kiếm, Hàng Bồ, Quận Hoàn Kiếm, Hà Nội, Việt Nam",R.drawable.hotel);
        CustomView customViewHotel5 = new CustomView("Flamingo Dai Lai Resort", "Thôn Ngọc Quang, Xã Ngọc Thanh, Vĩnh Phúc, Phúc Yên, Hà Nội, Việt Nam",R.drawable.hotel);
        CustomView customViewHotel6 = new CustomView("Annam Legend Hotel", "27 Hàng Bè, Hàng Bạc, Quận Hoàn Kiếm, Hà Nội, Việt Nam",R.drawable.hotel);
        CustomView customViewHotel7 = new CustomView("Hanoi Zesty Hotel", "20 Hàng Cân, Hàng Đào, Quận Hoàn Kiếm, Hà Nội, Việt Nam",R.drawable.hotel);
        CustomView customViewHotel8 = new CustomView("Bluebell Hotel", "41 Ngõ Huyện, Phường Hàng Trống, Quận Hoàn Kiếm, Hà Nội, Việt Nam",R.drawable.hotel);

        arrayListHotel.add(customViewHotel1);
        arrayListHotel.add(customViewHotel2);
        arrayListHotel.add(customViewHotel3);
        arrayListHotel.add(customViewHotel4);
        arrayListHotel.add(customViewHotel5);
        arrayListHotel.add(customViewHotel6);
        arrayListHotel.add(customViewHotel7);
        arrayListHotel.add(customViewHotel8);

        //Tạo dapter và thêm dữ liệu cho adapter
        CustomAdapter customAdapterHotel = new CustomAdapter(getActivity(),R.layout.custom_view_activity,arrayListHotel);
        listViewHotel.setAdapter(customAdapterHotel);

        //Xử lý sự kiện khi 1 item trong adapter click
        listViewHotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Tìm kiếm thông tin trên bản đồ
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+arrayListHotel.get(position).getName());
                //tạo intent mới để gọi UD Map
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                Toast.makeText(getActivity(),"Đang tìm "+arrayListHotel.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
