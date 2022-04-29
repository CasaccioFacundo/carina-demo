package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import static com.zebrunner.agent.core.registrar.TestRunRegistrar.LOGGER;

public class ScreenshotService implements IDriverPool {

    private final File directory = new File(R.TESTDATA.get("screenshot_path"));

    public void takeScreenshot() {
        File outputfile = new File(directory.getPath() + "/test-" + new Date() + ".png");
        BufferedImage screenshot = null;

        createDirectory();

        try {
            screenshot = ImageIO.read(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE));
            ImageIO.write(screenshot, "PNG", outputfile);
        } catch (IOException e) {
            LOGGER.info("Unable to capture screenshot");
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String filename) {
        File providedOutputFile = new File(directory.getPath() + "/" + filename + ".png");
        BufferedImage screenshot = null;

        createDirectory();

        try {
            screenshot = ImageIO.read(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE));
            ImageIO.write(screenshot, "PNG", providedOutputFile);
        } catch (IOException e) {
            LOGGER.info("Unable to capture screenshot");
            e.printStackTrace();
        }
    }

    private void createDirectory() {
        if(!directory.exists())
        try {
            Files.createDirectory(Path.of(R.TESTDATA.get("screenshot_path")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
