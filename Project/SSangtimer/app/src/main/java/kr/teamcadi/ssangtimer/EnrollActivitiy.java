package kr.teamcadi.ssangtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EnrollActivitiy extends AppCompatActivity {
    private Button btn_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        btn_confirm =(Button)findViewById(R.id.btn_start_start);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Enroll Complete !",Toast.LENGTH_SHORT).show();
                setResult(3,new Intent());
                finish();
            }
        });
    }
}