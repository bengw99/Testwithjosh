package bengw.testwithjosh;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class doesstuff extends AppCompatActivity {
    private int mycolor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_doesstuff);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        FrameLayout boxbutton = (FrameLayout)findViewById(R.id.gamebox);
        mycolor = 0;
        boxbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cyclerb();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button.
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void cyclerb() {
        FrameLayout fl = (FrameLayout)findViewById(R.id.gamebox);
        if (mycolor == 0) {
            mycolor = 1;
            fl.setBackgroundColor(Color.RED);
        } else {
            mycolor = 0;
            fl.setBackgroundColor(Color.BLUE);
        }
    }
}
