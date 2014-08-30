package com.android.volley.custom;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by 金 on 2014/8/30.
 */
public class JsonArrayPostRequest extends Request<JSONArray> {


    private Response.Listener<JSONArray> listener;
    private Map<String, String> params;

    public JsonArrayPostRequest(int method, String url, Map<String, String> params, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.params = params;
    }

    public JsonArrayPostRequest(String url, Map<String, String> params, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(Method.POST, url, errorListener);
        this.listener = listener;
        this.params = params;
    }

    protected Map<String, String> getParams()
            throws com.android.volley.AuthFailureError {
        return params;
    }

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        try {
            return Response.success(new JSONArray(new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers))),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            je.printStackTrace();
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(JSONArray response) {
        this.listener.onResponse(response);
    }
}
