package com.yoidukigembu.androiddialogsample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ダイアログクラス。
 * DialogFragmentを継承する。
 */
public class SampleDialog extends DialogFragment {


    private TextView messageText;

    /** OKがクリックされたときのコールバック */
    private View.OnClickListener onOkClickedListener;

    /** キャンセルがクリックされたときのコールバック */
    private View.OnClickListener onCancelClickedListener;


    /**
     * ダイアログのViewを生成するメソッド
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final View view = View.inflate(getContext(), R.layout.dialog_sample, null);

        builder.setView(view);

        this.messageText = view.findViewById(R.id.messageTxt);
        final Button okButton = view.findViewById(R.id.okButton);
        final Button cancelButton = view.findViewById(R.id.cancelButton);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "OK！", Toast.LENGTH_SHORT).show();
                // ダイアログを閉じる
                dismiss();

                // コールバックがあればコールする
                if (onOkClickedListener != null) {
                    onOkClickedListener.onClick(view);
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "CANCEL!", Toast.LENGTH_SHORT).show();
                // ダイアログを閉じる
                dismiss();

                // コールバックがあればコールする
                if (onCancelClickedListener != null) {
                    onCancelClickedListener.onClick(view);
                }
            }
        });



        return builder.create();
    }


    public void setOnOkClickedListener(View.OnClickListener onOkClickedListener) {
        this.onOkClickedListener = onOkClickedListener;
    }

    public void setOnCancelClickedListener(View.OnClickListener onCancelClickedListener) {
        this.onCancelClickedListener = onCancelClickedListener;
    }

}
