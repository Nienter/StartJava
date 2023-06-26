package com.myjava.javatest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

public class kAc extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showDialog(1);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            Dialog dialog = new AlertDialog.Builder(this)
                    .setTitle("野猿新一")
                    .setMessage("我是对话框内容啦")
                    .create();
// 增加这句代码
            dialog.show();
        }
        return super.onCreateDialog(id);
    }
}
