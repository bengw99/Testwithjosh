package bengw.testwithjosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button)findViewById(R.id.button_next_action);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotopage2();
            }
        });
    }

    private void gotopage2() {
        Intent intent = new Intent(this, doesstuff.class);
        startActivity(intent);
    }

}
