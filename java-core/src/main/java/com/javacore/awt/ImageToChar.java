package com.javacore.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @Author: sunqianqian
 * @Date: 2015/10/10
 * @Description:
 * @CodeReviewer:
 */
public class ImageToChar {
    public static String _BitmapConvert(String imgpath) {
        StringBuffer _sb = new StringBuffer();
        File imgfile = new File(imgpath);
        char[] charset = {'M', '8', '0', 'V', '1', 'i', ':', '*', '|', '.', ' '};
        try {
            BufferedImage buff = ImageIO.read(imgfile);

            int bitmapH = buff.getHeight();
            int bitmapW = buff.getWidth();

            for (int y = 0; y < bitmapH; y++) {
                for (int x = 0; x < bitmapW; x++) {
                    int rgb = buff.getRGB(x, y);
                    Color c = new Color(rgb);
                    int cc = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                    _sb.append(charset[(int) ((cc * 10 - 1) / 255)]);
                }
                _sb.append("\r\n");
            }
        } catch (Exception e) {
        }
        return _sb.toString();
    }

    public static void main(String[] args) {
        String imageText = ImageToChar._BitmapConvert("C:\\Users\\qianqian\\Pictures\\Saved Pictures\\小荟女学生.jpg");
        System.out.println(imageText);
    }
}
