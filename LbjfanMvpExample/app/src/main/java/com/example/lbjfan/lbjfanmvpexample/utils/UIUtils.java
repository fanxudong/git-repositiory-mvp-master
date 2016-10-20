package com.example.lbjfan.lbjfanmvpexample.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lbjfan.lbjfanmvpexample.R;

/**
 * Created by ${lbjfan} on 16-10-20.
 */
public class UIUtils {

    public static void showPrompt(String str, Context context) {
        Toast toast = new Toast(context);
        View view = LayoutInflater.from(context).inflate(R.layout.view_toast_prompt, null);
        TextView toast_content = (TextView) view.findViewById(R.id.toast_content);
        toast_content.setText(str);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
