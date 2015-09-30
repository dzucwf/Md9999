package com.md9999.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.md9999.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDoctorFragment extends Fragment {


    public MyDoctorFragment() {
        // Required empty public constructor
    }

    private List<Map<String, Object>> data;

    @ViewInject(R.id.myDoctorFragment_listView)
    public ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewUtils.inject(this.getActivity());

        data = getData();
        MyAdapter adapter = new MyAdapter(this.getActivity());
        //listView = (ListView) this.getActivity().findViewById(R.id.myDoctorFragment_listView);
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_doctor, container, false);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<String, Object>();
            map.put("dr_photo", R.drawable.photo_default_doctor);
            map.put("dr_name", "伍文一");
            map.put("dr_title", "主治医师");
            map.put("hospital", "山东眼科医院");
            map.put("department", "眼科");
            list.add(map);
        }
        return list;
    }

    private static class ViewHolder {
        public ImageView dr_photo;
        public TextView dr_name;
        public TextView dr_title;
        public TextView hospital;
        public TextView department;
    }

    private class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater = null;

        private MyAdapter(Context context) {
            //根据context上下文加载布局，这里的是Demo17Activity本身，即this
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            //How many items are in the data set represented by this Adapter.
            //在此适配器中所代表的数据集中的条目数
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            // Get the data item associated with the specified position in the data set.
            //获取数据集中与指定索引对应的数据项
            return position;
        }

        @Override
        public long getItemId(int position) {
            //Get the row id associated with the specified position in the list.
            //获取在列表中与指定索引对应的行id
            return position;
        }

        //Get a View that displays the data at the specified position in the data set.
        //获取一个在数据集中指定索引的视图来显示数据
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            //如果缓存convertView为空，则需要创建View
            if (convertView == null) {
                holder = new ViewHolder();
                //根据自定义的Item布局加载布局
                convertView = mInflater.inflate(R.layout.mydoctor_list_item, null);
                holder.dr_photo = (ImageView) convertView.findViewById(R.id.myDoctor_fragment_listItem_dr_photo);
                holder.dr_name = (TextView) convertView.findViewById(R.id.myDoctor_fragment_listItem_dr_name);
                holder.dr_title = (TextView) convertView.findViewById(R.id.myDoctor_fragment_listItem_dr_title);
                holder.hospital = (TextView) convertView.findViewById(R.id.myDoctor_fragment_listItem_dr_hospital);
                holder.department = (TextView) convertView.findViewById(R.id.myDoctor_fragment_listItem_dr_department);

                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.dr_photo.setBackgroundResource((Integer) data.get(position).get("dr_photo"));
            holder.dr_name.setText((String) data.get(position).get("dr_name"));
            holder.dr_title.setText((String) data.get(position).get("dr_title"));
            holder.hospital.setText((String) data.get(position).get("hospital"));
            holder.department.setText((String) data.get(position).get("department"));

            return convertView;
        }

    }
}
