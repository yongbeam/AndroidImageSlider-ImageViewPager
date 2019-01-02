# DEPRECATED PROJECT
더이상 업데이트를 제공하지 않습니다.
최신 안드로이드 가이드를 통하면 손쉽게 구현할 수 있습니다. 이 프로젝트는 더이상 참고하지 말아주세요


# AndroidImageSlider-ImageViewPager
AndroidImageSlider ViewPagerList

<div style="width:100%;">
<img src="https://github.com/yongbeam/AndroidImageSlider-ImageViewPager/blob/master/sc1.png?raw=true" align="center" height="30%" width="30%" style="margin-left:20px;">
<img src="https://github.com/yongbeam/AndroidImageSlider-ImageViewPager/blob/master/sc2.png?raw=true" align="center" height="30%" width="30%" style="margin-left:20px;">
</div>

## Tutorial
Add the library to your project
```
dependencies {
     compile 'com.imagersliderlib:AndroidImageSlider-ImageViewPager:0.1.0'
}
```

add images
```
import com.imagersliderlib.adapter.ImageViewPagerListAdapter;

ImageViewPagerListAdapter Adapter;
Adapter = new ImageViewPagerListAdapter(this , ArrayList<String> images);
```

touch action
```
mylistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
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
```

## License
    Copyright (c) 2016 LeeYongBeom

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    Come on, don't tell me you read that.
