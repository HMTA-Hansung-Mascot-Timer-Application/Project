package kr.teamcadi.ssangtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class StartActivity extends AppCompatActivity {
    private Intent intent;
    private TextView txt_start_time;
    private TextView txt_start_goalhours,txt_start_goalsubject;
    private Button btn_start_stop, btn_start_start,btn_start_refresh;
    private Thread timeThread = null; // null로 초기화
    private Boolean isRunning = true; //while문 쓰기 위해 작성
    private int i = 0;
    private int buttonChange = 0; //0 is Start // 1 is Stop

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

//        btn_start_start = (Button) findViewById(R.id.btn_start_start);
//        btn_start_start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "start Complete !", Toast.LENGTH_SHORT).show();
//                setResult(1, new Intent());
//                finish();
//            }
//        });
        txt_start_goalhours =(TextView)findViewById(R.id. txt_start_goalhours);
        txt_start_goalsubject = (TextView)findViewById(R.id.txt_start_goalsubject);
        btn_start_start = (Button) findViewById(R.id.btn_start_start);
        btn_start_refresh = (Button) findViewById(R.id.btn_start_refresh);
        txt_start_time = (TextView) findViewById(R.id.txt_start_time);
        btn_start_stop = (Button) findViewById(R.id.btn_start_stop);

        intent = getIntent();

        txt_start_goalhours.setText(String.valueOf(intent.getIntExtra("hours",0)));
        txt_start_goalsubject.setText(intent.getStringExtra("subject"));


        btn_start_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = true;
                timeThread = new Thread(new timeThread());
                timeThread.start();
                buttonChange++;
            }
        });
        btn_start_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isRunning = false;
                buttonChange--;
            }
        });


        btn_start_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonChange == 0) {
                    i = 0;
                    txt_start_time.setText("00:00:00:00");
                }
            }
        });
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            int mSec = msg.arg1 % 100;
            int sec = (msg.arg1 / 100) % 60;
            int min = (msg.arg1 / 100) / 60;
            int hour = (msg.arg1 / 100) / 360;

            String result = String.format("%02d:%02d:%02d:%02d", hour, min, sec, mSec);
            txt_start_time.setText(result);

        }
    };

    public class timeThread implements Runnable {
        public void run() {
            while (isRunning) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = new Message();
                msg.arg1 = i++;
                handler.sendMessage(msg);
            }
        }
    }

}
