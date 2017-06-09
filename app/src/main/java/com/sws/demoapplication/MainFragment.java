package com.sws.demoapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private ViewPager pager;
    private ImageView firstDot;
    private ImageView secondDot;
    private ImageView thirdDot;
    private ImageView fourthDot;
    private ImageView fifthDot;
    private ViewPager viewPager;
    private TabLayout tablayout;
    private TutorialCustomPagerAdapter mCustomPagerAdapter;
    private int currentItem;
    private String tabTitles[] = new String[]{"Videos", "Images", "Milestone"};
    private int[] imageResId = {
            R.drawable.video,
            R.drawable.image,
            R.drawable.milestone
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, null, false);
        init(view);

        viewPager = (ViewPager) view.findViewById(R.id.pagerTabLayout);
        setupViewPager(viewPager);

        tablayout = (TabLayout) view.findViewById(R.id.appoint_tablayout);
        tablayout.setupWithViewPager(viewPager);

        setViewPager();
        setupTabIcons();
        return view;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new MyPostFragment());
        adapter.addFrag(new MyPostFragment());
        adapter.addFrag(new MyPostFragment());
        viewPager.setAdapter(adapter);
    }

    private void setupTabIcons() {


        TextView tabOne = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabOne.setText("VIDEOS");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.video, 0, 0);
        tablayout.getTabAt(0).setCustomView(tabOne);
        tablayout.getTabAt(0).select();
        if (tablayout.getTabAt(0).isSelected()) {
            setSelectedTab(0);
        }

        TextView tabTwo = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabTwo.setText("IMAGES");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.image, 0, 0);
        tablayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        tabThree.setText("MILESTONE");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.milestone, 0, 0);
        tablayout.getTabAt(2).setCustomView(tabThree);


        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setSelectedTab(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                setUnSelectedTab(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void setSelectedTab(int position) {
        TabLayout.Tab tab = tablayout.getTabAt(position);
        tab = tablayout.getTabAt(position);
        View view = tab.getCustomView();
        TextView txtCount = (TextView) view.findViewById(R.id.tab);
        txtCount.setTextColor(getResources().getColor(R.color.colorPrimary));
        switch (position) {
            case 0:
                txtCount.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_video, 0, 0);
                break;
            case 1:
                txtCount.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_image, 0, 0);
                break;
            case 2:
                txtCount.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.select_milestone, 0, 0);
                break;
        }


    }

    public void setUnSelectedTab(int position) {
        TabLayout.Tab tab = tablayout.getTabAt(position);
        tab = tablayout.getTabAt(position);
        View view = tab.getCustomView();
        TextView txtCount = (TextView) view.findViewById(R.id.tab);
        txtCount.setTextColor(Color.parseColor("#a1a1a1"));
        txtCount.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.milestone, 0, 0);
        switch (position) {
            case 0:
                txtCount.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.video, 0, 0);
                break;
            case 1:
                txtCount.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.image, 0, 0);
                break;
            case 2:
                txtCount.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.milestone, 0, 0);
                break;
        }
    }


    private void setViewPager() {

        mCustomPagerAdapter = new TutorialCustomPagerAdapter(getActivity());
        pager.setAdapter(mCustomPagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentItem = position;
                getSelectedPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void getSelectedPosition(int position) {
        if (position == 0) {
            firstDot.setSelected(true);
            secondDot.setSelected(false);
            thirdDot.setSelected(false);
            fourthDot.setSelected(false);
            fifthDot.setSelected(false);
        } else if (position == 1) {
            firstDot.setSelected(false);
            secondDot.setSelected(true);
            thirdDot.setSelected(false);
            fourthDot.setSelected(false);
            fifthDot.setSelected(false);
        } else if (position == 2) {
            firstDot.setSelected(false);
            secondDot.setSelected(false);
            thirdDot.setSelected(true);
            fourthDot.setSelected(false);
            fifthDot.setSelected(false);
        } else if (position == 3) {
            firstDot.setSelected(false);
            secondDot.setSelected(false);
            thirdDot.setSelected(false);
            fourthDot.setSelected(true);
            fifthDot.setSelected(false);
        } else if (position == 4) {
            firstDot.setSelected(false);
            secondDot.setSelected(false);
            thirdDot.setSelected(false);
            fourthDot.setSelected(false);
            fifthDot.setSelected(true);
        }
    }

    private void init(View view) {
        pager = (ViewPager) view.findViewById(R.id.pager);
        firstDot = (ImageView) view.findViewById(R.id.firstDot);
        firstDot.setSelected(true);
        secondDot = (ImageView) view.findViewById(R.id.secondDot);
        thirdDot = (ImageView) view.findViewById(R.id.thirdDot);
        fourthDot = (ImageView) view.findViewById(R.id.fourthDot);
        fifthDot = (ImageView) view.findViewById(R.id.fifthDot);


    }

    class TutorialCustomPagerAdapter extends PagerAdapter {

        private final Context context;
        LayoutInflater mLayoutInflater;

        int[] myImageList = new int[]{R.drawable.pexels_photo, R.drawable.pexels_photo, R.drawable.pexels_photo, R.drawable.pexels_photo, R.drawable.pexels_photo};

        public TutorialCustomPagerAdapter(Context applicationContext) {
            this.context = applicationContext;
            mLayoutInflater = (LayoutInflater) context.getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return myImageList.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            View view = mLayoutInflater.inflate(R.layout.login_tutorial_layout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.tutorialImage);

            imageView.setBackgroundResource(myImageList[position]);

            ((ViewPager) container).addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((FrameLayout) object);
        }

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }

    }
}
