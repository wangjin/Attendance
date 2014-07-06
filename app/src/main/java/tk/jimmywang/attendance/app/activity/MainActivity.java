package tk.jimmywang.attendance.app.activity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import tk.jimmywang.attendance.app.R;
import tk.jimmywang.attendance.app.fragment.AttendanceFragment;
import tk.jimmywang.attendance.app.fragment.WorkerFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private View attendanceMenu;
    private View workerMenu;
    private ImageView attendanceImage;
    private ImageView workerImage;

    private FragmentManager fragmentManager;

    private AttendanceFragment attendanceFragment;
    private WorkerFragment workerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = this.getSupportFragmentManager();
        initViews();
        new Test().execute();

    }

    public void initViews() {
        attendanceMenu = findViewById(R.id.menu_attendance);
        attendanceMenu.setOnClickListener(this);
        workerMenu = findViewById(R.id.menu_worker);
        workerMenu.setOnClickListener(this);

        attendanceImage = (ImageView) findViewById(R.id.image_attendance);
        workerImage = (ImageView) findViewById(R.id.image_worker);


        setSelectedMenu(1);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_attendance:
                Toast.makeText(this, "Attendance", Toast.LENGTH_SHORT).show();
                setSelectedMenu(1);
                break;
            case R.id.menu_worker:
                Toast.makeText(this, "Worker", Toast.LENGTH_SHORT).show();
                setSelectedMenu(2);
                break;
        }

    }

    public void setSelectedMenu(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        hideFragments(transaction);
        resetMenuBackground();

        switch (index) {
            case 1:
                if (attendanceFragment == null) {
                    attendanceFragment = new AttendanceFragment();
                    transaction.add(R.id.container, attendanceFragment);
                } else {
                    transaction.show(attendanceFragment);
                }

                attendanceMenu.setBackgroundColor(Color.YELLOW);
                attendanceImage.setImageResource(R.drawable.bookmark_full_30);
                break;
            case 2:
                if (workerFragment == null) {
                    workerFragment = new WorkerFragment();
                    transaction.add(R.id.container, workerFragment);
                } else {
                    transaction.show(workerFragment);
                }

                workerMenu.setBackgroundColor(Color.YELLOW);
                workerImage.setImageResource(R.drawable.user_full_30);
                break;
            case 3:
                break;
            case 4:
                break;
        }

        transaction.commit();
    }

    public void hideFragments(FragmentTransaction transaction) {
        if (attendanceFragment != null) {
            transaction.hide(attendanceFragment);
        }
        if (workerFragment != null) {
            transaction.hide(workerFragment);
        }
    }

    public void resetMenuBackground(){
        attendanceMenu.setBackgroundColor(Color.parseColor("#FFFFFF"));
        workerMenu.setBackgroundColor(Color.parseColor("#FFFFFF"));
        attendanceImage.setImageResource(R.drawable.bookmark_line_30);
        workerImage.setImageResource(R.drawable.user_line_30);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    class Test extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            ProgressBar relativeLayout = (ProgressBar) findViewById(R.id.progressbar);
            relativeLayout.setVisibility(View.GONE);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}

