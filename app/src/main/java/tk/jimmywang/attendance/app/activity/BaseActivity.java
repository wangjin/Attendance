package tk.jimmywang.attendance.app.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;

/**
 * Created by WangJin on 2014/7/2.
 */
public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //去掉标题
    }
}
