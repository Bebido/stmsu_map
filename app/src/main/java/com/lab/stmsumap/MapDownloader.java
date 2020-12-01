package com.lab.stmsumap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Base64;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class MapDownloader extends AsyncTask<GetMapFragmentRequest, Long, String> {

    private MainActivity callingActivity;
    private static final String METHOD_NAME = "getMapFragmentRequest";
    private static final String NAMESPACE = "http://stm.pg.edu.pl/mapWS";
    private static final String SOAP_ACTION = "";
    private static final String URL = "http://10.0.2.2:8080/ws/";

    private SoapSerializationEnvelope envelope;
    private SoapObject request;

    @Override
    protected String doInBackground(GetMapFragmentRequest... requests) {
        GetMapFragmentRequest mapFragmentRequest = requests[0];
        return getOriginalMap(mapFragmentRequest);
    }

    public MapDownloader(MainActivity activity) {
        callingActivity = activity;
    }

    public String getOriginalMap(GetMapFragmentRequest mapFragmentRequest) {
        buildSoapSerializationEnvelope(mapFragmentRequest);
        String result = "";

        HttpTransportSE ht = new HttpTransportSE(URL);
        try {
            ht.call(SOAP_ACTION, envelope);
            result = envelope.getResponse().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private void buildSoapSerializationEnvelope(GetMapFragmentRequest mapFragmentRequest) {
        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.implicitTypes = true;
        envelope.setAddAdornments(false);

        buildSoapRequest(mapFragmentRequest);
        envelope.setOutputSoapObject(request);
        envelope.addMapping(NAMESPACE, "GetMapFragmentRequest", GetMapFragmentRequest.class);
    }

    private void buildSoapRequest(GetMapFragmentRequest mapFragmentRequest) {
        request = new SoapObject(NAMESPACE, METHOD_NAME);

        for (int i = 0; i < mapFragmentRequest.getPropertyCount(); i++) {
            PropertyInfo pi = new PropertyInfo();
            mapFragmentRequest.getPropertyInfo(i, null, pi);
            pi.setValue(mapFragmentRequest.getProperty(i));
            request.addProperty(pi);
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        byte[] decodedString = new byte[0];
        if (!s.isEmpty())
            decodedString = Base64.decode(s, Base64.DEFAULT);

        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        callingActivity.getImageView().setImageBitmap(decodedByte);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                callingActivity.getButtonOriginalMap().setEnabled(true);
                callingActivity.getButtonMapSnippet().setEnabled(true);
            }
        }, 500);

    }
}
