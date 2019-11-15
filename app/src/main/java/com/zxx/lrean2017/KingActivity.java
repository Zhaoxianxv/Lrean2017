package com.zxx.lrean2017;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.yfy.greendao.User;
import com.zxx.base.activity.BaseActivity;
import com.zxx.db.GreenDaoManager;
import com.zxx.final_tag.FileCamera;
import com.zxx.final_tag.StringJudge;
import com.zxx.final_tag.TagFinal;
import com.zxx.permission.PermissionFail;
import com.zxx.permission.PermissionGen;
import com.zxx.permission.PermissionSuccess;
import com.zxx.permission.PermissionTools;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class KingActivity extends BaseActivity {


    @Bind(R.id.show_type)
    TextView type;
    @Bind(R.id.show_content)
    TextView content;
    @Bind(R.id.show_edit)
    TextView edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_king);
    }


    @OnClick(R.id.show_type)
    void setType(){
        showItemsDialog();
    }

    public void showItemsDialog( ) {
        AlertDialog.Builder items=new AlertDialog.Builder(this);
        items.setItems(R.array.title, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                switch (which){
                    case 0:
                        type.setText("ofo");
                        break;
                    case 1:
                        type.setText("qj");
                        break;
                    case 2:
                        type.setText("hl");
                        break;
                    case 3:
                        type.setText("mp");
                        break;
                }
                dialog.dismiss();
            }
        });
        items.show();
    }


    @OnClick(R.id.show_scan)
    void setScan(){
        PermissionTools.tryCameraPerm(mActivity);
    }
    public void scan(){
        startActivityForResult(new Intent(mActivity, CaptureActivity.class), 0);
    }
    @OnClick(R.id.show_save)
    void setSave(){
        String pass=edit.getText().toString();
        String ty=type.getText().toString();


        if (StringJudge.isEmpty(pass)){
            toast("密码");
            return;
        }
        if (StringJudge.isEmpty(result)){
            toast("二维码");
            return;
        }

        save(ty,pass,result);
    }



    private  void save(String ty,String pass,String result){
        User user=new User();
        user.setName(result);
        user.setPass(pass);
        user.setType(ty);
        GreenDaoManager.getInstance().save(user);
        toast("保存成功");
        result="";

    }
    private String result;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Bundle bundle=data.getExtras();
            result=bundle.getString("result");
//            text_end.setText(result);
            show(result);

        }
    }


    private void show(String txt){
        List<User> users=GreenDaoManager.getInstance().query_User(txt);

        if (StringJudge.isEmpty(users)){
            content.setText("未记录");
        }else{
            User user=users.get(0);
            content.setText(user.getPass());
        }

    }
    @PermissionSuccess(requestCode = TagFinal.CAMERA)
    private void takePhoto() {
        scan();
    }

    @PermissionFail(requestCode = TagFinal.CAMERA)
    private void showCamere() {
        Toast.makeText(getApplicationContext(),"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }
}
