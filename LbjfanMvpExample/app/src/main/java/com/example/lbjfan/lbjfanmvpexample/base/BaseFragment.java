package com.example.lbjfan.lbjfanmvpexample.base;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class BaseFragment extends Fragment {

    public static <T extends BaseFragment> T getInstance(T T, int position, SparseArray object) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        if(object!=null){
            bundle.putParcelable("object", (Parcelable) object);
        }
        T.setArguments(bundle);
        return T;
    }

}
