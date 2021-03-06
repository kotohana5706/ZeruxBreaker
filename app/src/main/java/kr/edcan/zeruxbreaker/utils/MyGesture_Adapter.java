package kr.edcan.zeruxbreaker.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.rey.material.widget.Switch;
import java.util.ArrayList;
import kr.edcan.zeruxbreaker.R;

/**
 * Created by kotohana5706 on 15. 7. 13.
 */
public class MyGesture_Adapter extends ArrayAdapter<MyGesture_Data> {
    // 레이아웃 XML을 읽어들이기 위한 객체
    private LayoutInflater mInflater;

    public MyGesture_Adapter(Context context, ArrayList<MyGesture_Data> object) {
        // 상위 클래스의 초기화 과정
        // context, 0, 자료구조
        super(context, 0, object);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // 보여지는 스타일을 자신이 만든 xml로 보이기 위한 구문
    @Override
    public View getView(int position, View v, ViewGroup parent) {
        View view = null;
        // 현재 리스트의 하나의 항목에 보일 컨트롤 얻기
        if (v == null) {
            // XML 레이아웃을 직접 읽어서 리스트뷰에 넣음
            view = mInflater.inflate(R.layout.my_gesture_listview_content, null);
        } else {
            view = v;
        }
        // 자료를 받는다.
        final MyGesture_Data data = this.getItem(position);
        if (data != null) {
            //화면 출력
            ImageView icon = (ImageView) view.findViewById(R.id.my_gesture_listview_icon);
            TextView title = (TextView) view.findViewById(R.id.my_gesture_listview_title);
            TextView description = (TextView)view.findViewById(R.id.my_gesture_listview_content);
            Switch enable = (Switch) view.findViewById(R.id.my_gesture_listview_switch);
            icon.setImageResource(data.getIcon());
            title.setText(data.getTitle());
            description.setText(data.getContent());
            enable.setChecked(data.getisEnabled());
        }
        return view;
    }
}
