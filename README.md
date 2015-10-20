# AndroidImageSlider-ImageViewPager
AndroidImageSlider ViewPagerList

<div style="width:100%;">
<img src="https://github.com/yongbeam/AndroidImageSlider-ImageViewPager/blob/master/sc1.png?raw=true" align="center" height="30%" width="30%" style="margin-left:20px;">
<img src="https://github.com/yongbeam/AndroidImageSlider-ImageViewPager/blob/master/sc2.png?raw=true" align="center" height="30%" width="30%" style="margin-left:20px;">
</div>

## Tutorial
Add the library to your project
```
compile project(':imagersliderlib')
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

## Author

 * 이용범(LeeYongBeam)
 * Mail: [ray@travelking.kr](mailto://ray@travelking.kr)
 * Web: [www.travelking.kr](http://www.travelking.kr)

## License
Apache License
