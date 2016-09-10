//package com.example.dllo.zaker.hotspot.tag;
//
//import android.content.res.Configuration;
//import android.graphics.Color;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.Bundle;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBarDrawerToggle;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.animation.AccelerateInterpolator;
//import android.widget.LinearLayout;
//
//import com.example.dllo.zaker.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.codetail.animation.SupportAnimator;
//import io.codetail.animation.ViewAnimationUtils;
//import yalantis.com.sidemenu.interfaces.Resourceble;
//import yalantis.com.sidemenu.interfaces.ScreenShotable;
//import yalantis.com.sidemenu.model.SlideMenuItem;
//import yalantis.com.sidemenu.util.ViewAnimator;
//
//
//public class HotspotTagActivity extends ActionBarActivity implements ViewAnimator.ViewAnimatorListener {
//    private DrawerLayout drawerLayout;
//    private ActionBarDrawerToggle drawerToggle;
//    private List<SlideMenuItem> list = new ArrayList<>();
//    private ContentFragment contentFragment;
//    private ViewAnimator viewAnimator;
//    private int res = R.mipmap.ic_launcher;
//    private LinearLayout linearLayout;
//
//    private String str = "akda";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hotspot_tag_sidemenu);
//        //初始化时候contentFragment里面显示的图片
//        contentFragment = ContentFragment.newInstance(R.mipmap.content_music,str);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.content_frame, contentFragment)
//                .commit();
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        //点击drawable图标的时候 另一半页面显示的颜色
//        drawerLayout.setScrimColor(Color.TRANSPARENT);
//
//        //菜单栏中的内容通过addViewToContainer回调的方式添加到left_drawer中
//        linearLayout = (LinearLayout) findViewById(R.id.left_drawer);
//        //左面弹出来的小图标的每个点击事件
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //点击的时候就让其消失掉
//                drawerLayout.closeDrawers();
//            }
//        });
//
//
//        setActionBar();
//        createMenuList();
//        //ViewAnimator类, 用于菜单内容的创建, 菜单显示时候的动画效果, 以及菜单项的点击反馈.
//        // contentFragment 为主体显示  继承自Fragment 并实现了ScreenShotable接口
//        // 最后一个参数为ViewAnimator.ViewAnimatorListener 接口,其中一个方法便是addViewToContainer
//        // 在ViewAnimator 中创建view 并添加到 linearLayout 菜单中.
//        viewAnimator = new ViewAnimator<>(this, list, contentFragment, drawerLayout, this);
//    }
//
//    private void createMenuList() {
//        SlideMenuItem menuItem0 = new SlideMenuItem(ContentFragment.CLOSE, R.mipmap.icn_close);
//        list.add(menuItem0);
//        SlideMenuItem menuItem = new SlideMenuItem(ContentFragment.BUILDING, R.mipmap.icn_1);
//        list.add(menuItem);
//        SlideMenuItem menuItem2 = new SlideMenuItem(ContentFragment.BOOK, R.mipmap.icn_2);
//        list.add(menuItem2);
////        SlideMenuItem menuItem3 = new SlideMenuItem(ContentFragment.PAINT, R.mipmap.icn_3);
////        list.add(menuItem3);
////        SlideMenuItem menuItem4 = new SlideMenuItem(ContentFragment.CASE, R.mipmap.icn_4);
////        list.add(menuItem4);
////        SlideMenuItem menuItem5 = new SlideMenuItem(ContentFragment.SHOP, R.mipmap.icn_5);
////        list.add(menuItem5);
////        SlideMenuItem menuItem6 = new SlideMenuItem(ContentFragment.PARTY, R.mipmap.icn_6);
////        list.add(menuItem6);
////        SlideMenuItem menuItem7 = new SlideMenuItem(ContentFragment.MOVIE, R.mipmap.icn_7);
////        list.add(menuItem7);
//    }
//
//    //设置actionBar
//    private void setActionBar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        //这个小于4.0版本是默认为true的。
//        // 该方法的作用：决定左上角的图标是否可以点击。没有向左的小图标
//        //true 图标可以点击  false 不可以点击
//        getSupportActionBar().setHomeButtonEnabled(true);
//        //决定左上角图标的右侧是否有向左的小箭头
//        // true 有小箭头，并且图标可以点击  false 没有小箭头，并且图标不可以点击
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        //ActionBarDrawerToggle是一个开关，用于打开/关闭DrawerLayout抽屉
//        // 是 DrawerLayout.DrawerListener实现。
//        //作用：
//        //1.改变android.R.id.home返回图标。
//        //2.Drawer拉出、隐藏，带有android.R.id.home动画效果。
//        //3.监听Drawer拉出、隐藏；
//        drawerToggle = new ActionBarDrawerToggle(
//                this,                  /* host Activity */
//                drawerLayout,         /* DrawerLayout object */
//                toolbar,  /* nav drawer icon to replace 'Up' caret */
//                R.string.drawer_open,  /* "open drawer" description */
//                R.string.drawer_close  /* "close drawer" description */
//        ) {
//
//            /** drawer的监听 */
//            /** Called when a drawer has settled in a completely closed state. */
//            public void onDrawerClosed(View view) {
//                super.onDrawerClosed(view);
//                linearLayout.removeAllViews();
//                linearLayout.invalidate();
//            }
//
//            // drawer滑动的回调
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                super.onDrawerSlide(drawerView, slideOffset);
//                if (slideOffset > 0.6 && linearLayout.getChildCount() == 0)
//                    viewAnimator.showMenuContent();
//            }
//
//            // 打开drawer
//
//            /** Called when a drawer has settled in a completely open state. */
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);//开关状态改为opened
//            }
//        };
//
//        //设置drawer的开关监听
//        drawerLayout.setDrawerListener(drawerToggle);
//    }
//
//    /**
//     * activity创建完成后
//     */
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        //该方法会自动和actionBar关联, 将开关的图片显示在了action上，如果不设置，也可以有抽屉的效果，不过是默认的图标
//        drawerToggle.syncState();
//    }
//
//    /**
//     * 设备配置改变时
//     */
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        drawerToggle.onConfigurationChanged(newConfig);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    /**
//     * 菜单键点击的事件处理
//     */
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (drawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    //视图切换动画实现
//    private ScreenShotable replaceFragment(ScreenShotable screenShotable, int topPosition) {
//        this.res = this.res == R.mipmap.ic_launcher ? R.mipmap.content_films : R.mipmap.ic_launcher;
//        this.str = this.str == "akda" ? "aaaaa" : "akda";
//        View view = findViewById(R.id.content_frame);
//        //创建圆形动画
//        int finalRadius = Math.max(view.getWidth(), view.getHeight());
//        //第一个参数view：是你要进行圆形缩放的 view；
//        // 第二和第三个参数：分别是开始缩放点的 x 和 y 坐标；
//        //第四和第五：分别是开始的半径和结束的半径。
//        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, topPosition, 0, finalRadius);
//        animator.setInterpolator(new AccelerateInterpolator());
//        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
////由于圆形动画是一点点的扩大的,其没有全部覆盖的部分应该为上一个视图的内容,
//// 因此我们需要将前面的视图截图保存下来,可将下面代码屏蔽可明白其意义.
//        findViewById(R.id.content_overlay).setBackgroundDrawable(new BitmapDrawable(getResources(), screenShotable.getBitmap()));
//        animator.start();
//        ContentFragment contentFragment = ContentFragment.newInstance(this.res,this.str);
//        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
//        return contentFragment;
//    }
//
//    //在MainActivity中设置了对ViewAnimator的监听,
//    // 而在ViewAnimator内部也关联上菜单点击的响应switchItem()
//
//    @Override
//    public ScreenShotable onSwitch(Resourceble slideMenuItem, ScreenShotable screenShotable, int position) {
//        switch (slideMenuItem.getName()) {
//            case ContentFragment.CLOSE:
//                return screenShotable;
//            default:
//                return replaceFragment(screenShotable, position);
//        }
//    }
//
//    @Override
//    public void disableHomeButton() {
//        getSupportActionBar().setHomeButtonEnabled(false);
//
//    }
//
//    @Override
//    public void enableHomeButton() {
//        getSupportActionBar().setHomeButtonEnabled(true);
//        drawerLayout.closeDrawers();
//
//    }
//
//    //添加到菜单的LinearLayout 中去
//    @Override
//    public void addViewToContainer(View view) {
//        linearLayout.addView(view);
//    }
//}
