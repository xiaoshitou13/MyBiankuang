package test.bwie.com.mybiankuang;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by 白玉春 on 2017/10/26.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void initLoader() {

        // 图片显示参数设置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                //.displayer(new RoundedBitmapDisplayer(360))//圆角问题：必须在xml里面指定具体大小
                //设置下载的图片是否缓存在内存中
                .cacheInMemory(true)// 内存缓存

                .cacheOnDisk(true)// 缓存磁盘
                .bitmapConfig(Bitmap.Config.ARGB_8888)  //图片解码类型
                .showImageOnLoading(R.mipmap.ic_launcher)// 设置图片在下载期间显示图
                .showImageOnFail(R.mipmap.ic_launcher)//  错误时 显示图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)// URI为空  是显示图片
                //图片二次采样
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
                //设置图片加入缓存前，对bitmap进行设置
                //.preProcessor(BitmapProcessor preProcessor)
                // 设置图片在下载前是否重置，复位
    //                .resetViewBeforeLoading(true)
                //是否为圆角 弧度为多少
                .displayer(new RoundedBitmapDisplayer(360))
                //是否图片加载好键入的动画时间
    //                .displayer(new FadeInBitmapDisplayer(100))
                .build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(
                this).defaultDisplayImageOptions(options)
                .diskCache(new UnlimitedDiskCache(Environment.getExternalStorageDirectory())) //设置自定义缓冲路径
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(configuration);

    }
}


