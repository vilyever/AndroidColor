package com.vilyever.androidcolor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.vilyever.color.Colour;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    final MainActivity self = this;

    private SeekBar alphaSeekBar;
    public SeekBar getAlphaSeekBar() { if (alphaSeekBar == null) { alphaSeekBar = (SeekBar) self.findViewById(R.id.alphaSeekBar); } return alphaSeekBar; }

    private SeekBar redSeekBar;
    public SeekBar getRedSeekBar() { if (redSeekBar == null) { redSeekBar = (SeekBar) self.findViewById(R.id.redSeekBar); } return redSeekBar; }

    private SeekBar greenSeekBar;
    public SeekBar getGreenSeekBar() { if (greenSeekBar == null) { greenSeekBar = (SeekBar) self.findViewById(R.id.greenSeekBar); } return greenSeekBar; }

    private SeekBar blueSeekBar;
    public SeekBar getBlueSeekBar() { if (blueSeekBar == null) { blueSeekBar = (SeekBar) self.findViewById(R.id.blueSeekBar); } return blueSeekBar; }

//    private SeekBar hueSeekBar;
//    public SeekBar getHueSeekBar() { if (hueSeekBar == null) { hueSeekBar = (SeekBar) self.findViewById(R.id.hueSeekBar); } return hueSeekBar; }
//
//    private SeekBar saturationSeekBar;
//    public SeekBar getSaturationSeekBar() { if (saturationSeekBar == null) { saturationSeekBar = (SeekBar) self.findViewById(R.id.saturationSeekBar); } return saturationSeekBar; }
//
//    private SeekBar valueSeekBar;
//    public SeekBar getValueSeekBar() { if (valueSeekBar == null) { valueSeekBar = (SeekBar) self.findViewById(R.id.valueSeekBar); } return valueSeekBar; }

    private View colorView;
    public View getColorView() { if (colorView == null) { colorView = (View) self.findViewById(R.id.colorView); } return colorView; }

    private TextView colorTitleLabel;
    public TextView getColorTitleLabel() { if (colorTitleLabel == null) { colorTitleLabel = (TextView) self.findViewById(R.id.colorTitleLabel); } return colorTitleLabel; }

    private View invertColorView;
    public View getInvertColorView() { if (invertColorView == null) { invertColorView = (View) self.findViewById(R.id.invertColorView); } return invertColorView; }

    private TextView invertColorTitleLabel;
    public TextView getInvertColorTitleLabel() { if (invertColorTitleLabel == null) { invertColorTitleLabel = (TextView) self.findViewById(R.id.invertColorTitleLabel); } return invertColorTitleLabel; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        self.getAlphaSeekBar().setOnSeekBarChangeListener(self);
//        self.getHueSeekBar().setOnSeekBarChangeListener(self);
//        self.getSaturationSeekBar().setOnSeekBarChangeListener(self);
//        self.getValueSeekBar().setOnSeekBarChangeListener(self);
        self.getRedSeekBar().setOnSeekBarChangeListener(self);
        self.getGreenSeekBar().setOnSeekBarChangeListener(self);
        self.getBlueSeekBar().setOnSeekBarChangeListener(self);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int color = Color.argb(self.getAlphaSeekBar().getProgress(), self.getRedSeekBar().getProgress(), self.getGreenSeekBar().getProgress(), self.getBlueSeekBar().getProgress());
        float[] hsv = new float[3];
//        hsv[0] = self.getHueSeekBar().getProgress();
//        hsv[1] = self.getSaturationSeekBar().getProgress() / 100.0f;
//        hsv[2] = self.getValueSeekBar().getProgress() / 100.0f;

        Color.colorToHSV(color, hsv);
        System.out.println("hsv " + hsv[0] + ", " + hsv[1] + ", " + hsv[2]);
//        int color = Color.HSVToColor(self.getAlphaSeekBar().getProgress(), hsv);
        self.getColorView().setBackgroundColor(color);
        self.getColorTitleLabel().setTextColor(Colour.getInvertColor(color));
        self.getInvertColorView().setBackgroundColor(Colour.getInvertColor(color));
        self.getInvertColorTitleLabel().setTextColor(color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
