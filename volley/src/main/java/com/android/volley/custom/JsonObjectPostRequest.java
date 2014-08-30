package com.android.volley.custom;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by 金 on 2014/8/27.
 */
public class JsonObjectPostRequest extends Request<JSONObject> {


    private Response.Listener<JSONObject> listener;
    private Map<String, String> params;

    public JsonObjectPostRequest(String url, Map<String, String> params,
                                 Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
        super(Method.POST, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }

    public JsonObjectPostRequest(int method, String url, Map<String, String> params,
                                 Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }

    protected Map<String, String> getParams()
            throws com.android.volley.AuthFailureError {
        return params;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            return Response.success(new JSONObject(new String(response.data,
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
    protected void deliverResponse(JSONObject response) {
        listener.onResponse(response);
    }
}
