package com.framgia.job;

import java.time.LocalDateTime;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.framgia.service.ChatworkService;

@Slf4j
@Component
public class PostChatWorkJob implements Job {

    @Autowired
    private ChatworkService chatworkService;

    @Value("${chatwork.roomId}")
    private String chatworkRoomId;

    @Override
    public void execute(JobExecutionContext context) {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/bin/geckodriver");
        System.setProperty("webdriver.firefox.bin", System.getProperty("user.dir") + "/bin/firefox/firefox");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.navigate().to("https://www.facebook.com/ngamlathich/");

        List<WebElement> allAuthors =  driver.findElements(By.className("scaledImageFitWidth"));
        log.info(String.valueOf(LocalDateTime.now().getHour()) + ":" + String.valueOf(LocalDateTime.now().getMinute()));

        for (WebElement author : allAuthors){
            String link = author.getAttribute("src");
            chatworkService.sendMessage(chatworkRoomId, "[toall]\n" + "Hãy bỏ tay khỏi bàn phím và cho vào trong quần (yaoming)\n" + link);
        }
        driver.close();
    }

}
