package tk.jimmywang.attendance.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import tk.jimmywang.attendance.app.R;
import tk.jimmywang.attendance.app.activity.WorkerActivity;

/**
 * Created by WangJin on 2014/7/5.
 */
public class WorkerFragment extends BaseFragment implements View.OnClickListener {

    private Button addWorkerButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker, container, false);
        addWorkerButton = (Button) view.findViewById(R.id.button_addWorker);
        addWorkerButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_addWorker:
                Intent intent = new Intent();
                intent.setClass(getActivity(), WorkerActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            String workerName = data.getStringExtra("workerName");
            String workerPhone = data.getStringExtra("workerPhone");


            Toast.makeText(getActivity(), workerName, Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), workerPhone, Toast.LENGTH_SHORT).show();
        }
    }

}
