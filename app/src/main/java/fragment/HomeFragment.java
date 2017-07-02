package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.chen.havefun.R;


/**
 * Created by Cl on 2016.9.17
 * . my first android
 */
public class HomeFragment extends Fragment {

    private SliderLayout mSliderLayout;
//    private PagerIndicator Indicator;
   /* private RecyclerView mRecyclerView;

    private HomeCatgoryAdapter mAdapter;

    private static final String TAG = "HomeFragment";

*/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mSliderLayout = (SliderLayout) view.findViewById(R.id.slider);

//   Indicator = (PagerIndicator) view.findViewById(R.id.custom_indicator);

        initSlider();

        return view;
    }

    private void initSlider() {
        TextSliderView textSliderView = new TextSliderView(this.getActivity());
        textSliderView
                .description("图文信息中心")
                .image("http://imgsrc.baidu.com/forum/pic/item/f346ccb8fc259ebc8f1029fa.jpg");
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"图书馆 ", Toast.LENGTH_LONG).show();
            }
        });

        TextSliderView textSliderView2 = new TextSliderView(this.getActivity());
        textSliderView2
                .description("学生宿舍")
                .image("http://img.pconline.com.cn/images/photoblog/7/2/5/4/7254666/200812/10/1228924616742_mthumb.jpg");
        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"宿舍 ", Toast.LENGTH_LONG).show();
            }
        });

        TextSliderView textSliderView3 = new TextSliderView(this.getActivity());
        textSliderView3
                .description("俯瞰师大")
                .image("http://p.img.eol.cn/images/1022/2013/1224/1387883813_12_a420.jpg");
        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"学校 ", Toast.LENGTH_LONG).show();
            }
        });

        TextSliderView textSliderView4 = new TextSliderView(this.getActivity());
        textSliderView4
                .description("正大柱")
                .image("http://imgsrc.baidu.com/forum/w%3D580/sign=d6ad5704928fa0ec7fc764051697594a/445d738da977391207661056fb198618367ae220.jpg");
        textSliderView4.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"广场 ", Toast.LENGTH_LONG).show();
            }
        });

        TextSliderView textSliderView5 = new TextSliderView(this.getActivity());
        textSliderView5
                .description("小杏林")
                .image("http://img.pconline.com.cn/images/photoblog/7/2/5/4/7254666/200812/10/1228924616736_mthumb.jpg");
        textSliderView5.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getActivity(),"花园 ", Toast.LENGTH_LONG).show();
            }
        });

        mSliderLayout.addSlider(textSliderView);
        mSliderLayout.addSlider(textSliderView2);
        mSliderLayout.addSlider(textSliderView3);
        mSliderLayout.addSlider(textSliderView4);
        mSliderLayout.addSlider(textSliderView5);
//默认的indicator
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

//        添加自定义的indi
// cator
//        mSliderLayout.setCustomIndicator(Indicator);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        mSliderLayout.setDuration(3000);


        mSliderLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            public String TAG;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d(TAG,"onPageScrolled");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG,"OnPageSelected");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(TAG," onPageScrollStateChanged");
            }
        });

    }




    public void onDestroy() {
        super.onDestroy();

        mSliderLayout.stopAutoCycle();
    }
}