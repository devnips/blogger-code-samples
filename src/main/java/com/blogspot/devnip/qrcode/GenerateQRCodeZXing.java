package com.blogspot.devnip.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Generate QRCodes in Java using Google's ZXing library
 */
public class GenerateQRCodeZXing {

    public static final String IMAGE_FORMAT = "PNG";

    /**
     * Generate QR code image file with given content text.
     *
     * @param text     - content of QRCode
     * @param width    - Width of QRCode image
     * @param height   - Height of QRCode image
     * @param filePath - file to store QRCode image
     * @throws WriterException
     * @throws IOException
     */
    private static void generate(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, IMAGE_FORMAT, path);
    }

    public static void main(String[] args) {
        int height = 350, width = 350;
        try {
            generate("https://devnip.blogspot.com/", width, height, "./qrcode.png");
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }
}
