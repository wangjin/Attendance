package tk.jimmywang.attendance.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import tk.jimmywang.attendance.app.R;

/**
 * Created by WangJin on 2014/7/5.
 */
public class WorkerFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker, container, false);
        return view;
    }
}
