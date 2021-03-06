package adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo001.R;

import java.util.List;

import model.NhanVien;

public class CustomListNhanVienAdapter extends BaseAdapter {

    private List<NhanVien> data;
    private Context context;

    public CustomListNhanVienAdapter(Context _context,List<NhanVien> _data){
        context = _context;
        data = _data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int _i, View _view, ViewGroup _viewGroup) {
        View view = _view;
        if (_view == null){
            view = View.inflate(_viewGroup.getContext(),
                    R.layout.layout_nhan_vien, null);
        }

        TextView maNV = (TextView) view.findViewById(R.id.textViewMaNhanVien);
        TextView hoTenNV = (TextView) view.findViewById(R.id.textViewHoTen);
        ImageView hinhAnh = (ImageView) view.findViewById(R.id.imageViewHinhAnh);

        NhanVien nv = (NhanVien) getItem(_i);

        int imgId = context.getResources()
                .getIdentifier(nv.getHinhAnh(),
                        "drawable",
                        context.getPackageName());

        maNV.setText(nv.getMaNhanVien());
        hoTenNV.setText(nv.getHoTen());
        hinhAnh.setImageResource(imgId);

        return view;
    }
}
