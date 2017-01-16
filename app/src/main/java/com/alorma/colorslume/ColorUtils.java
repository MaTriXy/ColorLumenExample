package com.alorma.colorslume;

public class ColorUtils {

  private int lumenLimit;

  public ColorUtils() {
    lumenLimit = 128;
  }

  public ColorUtils(int lumenLimit) {
    this.lumenLimit = lumenLimit;
  }

  public boolean isBrightColor(int color) {
    int r = (color >> 16) & 0xFF;
    int g = (color >> 8) & 0xFF;
    int b = (color) & 0xFF;

    //@see http://stackoverflow.com/questions/12043187/how-to-check-if-hex-color-is-too-black
    double luma = 0.2126 * r + 0.7152 * g + 0.0722 * b;

    return luma < lumenLimit;
  }

  public void setLumenLimit(int lumenLimit) {
    this.lumenLimit = lumenLimit;
  }
}
