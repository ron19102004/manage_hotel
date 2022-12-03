package asset.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProcessImage {
    public static ProcessImage getInstance(){
        return new ProcessImage();
    }
    public ImageIcon setImageIcon(String url, int width, int height){
        Image image = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(url));
            image = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        } catch (IOException e){
            e.getStackTrace();
        }
        assert image != null;
        return new ImageIcon(image);
    }
}
