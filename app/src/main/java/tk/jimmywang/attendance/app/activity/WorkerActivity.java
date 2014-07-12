package tk.jimmywang.attendance.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import tk.jimmywang.attendance.app.R;

/**
 * Created by WangJin on 2014/7/12.
 */
public class WorkerActivity extends BaseActivity implements View.OnClickListener {

    private EditText workerNameEditText;
    private EditText workerPhoneEditText;
    private Button workerSubmitButton;
    private Button workerCancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_worker);
        initView();

    }


    public void initView() {
        workerNameEditText = (EditText) findViewById(R.id.editText_workerName);
        workerPhoneEditText = (EditText) findViewById(R.id.editText_workerPhone);
        workerSubmitButton = (Button) findViewById(R.id.button_submitWorker);
        workerCancelButton = (Button) findViewById(R.id.button_submitWorker);
        workerSubmitButton.setOnClickListener(this);
        workerCancelButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_submitWorker:
                String workerName = workerNameEditText.getText().toString();
                String workerPhone = workerPhoneEditText.getText().toString();
                Intent intent = this.getIntent();
                intent.putExtra("workerName", workerName);
                intent.putExtra("workerPhone", workerPhone);
                this.setResult(1, intent);
                this.finish();
                break;
            case R.id.button_cancelWorker:
                this.finish();
                break;
        }
    }
}
