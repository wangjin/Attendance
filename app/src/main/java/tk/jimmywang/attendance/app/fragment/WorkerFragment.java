package tk.jimmywang.attendance.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.custom.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import tk.jimmywang.attendance.app.R;
import tk.jimmywang.attendance.app.activity.WorkerActivity;
import tk.jimmywang.attendance.app.model.Worker;

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
            final String workerName = data.getStringExtra("workerName");
            final String workerPhone = data.getStringExtra("workerPhone");
            Map<String, String> params = new HashMap<String, String>();
            params.put("workerName", workerName);
            params.put("workerPhone", workerPhone);

            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://192.168.1.111:8080/stringrequest", params, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Worker worker = JSON.parseObject(response.toString(), Worker.class);
                    Toast.makeText(getActivity(), "name:" + worker.getWorkerName() + "|phone:" + worker.getWorkerPhone(), Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("error", error.getMessage());
                }
            });



            StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.111:8080/stringrequest", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getActivity(), "response" + response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("workerName", workerName);
                    params.put("workerPhone", workerPhone);
                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/x-www-form-urlencoded");
                    params.put("Charset", "UTF-8");
                    return params;
                }
            };

            requestQueue.add(jsonObjectRequest);
        }
    }

}
