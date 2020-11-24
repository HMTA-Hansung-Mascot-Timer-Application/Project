package kr.teamcadi.ssangtimer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    private Button btn_confirm;
    private ProgressBar pg;
    private RadioGroup rg;
    private EditText et;
    private String selectedTime;
    private int time;
    private String subject = "";
    private String csub = "선택하신 과목은 ";
    private String chour = "이고 선택하신 시간은 ";
    private String confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        rg = (RadioGroup)findViewById(R.id.radioGroup2);
        //2-4-6-8-10 hours,
        pg = (ProgressBar)findViewById(R.id.pbr_step);
        et = (EditText)findViewById(R.id.edit_subject);


        btn_confirm =(Button)findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Setting Complete !",Toast.LENGTH_SHORT).show();
//                setResult(2,new Intent());
//                finish();
                subject = et.getText().toString();
                confirm = csub+subject+chour+selectedTime+"이 맞습니까?";
                AlertDialog.Builder alert = new AlertDialog.Builder(SettingActivity.this);
                alert.setTitle("확인해주세요!");
                alert.setMessage(confirm);
                alert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                        intent.putExtra("hours", time);
                        intent.putExtra("subject", subject);
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("아니요", null);
                AlertDialog alertDialog = alert.create();
                alertDialog.show();

            }
        });



        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rd = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                selectedTime = rd.getText().toString();
                if(selectedTime.equals("2 hours")){
                    pg.setProgress(20);
                    time = 2;
                }
                else if(selectedTime.equals("4 hours")){
                    pg.setProgress(40);
                    time = 4;
                }
                else if(selectedTime.equals("6 hours")){
                    pg.setProgress(60);
                    time = 6;
                }
                else if(selectedTime.equals("8 hours")){
                    pg.setProgress(80);
                    time = 8;
                }
                else if(selectedTime.equals("10 hours")){
                    pg.setProgress(100);
                    time = 10;
                }
            }
        });



    }


}