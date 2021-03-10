package funix.prm.prm391x_tourguide_fx04786;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Cac the thong tin
    CardView cardViewAtm, cardViewHotel, cardViewHospital, cardViewBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_manager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#D3481D")));
        //Goi findViewById
        findView();
        //xu ly su kien click khi cac the duoc chon
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=null;
                if (v == cardViewAtm) {
                    fragment = new ATMFragment();
                    getSupportActionBar().setTitle("ATM");
                } else if (v==cardViewBus) {
                    fragment = new BusFragment();
                    getSupportActionBar().setTitle("Xe Bus");
                } else if (v==cardViewHospital) {
                    fragment = new HospitalFragment();
                    getSupportActionBar().setTitle("Bệnh Viện");
                } else if (v==cardViewHotel){
                    fragment = new HotelFragment();
                    getSupportActionBar().setTitle("Khách sạn");
                }
                //xu ly Fragment
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_manager, fragment);
                //Backstack
                fragmentTransaction.addToBackStack("backAtm");
                fragmentTransaction.commit();
            }
        };
        //Set onclick listener
        cardViewAtm.setOnClickListener(onClickListener);
        cardViewHotel.setOnClickListener(onClickListener);
        cardViewHospital.setOnClickListener(onClickListener);
        cardViewBus.setOnClickListener(onClickListener);

    }
    public void findView () {
        cardViewAtm = findViewById(R.id.card_atm);
        cardViewBus = findViewById(R.id.card_bus);
        cardViewHospital = findViewById(R.id.card_hospital);
        cardViewHotel = findViewById(R.id.card_hotel);
    }

    //Dat lai tieu de
    public void onBackPressed() {
        getSupportActionBar().setTitle("Tour Guide App");
        super.onBackPressed();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        getSupportActionBar().setTitle("Tour Guide App");
        return super.onOptionsItemSelected(item);
    }

    /*//Hàm hiển thị dialog
    public void showDialog() {
        //Đặt nội dung và bắt sự kiện click
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn muốn thoát ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //click vào nút back
                //onBackPressed();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //bỏ qua hộp thoại
                dialog.dismiss();
            }
        });
        //tạo và hiện dialog
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }*/

}