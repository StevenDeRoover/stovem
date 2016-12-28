package stovem.com.stovem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by steven on 28/12/2016.
 */

public class SplashActivity extends AppCompatActivity {
    Thread mainThread = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_main);

        mainThread = new Thread() {
            @Override
            public void run(){
                int waited = 0;
                // Splash screen pause time
                while (waited < 3500) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waited += 100;
                }

                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                getIntent().setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(mainIntent);
            }
        };
        mainThread.start();
    }
}
