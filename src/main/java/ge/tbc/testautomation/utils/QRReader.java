package ge.tbc.testautomation.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;


public class QRReader {
    public static String readQR(byte[] imageBytes) throws Exception{
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }
}
