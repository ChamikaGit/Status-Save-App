package com.cd.statussaver.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.cd.statussaver.R;
import com.cd.statussaver.activity.FullHomeViewActivity;
import com.cd.statussaver.activity.FullViewActivity;
import com.cd.statussaver.activity.VideoPlayerActivity;
import com.cd.statussaver.model.WhatsappStatusModel;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;

import static com.cd.statussaver.util.Utils.shareImage;
import static com.cd.statussaver.util.Utils.shareVideo;


public class ShowHomeImagesAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<WhatsappStatusModel> imageList;
    private LayoutInflater inflater;
    FullHomeViewActivity fullViewActivity;

    public ShowHomeImagesAdapter(Context context, ArrayList<WhatsappStatusModel> imageList, FullHomeViewActivity fullViewActivity) {
        this.context = context;
        this.imageList = imageList;
        this.fullViewActivity=fullViewActivity;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NotNull Object object) {
        container.removeView((View) object);
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

        assert imageLayout != null;
        final ImageView imageView = imageLayout.findViewById(R.id.im_fullViewImage);
        final ImageView im_vpPlay = imageLayout.findViewById(R.id.im_vpPlay);
        final ImageView im_share = imageLayout.findViewById(R.id.im_share);
        final ImageView im_delete = imageLayout.findViewById(R.id.im_delete);


        Glide.with(context).load(imageList.get(position).getPath()).into(imageView);
        view.addView(imageLayout, 0);
//        String extension = imageList.get(position).getName().substring(imageList.get(position).getName().lastIndexOf("."));
        boolean extension = imageList.get(position).getUriString().contains(".mp4");
        if (extension){
            im_vpPlay.setVisibility(View.VISIBLE);
        }else {
            im_vpPlay.setVisibility(View.GONE);
        }

        im_vpPlay.setOnClickListener(v -> {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setDataAndType(Uri.parse(imageList.get(position).getPath()), "video/*");
//            context.startActivity(intent);
            Intent intent1 = new Intent(context, VideoPlayerActivity.class);
            intent1.putExtra("file",imageList.get(position).getPath());
            context.startActivity(intent1);
        });

//        im_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean b=imageList.get(position).delete();
//                if (b){
//                    fullViewActivity.deleteFileAA(position);
//                }
//            }
//        });

//        im_share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String extension = imageList.get(position).getName().substring(imageList.get(position).getName().lastIndexOf("."));
//                if (extension.equals(".mp4")){
//                    shareVideo(context,imageList.get(position).getPath());
//                }else {
//                    shareImage(context,imageList.get(position).getPath());
//                }
//            }
//        });


        return imageLayout;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, @NotNull Object object) {
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