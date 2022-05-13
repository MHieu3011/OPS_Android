package com.ptit.ops.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ptit.ops.fragment.CustomerFragment;
import com.ptit.ops.fragment.OrderFragment;
import com.ptit.ops.fragment.ProductFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new OrderFragment();
            case 2:
                return new ProductFragment();
            default:
                return new CustomerFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
