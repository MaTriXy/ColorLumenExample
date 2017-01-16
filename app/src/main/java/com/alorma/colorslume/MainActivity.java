package com.alorma.colorslume;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;
import com.jrummyapps.android.colorpicker.ColorPickerView;

public class MainActivity extends AppCompatActivity {

  private TextView colorTextView;
  private ColorPickerView colorPickerView;

  private SeekBar sliderLumenValue;
  private TextView sliderTextLabel;
  private ColorUtils colorUtils;
  private int lastUsedColor;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    colorTextView = (TextView) findViewById(R.id.colorTextView);
    sliderTextLabel = (TextView) findViewById(R.id.sliderTextLabel);
    sliderLumenValue = (SeekBar) findViewById(R.id.sliderLumenValue);
    colorPickerView = (ColorPickerView) findViewById(R.id.colorPickerView);

    colorUtils = new ColorUtils();

    setupListeners();
  }

  private void setupListeners() {
    colorPickerView.setOnColorChangedListener(new ColorPickerView.OnColorChangedListener() {
      @Override
      public void onColorChanged(int newColor) {
        setUpNewColor(newColor);
      }
    });
    sliderLumenValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int value, boolean b) {
        sliderTextLabel.setText(String.format("Lumen limit: %s", String.valueOf(value)));
        colorUtils.setLumenLimit(value);
        setUpNewColor(lastUsedColor);
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });
  }

  private void setUpNewColor(int newColor) {
    this.lastUsedColor = newColor;
    setTextColor(newColor);
    setTextString(newColor);
    setBackgroundColor(newColor);
  }

  private void setTextColor(int newColor) {
    if (colorUtils.isBrightColor(newColor)) {
      colorTextView.setTextColor(Color.BLACK);
    } else {
      colorTextView.setTextColor(Color.WHITE);
    }
  }

  private void setTextString(int newColor) {
    String hexColor = String.format("#%06X", (0xFFFFFF & newColor));
    colorTextView.setText(hexColor);
  }

  private void setBackgroundColor(int newColor) {
    colorTextView.setBackgroundColor(newColor);
  }
}
