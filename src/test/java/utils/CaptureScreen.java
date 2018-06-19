package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by duanzonghai on 2018/5/28.
 */
public class CaptureScreen {


    /**
     * selenium的get_screenshot_as_file()可以实现截图功能
     * @param fileName
     * @throws Exception
     */
    public void captureScreen(String fileName) throws Exception{

//        获取屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Rectangle screenRectangle = new Rectangle(screenSize);

        Robot robot = new Robot();

//        截图
        BufferedImage image = robot.createScreenCapture(screenRectangle);

        ImageIO.write(image,"png",new File(fileName));

    }

}
