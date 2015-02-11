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

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.imagersliderlib.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class ImagePagerAdapter extends PagerAdapter {
    private ArrayList<String> mImages;
    private LayoutInflater inflater;
    private Context mContext;

    // ImageLoader
    private ImageLoader imageLoader;
    private DisplayImageOptions options;

    public ImagePagerAdapter(Context context , ArrayList<String> images) {
        mImages = new ArrayList<String>();
        mImages = images;
        inflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.image_pager_layout, view, false);
        assert imageLayout != null;
        ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);

        // image loding progressbar
		final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);

        // image scale set
        imageView.setScaleType(ScaleType.FIT_XY);

        // init ImageLoader
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(mContext));

        // ImageLoader set option
        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(new ColorDrawable(0xff6e6e6e))
                .showImageOnFail(new ColorDrawable(0xff6e6e6e))
                .showImageOnLoading(new ColorDrawable(0xff6e6e6e))
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        imageLoader.displayImage(mImages.get(position), imageView, options, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
				spinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
				String message = null;
                switch (failReason.getType()) {
                    case IO_ERROR:
						message = "Input/Output error";
                        break;
                    case DECODING_ERROR:
						message = "Image can't be decoded";
                        break;
                    case NETWORK_DENIED:
						message = "Downloads are denied";
                        break;
                    case OUT_OF_MEMORY:
						message = "Out Of Memory error";
                        break;
                    case UNKNOWN:
						message = "Unknown error";
                        break;
                }
				Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

				spinner.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
				spinner.setVisibility(View.GONE);
            }
        });

        view.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}