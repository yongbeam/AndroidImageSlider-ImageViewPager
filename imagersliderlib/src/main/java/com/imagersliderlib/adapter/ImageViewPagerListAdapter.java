/**
 * Copyright 2015 LeeYongBeam( top6616@gmail.com )
 * https://github.com/yongbeam/AndroidImageSlider-ImageViewPager.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package com.imagersliderlib.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.imagersliderlib.R;
import java.util.ArrayList;

public class ImageViewPagerListAdapter extends BaseAdapter {
    private static ArrayList<String> mImages;
    private Context mContext;
    private LayoutInflater mInflater;

    // 스크롤 상태를 제어하기 위한 변수
    public Boolean touch_check = false;
    public int touch_item_postion_check = 0;

    /**
     * @param context
     * @param imgs
     */
    public ImageViewPagerListAdapter(Context context, ArrayList<String> imgs) {
        mImages = imgs;
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    public int getCount() {
        return mImages.size();
    }

    public Object getItem(int position) {
        return mImages.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adater_img_pager_list,null);
            holder = new ViewHolder();

            // 뷰초기화
            holder.iv_dummy = (RelativeLayout) convertView.findViewById(R.id.list_layout_text_view); // dummy
            holder.pager = (ViewPager) convertView.findViewById(R.id.img_viewpager_roomlist);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.pager.setAdapter(new ImagePagerAdapter(mContext ,mImages));

        holder.pager.setOffscreenPageLimit(3);
        holder.iv_dummy.setId(position);

        holder.iv_dummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext , "Click ID "+v.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        // 터치액션을 받는다, 만약 좌,우 스크롤액션이 없이 그냥 손을 땔경우 실행한다
        holder.pager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (touch_check == true) {
                        touch_check = false;
                    } else {
                        // 리스너를 강제 출력하는건 setId를 통해서 현재 선택판 Item의 id값을 얻기 위함
                        holder.iv_dummy.performClick();
                    }
                }
                return false;
            }
        });

        // 좌,우 스크롤 액션이 있으면 터치액션을 막고 이미지 스크롤만 한다
        holder.pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                if(touch_item_postion_check > 4){
                    touch_check = true;
                }
                touch_item_postion_check ++;
            }
            @Override
            public void onPageScrollStateChanged(int arg0) {
                if(arg0 == 0){
                    touch_check = false;
                }
            }
        });

        return convertView;
    }

    public ArrayList<String> getArrayList() {
        return mImages;
    }

    static class ViewHolder {
        RelativeLayout iv_dummy;
        ViewPager pager;
    }
}