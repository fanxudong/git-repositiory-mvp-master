package com.example.lbjfan.lbjfanmvpexample.ui.picture.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lbjfan.lbjfanmvpexample.R;
import com.example.lbjfan.lbjfanmvpexample.base.BaseFragment;
import com.example.lbjfan.lbjfanmvpexample.modle.NewsBean;
import com.example.lbjfan.lbjfanmvpexample.ui.picture.adapter.PictureRecyclerAdapter;
import com.example.lbjfan.lbjfanmvpexample.view.FullBottomRecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ${lbjfan} on 16-10-19.
 */
public class PictureFragment extends BaseFragment implements PictureFragmentContract.PictureView {

    private View rootView;
    @Bind(R.id.recyclerView)
    FullBottomRecyclerView recyclerView;

    private PictureRecyclerAdapter adapter;
    private PicturePresent picturePresent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.frag_main_picture, null);
        ButterKnife.bind(this, rootView);
        initWidget();
        return rootView;
    }

    @Override
    public void initWidget() {
        picturePresent = new PicturePresent(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        picturePresent.fetchPictureUrlList();
    }

    @Override
    public void initTitleBar() {

    }

    @Override
    public void setPresent(PictureFragmentContract.PicturePresent present) {

    }

    @Override
    public void initPictureData(List<NewsBean.DataBean> newsBeanList) {
        adapter = new PictureRecyclerAdapter(getActivity(), newsBeanList);
        recyclerView.setAdapter(adapter);
    }
}
