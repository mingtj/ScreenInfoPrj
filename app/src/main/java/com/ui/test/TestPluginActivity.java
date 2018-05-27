package com.ui.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ui.R;
import com.ui.view.ScrollAlwaysTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mingtingjie on 18/5/12.
 */

public class TestPluginActivity extends Activity {


    @BindView(R.id.introduce)
    TextView introduce;
    @BindView(R.id.screen_density)
    TextView screenDensity;
    @BindView(R.id.screen_density_dpi)
    TextView screenDensityDpi;
    @BindView(R.id.screen_width)
    TextView screenWidth;
    @BindView(R.id.screen_height)
    TextView screenHeight;
    @BindView(R.id.screen_width_height)
    TextView screenWidthHeight;
    @BindView(R.id.test_timer)
    TextView testTimer;
    @BindView(R.id.scolltext)
    ScrollAlwaysTextView scolltext;
    @BindView(R.id.share_to_wx)
    Button shareToWx;
    @BindView(R.id.share_to_wxf)
    Button shareToWxf;
    @BindView(R.id.login_wx)
    Button loginWx;
    @BindView(R.id.test_img)
    ImageView testImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.share_to_wx, R.id.share_to_wxf, R.id.login_wx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.share_to_wx:
                break;
            case R.id.share_to_wxf:
                break;
            case R.id.login_wx:
                break;
        }
    }
}
