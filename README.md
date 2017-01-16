# Color Lumen example

Did you need to change the color of text depending on a background color? Or maybe just a color?

This sample app will help you to choice the perfect  values for your `lumen` algorithm.

```
  public boolean isBrightColor(int color) {
    int r = (color >> 16) & 0xFF;
    int g = (color >> 8) & 0xFF;
    int b = (color) & 0xFF;

    //@see http://stackoverflow.com/questions/12043187/how-to-check-if-hex-color-is-too-black
    double luma = 0.2126 * r + 0.7152 * g + 0.0722 * b;

    return luma < lumenLimit;
  }
```

> Ref: https://github.com/alorma/ColorLumenExample/blob/master/app/src/main/java/com/alorma/colorslume/ColorUtils.java

APK: https://github.com/alorma/ColorLuemExample/releases/tag/v.1.0

![screenshot_1484591722](https://cloud.githubusercontent.com/assets/887462/21995058/21a6710c-dc23-11e6-8abe-4434d27f215b.png)
