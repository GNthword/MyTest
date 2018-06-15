package com.milog.test.mytest;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by miloway on 2018/3/22.
 */

public class PermisstionTestActivity extends Activity {


    private TextView tvCameraStatus;
    private Button btnCamera;
    private TextView tvLocationStatus;
    private Button btnLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_test_layout);
        initView();

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPermission();
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocationPermission();
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                tvCameraStatus.setText("相机权限已经获取");
            } else {
                tvCameraStatus.setText("相机权限未获取");
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                tvLocationStatus.setText("已经获取");
            } else {
                tvLocationStatus.setText("未获取");
            }
        }


    }

    private void initView() {

        tvCameraStatus = (TextView) findViewById(R.id.tv_camera_status);
        btnCamera = (Button) findViewById(R.id.btn_camera);
        tvLocationStatus = (TextView) findViewById(R.id.tv_location_status);
        btnLocation = (Button) findViewById(R.id.btn_location);
    }

    private void getPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("需要获取相机权限")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
                                    }
                                }
                            }).show();
                } else {
                    //第一次或永久拒绝
                    //如果用户点了永久拒绝，还是会触发onRequestPermissionsResult
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
                }

            }
        }
    }

    private void getLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                    new AlertDialog.Builder(this)
                            .setTitle("提示")
                            .setMessage("需要获取定位权限")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);
                                    }
                                }
                            }).show();
                } else {
                    //第一次或永久拒绝
                    //如果用户点了永久拒绝，还是会触发onRequestPermissionsResult
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);
                }

            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (Manifest.permission.CAMERA.equals(permissions[0])) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    tvCameraStatus.setText("相机权限 通过申请获取");
                } else {
                    tvCameraStatus.setText("相机权限 申请失败");
                }
            }
        }else if (requestCode == 2) {
            if (Manifest.permission.ACCESS_FINE_LOCATION.equals(permissions[0])) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    tvLocationStatus.setText("定位权限 通过申请获取");
                } else {
                    tvLocationStatus.setText("定位权限 申请失败");
                }
            }
        }
    }
}
