package com.example.qrcode.qrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class BarcodeScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);
        mScannerView = findViewById(R.id.barcode_scanner);
        txtWelcome = findViewById(R.id.textViewWelcome);
        txtWelcome.setVisibility(View.GONE);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.resumeCameraPreview(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCameraPreview();
    }

    @Override
    protected void onDestroy() {
        mScannerView.stopCamera();           // Stop camera on pause
        super.onDestroy();
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(this,result.getText().toString(), Toast.LENGTH_SHORT).show();
        txtWelcome.setVisibility(View.VISIBLE);
    }
}
