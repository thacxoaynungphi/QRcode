package com.example.qrcode.qrcode;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int ZBAR_CAMERA_PERMISSION = 1;
    Button btnScan;
    //TextView txtName, txtAddress;
    //ImageView imgPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
//        final IntentIntegrator intentIntegrator = new IntentIntegrator(this);
//        intentIntegrator.setOrientationLocked(true);
//        btnScan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intentIntegrator.initiateScan();
//            }
//        });

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, ZBAR_CAMERA_PERMISSION);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == ZBAR_CAMERA_PERMISSION && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MainActivity.this, BarcodeScannerActivity.class);
            startActivityForResult(intent, ZBAR_CAMERA_PERMISSION);
        }else{
            Toast.makeText(this, "Failed!!!", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void init(){
        btnScan = findViewById(R.id.buttonScan);
       // txtName = findViewById(R.id.textViewName);
       // txtAddress = findViewById(R.id.textViewAddress);
        // imgPic = findViewById(R.id.imageView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if(result != null) {
//            if(result.getContents() == null) {
//                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
//            } else {
//               // Picasso.with(this).load(result.getContents()).into(imgPic);
////                try {
////                    JSONObject jsonObject = new JSONObject(result.getContents());
////                    txtName.setText(jsonObject.getString("name"));
////                    txtAddress.setText(jsonObject.getString("address"));
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
//                //txtName.setText(result.getContents().toString());
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
    }
}
