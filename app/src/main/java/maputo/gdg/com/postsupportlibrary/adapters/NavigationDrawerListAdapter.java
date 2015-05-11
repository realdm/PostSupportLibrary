package maputo.gdg.com.postsupportlibrary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Vector;

import maputo.gdg.com.postsupportlibrary.R;
import maputo.gdg.com.postsupportlibrary.holder.DrawerHeaderHolder;
import maputo.gdg.com.postsupportlibrary.holder.DrawerRegularRowHolder;
import maputo.gdg.com.postsupportlibrary.utils.CircleTransform;

/**
 * Created by Mac on 3/20/2015.
 */
public class NavigationDrawerListAdapter extends BaseAdapter {

    private final int TYPE_HEADER=0;

    private final int TYPE_REGULAR_ROW=1;

    private String avatarLink;

    private String userName;

    private String mBackgroundImage;

    private Context mContext;

    Vector drawer_icons;


    ArrayList<String> drawerTexts;


    public NavigationDrawerListAdapter(Context mContext)
    {
        this.mContext = mContext;
        drawer_icons = new Vector();
        drawerTexts = new ArrayList<String>();
    }

    public void addRow(int icon, String text)
    {
        drawer_icons.add(icon);
        drawerTexts.add(text);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public void setDrawerHeader(String avatarLink, String userName, String mBackgroundImage)
    {
        this.avatarLink = avatarLink;
        this.userName = userName;
        this.mBackgroundImage = mBackgroundImage;
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0)
        {
            return TYPE_HEADER;
        }
        else
        {
            return TYPE_REGULAR_ROW;
        }
    }

    @Override
    public int getCount() {
        return drawerTexts.size()+1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DrawerRegularRowHolder drawerRegularRowHolder=null;
        DrawerHeaderHolder mDrawerHeaderHolder=null;

        if(convertView==null)
        {
            LayoutInflater mLayoutInflater = LayoutInflater.from(parent.getContext());

            if (getItemViewType(position)==TYPE_HEADER)
            {
                convertView = mLayoutInflater.inflate(R.layout.drawer_row_header,parent,false);

                mDrawerHeaderHolder = new DrawerHeaderHolder(convertView);

                convertView.setTag(mDrawerHeaderHolder);
            }
            else
            {
                convertView = mLayoutInflater.inflate(R.layout.drawer_row_normal,parent,false);

                drawerRegularRowHolder = new DrawerRegularRowHolder(convertView);

                convertView.setTag(drawerRegularRowHolder);
            }
        }
        else {

            if(getItemViewType(position)==TYPE_HEADER)
            {
                mDrawerHeaderHolder = (DrawerHeaderHolder) convertView.getTag();
            }
            else
            {
                drawerRegularRowHolder = (DrawerRegularRowHolder) convertView.getTag();;
            }
        }

        if(getItemViewType(position)==TYPE_HEADER)
        {
            mDrawerHeaderHolder.mUserName.setText(userName);

            Picasso.with(mContext).load(avatarLink).placeholder(R.drawable.avatar_placeholder).transform(new CircleTransform()).into(mDrawerHeaderHolder.mUserAvatar);

            Picasso.with(mContext).load(mBackgroundImage).placeholder(R.drawable.default_cover).into(mDrawerHeaderHolder.mHeaderCover);
        }
        else
        {
            drawerRegularRowHolder.mIcon.setBackgroundResource((int)drawer_icons.get(position-1));
            drawerRegularRowHolder.mRowText.setText(drawerTexts.get(position-1));
        }
        return convertView;
    }

}
