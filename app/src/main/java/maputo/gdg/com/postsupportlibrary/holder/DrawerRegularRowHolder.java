package maputo.gdg.com.postsupportlibrary.holder;

import android.view.View;
import android.widget.TextView;

import maputo.gdg.com.postsupportlibrary.R;


/**
 * Created by Mac on 3/20/2015.
 */
public class DrawerRegularRowHolder {

    public View mIcon;

    public TextView mRowText;

    public DrawerRegularRowHolder(View view)
    {
        mIcon = view.findViewById(R.id.row_icon);

        mRowText = (TextView) view.findViewById(R.id.drawer_row_line);
    }
}
