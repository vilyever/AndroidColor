# Deprecated
合并在[AndroidResource](https://github.com/vilyever/AndroidResource)

# AndroidColor
Android颜色工具，包含W3C定义的颜色

## Import
[JitPack](https://jitpack.io/)

Add it in your project's build.gradle at the end of repositories:

```gradle
repositories {
  // ...
  maven { url "https://jitpack.io" }
}
```

Step 2. Add the dependency in the form

```gradle
dependencies {
  compile 'com.github.vilyever:AndroidColor:1.1.0'
}
```

## Usage
```java

int color = Colour.res(R.color.White);
color = Colour.changeAlpha(color, 0xA0);
color = Colour.changeRed(color, 0x55);
color = Colour.changeGreen(color, 0x10);
color = Colour.changeBlue(color, 0xE0);
color = Colour.changeHSVHue(color, 288.0f);
color = Colour.changeHSVSaturation(color, 0.8f);
color = Colour.changeHSVValue(color, 0.3f);
String hexColor = Colour.getHex(color);

```

## License
[Apache License Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)

