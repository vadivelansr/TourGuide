package com.vadivelansr.android.tourguide.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.squareup.picasso.Picasso;
import com.vadivelansr.android.tourguide.R;
import com.vadivelansr.android.tourguide.bean.ListItemBean;
import com.vadivelansr.android.tourguide.config.Utility;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by vadivelansr on 6/12/2016.
 */
public class ListAdapter extends ArrayAdapter<ListItemBean> {
    Context mContext;

    public ListAdapter(Context context, List<ListItemBean> listItems) {
        super(context, 0, listItems);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemBean listItemBean = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.places_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textTitle.setText(listItemBean.getTitle());
        viewHolder.textDesc.setText(listItemBean.getDesc());
        Picasso.with(mContext).load(listItemBean.getImageId())
                .fit().placeholder(Utility.getColor(mContext))
                .into(viewHolder.image);
        return convertView;
    }

    public static class ViewHolder {
        @Bind(R.id.title)
        AppCompatTextView textTitle;
        @Bind(R.id.description)
        AppCompatTextView textDesc;
        @Bind(R.id.image)
        AppCompatImageView image;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
