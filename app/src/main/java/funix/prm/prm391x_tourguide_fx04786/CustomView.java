package funix.prm.prm391x_tourguide_fx04786;

//Tạo đối tượng
public class CustomView {
    private String Name;//tên
    private String Address;//địa chỉ
    private int thumbnail;//hinh ảnh

    //Khởi tạo
    public CustomView(String name, String adress, int thumbnail) {
        Name = name;
        Address = adress;
        this.thumbnail = thumbnail;
    }

    //Set Get
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAdress() {
        return Address;
    }

    public void setAdress(String adress) {
        Address = adress;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
