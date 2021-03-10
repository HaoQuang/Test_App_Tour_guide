package funix.prm.prm391x_tourguide_fx04786;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

//Custom lại adapter để thêm vào listview
public class CustomAdapter extends ArrayAdapter<CustomView> {
    private Context context;
    private int resource;
    private ArrayList<CustomView> arrayListContact;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CustomView> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrayListContact = objects;
    }

    //ghi đè getView để đặt lại các thuộc tính
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_view_activity,parent,false);
        ImageView imageView = convertView.findViewById(R.id.image_custom);
        TextView textView1 = convertView.findViewById(R.id.text_view_custom_1);
        TextView textView2 = convertView.findViewById(R.id.text_view_custom_2);

        CustomView customView = arrayListContact.get(position);
        imageView.setImageResource(customView.getThumbnail());
        textView1.setText(customView.getName());
        textView2.setText(customView.getAdress());
        return convertView;
    }
}
