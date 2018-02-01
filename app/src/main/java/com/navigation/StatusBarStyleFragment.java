package com.navigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.navigation.fragment.BarStyle;
import com.navigation.fragment.Style;

/**
 * Created by listen on 2018/1/13.
 */

public class StatusBarStyleFragment extends TestStatusBarFragment {

    private BarStyle barStyle = BarStyle.DarkContent;

    @Override
    protected BarStyle preferredStatusBarStyle() {
        return barStyle;
    }

    @Override
    protected int preferredStatusBarColor() {
        return Color.TRANSPARENT;
    }

    @Override
    protected void onCustomStyle(Style style) {
        super.onCustomStyle(style);
        style.setToolbarStyle(BarStyle.DarkContent);
        style.setToolbarBackgroundColor(Color.WHITE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setToolbarRightButton(null, "切换", true, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preferredStatusBarStyle() == BarStyle.DarkContent) {
                    barStyle = BarStyle.LightContent;
                } else {
                    barStyle = BarStyle.DarkContent;
                }
                setNeedsStatusBarAppearanceUpdate();
            }
        });

    }



}
