package com.yanyu.libs.baseframe.spannablestring;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.NonNull;

public class Clickable
        extends ClickableSpan {

    private final View.OnClickListener listener;

    public Clickable(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(@NonNull View v) {
        listener.onClick(v);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        // ds.setColor(Color.TRANSPARENT);
        ds.setUnderlineText(false);    // 去除超链接的下划线
    }
}