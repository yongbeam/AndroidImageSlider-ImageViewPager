package com.sample.imageslider;
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

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import com.imagersliderlib.adapter.ImageViewPagerListAdapter;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private ImageViewPagerListAdapter Adapter;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dummy data
        ArrayList<String> imgs = new ArrayList<String>();
        imgs.add("http://www.subi.biz/bbs/data/board/photo/file/1/66a4790d_teakse_49.jpg");
        imgs.add("http://40.media.tumblr.com/6f71efbd705c629d95a553ecf212ccd6/tumblr_njkqkwEXkO1slhhf0o1_1280.jpg");
        imgs.add("http://40.media.tumblr.com/089cd5dafe9eeb4ffdf3f73e34323012/tumblr_nimfq02tw41slhhf0o1_1280.jpg");
        imgs.add("http://41.media.tumblr.com/fb9eea71d9f6f3d0788b049b6786f78d/tumblr_nj555tpbQl1slhhf0o1_1280.jpg");
        imgs.add("http://40.media.tumblr.com/30cc580e150bbe5f189f4b47fe9c9973/tumblr_niw37zopZ51slhhf0o1_1280.jpg");
        imgs.add("http://www.subi.biz/bbs/data/board/photo/file/1/66a4790d_teakse_49.jpg");
        imgs.add("http://40.media.tumblr.com/6f71efbd705c629d95a553ecf212ccd6/tumblr_njkqkwEXkO1slhhf0o1_1280.jpg");
        imgs.add("http://40.media.tumblr.com/089cd5dafe9eeb4ffdf3f73e34323012/tumblr_nimfq02tw41slhhf0o1_1280.jpg");
        imgs.add("http://41.media.tumblr.com/fb9eea71d9f6f3d0788b049b6786f78d/tumblr_nj555tpbQl1slhhf0o1_1280.jpg");
        imgs.add("http://40.media.tumblr.com/30cc580e150bbe5f189f4b47fe9c9973/tumblr_niw37zopZ51slhhf0o1_1280.jpg");
        imgs.add("http://www.subi.biz/bbs/data/board/photo/file/1/66a4790d_teakse_49.jpg");
        imgs.add("http://40.media.tumblr.com/6f71efbd705c629d95a553ecf212ccd6/tumblr_njkqkwEXkO1slhhf0o1_1280.jpg");
        imgs.add("http://40.media.tumblr.com/089cd5dafe9eeb4ffdf3f73e34323012/tumblr_nimfq02tw41slhhf0o1_1280.jpg");
        imgs.add("http://41.media.tumblr.com/fb9eea71d9f6f3d0788b049b6786f78d/tumblr_nj555tpbQl1slhhf0o1_1280.jpg");
        imgs.add("http://40.media.tumblr.com/30cc580e150bbe5f189f4b47fe9c9973/tumblr_niw37zopZ51slhhf0o1_1280.jpg");
        imgs.add("http://www.subi.biz/bbs/data/board/photo/file/1/66a4790d_teakse_49.jpg");
        imgs.add("http://40.media.tumblr.com/6f71efbd705c629d95a553ecf212ccd6/tumblr_njkqkwEXkO1slhhf0o1_1280.jpg");
        imgs.add("http://40.media.tumblr.com/089cd5dafe9eeb4ffdf3f73e34323012/tumblr_nimfq02tw41slhhf0o1_1280.jpg");
        imgs.add("http://41.media.tumblr.com/fb9eea71d9f6f3d0788b049b6786f78d/tumblr_nj555tpbQl1slhhf0o1_1280.jpg");
        imgs.add("http://40.media.tumblr.com/30cc580e150bbe5f189f4b47fe9c9973/tumblr_niw37zopZ51slhhf0o1_1280.jpg");

        Adapter = new ImageViewPagerListAdapter(this , imgs);
        lv1 = (ListView) findViewById(R.id.lv1);
        lv1.setAdapter(Adapter);

        lv1.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // 리스트뷰 스크롤시 다른 스크롤을 막기 위한 처리
                // 스크롤중일땐 플레그를 주고 스크롤이 끝나면 다시 초기화 한다
                Adapter.touch_check = true;
                if (scrollState == 1) {
                    Adapter.touch_check = true;
                }
                if (scrollState == 0) {
                    Adapter.touch_check = false;
                }
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
