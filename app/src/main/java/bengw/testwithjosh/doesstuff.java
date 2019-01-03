package bengw.testwithjosh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.ExifInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class doesstuff extends AppCompatActivity {
    private int mycolor;

    //for device orientation
    Sensor accelerometer;
    Sensor magnetometer;
    Sensor vectorSensor;
    DeviceOrientation deviceOrientation;
    SensorManager mSensorManager;

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

        //for device orientation
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        deviceOrientation = new DeviceOrientation();
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

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(deviceOrientation.getEventListener());
    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(deviceOrientation.getEventListener(), accelerometer, SensorManager.SENSOR_DELAY_UI);
        mSensorManager.registerListener(deviceOrientation.getEventListener(), magnetometer, SensorManager.SENSOR_DELAY_UI);
    }

    private void cyclerb() {
        ImageView spork = (ImageView)findViewById(R.id.spork);
        int orient = deviceOrientation.getOrientation();
        if (orient == ExifInterface.ORIENTATION_) {
            spork.setVisibility(View.VISIBLE);
        } else {
            spork.setVisibility(View.INVISIBLE);
        }
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
