package com.blogspot.devnip.qrcode;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Read QR code from an image file using Google's ZXing library
 */
public class ReadQRCodeZXing {

    public static String readFile(File file) {
        try {
            BinaryBitmap bitmap = new BinaryBitmap(
                    new HybridBinarizer(
                            new BufferedImageLuminanceSource(ImageIO.read(file))));

            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
