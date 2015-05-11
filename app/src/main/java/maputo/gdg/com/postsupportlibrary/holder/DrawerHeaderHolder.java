package maputo.gdg.com.postsupportlibrary.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import maputo.gdg.com.postsupportlibrary.R;


/**
 * Created by Mac on 3/20/2015.
 */
public class DrawerHeaderHolder {


    public ImageView mHeaderCover;

    public ImageView mUserAvatar;

    public TextView mUserName;


    public DrawerHeaderHolder(View view)
    {

        mHeaderCover = (ImageView)view.findViewById(R.id.user_cover);

        mUserAvatar = (ImageView) view.findViewById(R.id.user_avatar);

        mUserName = (TextView) view.findViewById(R.id.user_name);
    }
}
