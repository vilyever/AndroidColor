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
  compile 'com.github.vilyever:AndroidColor:1.0.0'
}
```

## Usage
```java

int color = VDColor.res(R.color.White);
color = VDColor.changeAlpha(color, 0xA0);
color = VDColor.changeRed(color, 0x55);
color = VDColor.changeGreen(color, 0x10);
color = VDColor.changeBlue(color, 0xE0);
color = VDColor.changeHSVHue(color, 288.0f);
color = VDColor.changeHSVSaturation(color, 0.8f);
color = VDColor.changeHSVValue(color, 0.3f);
String hexColor = VDColor.getHex(color);

```

## License
[Apache License Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)

