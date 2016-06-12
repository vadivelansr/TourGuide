package com.vadivelansr.android.tourguide.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.vadivelansr.android.tourguide.R;
import com.vadivelansr.android.tourguide.adapter.ListAdapter;
import com.vadivelansr.android.tourguide.bean.ListItemBean;
import com.vadivelansr.android.tourguide.config.Constants;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by vadivelansr on 6/12/2016.
 */
public class TourGuideFragment extends Fragment {
    @Bind(R.id.places_list)
    ListView placesList;
    private ListAdapter mListAdapter;
    private String mCategory;

    public TourGuideFragment() {

    }

    public static TourGuideFragment newInstance(String paramOption) {
        TourGuideFragment planFragment = new TourGuideFragment();
        Bundle args = new Bundle();
        args.putString(Constants.CATEGORY, paramOption);
        planFragment.setArguments(args);
        return planFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCategory = getArguments().getString(Constants.CATEGORY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tour_guide, container, false);
        ButterKnife.bind(this, rootView);
        mListAdapter = new ListAdapter(getActivity(), loadData(mCategory));
        placesList.setAdapter(mListAdapter);
        return rootView;
    }

    private ArrayList<ListItemBean> loadData(String category){
        ArrayList<ListItemBean> listItems = new ArrayList<>();
        int titleId = getResources().getIdentifier(category, "array", getActivity().getPackageName());
        int descId = getResources().getIdentifier(category + "_" + Constants.DESC, "array", getActivity().getPackageName());
        int imageId = getResources().getIdentifier(category + "_" + Constants.DRAWABLE, "array", getActivity().getPackageName());
        String[] titleList = getResources().getStringArray(titleId);
        String[] descList = getResources().getStringArray(descId);
        TypedArray imageList = getResources().obtainTypedArray(imageId);
        for (int i = 0; i < titleList.length; i++) {
            ListItemBean listItemBean = new ListItemBean();
            listItemBean.setTitle(titleList[i]);
            listItemBean.setDesc(descList[i]);
            listItemBean.setImageId(imageList.getResourceId(i, -1));
            listItems.add(listItemBean);
        }
        imageList.recycle();
        return listItems;
    }
}
