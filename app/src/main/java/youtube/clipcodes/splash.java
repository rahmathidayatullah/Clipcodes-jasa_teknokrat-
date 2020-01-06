package youtube.clipcodes;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    TextView tvSplash ;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tvSplash = (TextView) findViewById(R.id.tvSplash);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                intent = new Intent(splash.this, MainActivity.class);
                intent.putExtra("title", "Penjelasan Jasa");
                startActivity(intent);
                finish();
            }
        }, 5000L); //5000 L = 3 detik
    }
}