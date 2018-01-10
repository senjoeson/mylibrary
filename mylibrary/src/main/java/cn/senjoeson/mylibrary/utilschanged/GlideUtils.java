package cn.senjoeson.mylibrary.utilschanged;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import cn.senjoeson.mylibrary.R;

/**
 * @author senjoeson
 * @date 2018/1/8
 */

public class GlideUtils {
    public static void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).into(imageView);
    }

}
