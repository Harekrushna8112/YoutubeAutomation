package demo.wrappers;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static String navigateToUrl(WebDriver driver){
        
            String url ="https://www.youtube.com/";
            driver.get(url);
            String conformUrl = driver.getCurrentUrl();
            if (conformUrl.equals(url)) {
                System.out.println("Yes I am in that url...");
            }else{
                System.out.println("No I am not in that url...");
            }
        return conformUrl;
    }
    public static void clickOnElement(WebDriver driver,By locator){
        Boolean success;
        try{
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement clickElement = driver.findElement(locator);
            clickElement.click();
            success= true;
        }catch(Exception e){
            System.out.println("not clicked");
            success= false;
        }
    }

    public static Boolean PrintMsgInAbout(WebDriver driver){
        Boolean success;
        try{
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ytabout__content']")));
            WebElement message = driver.findElement(By.xpath("//section[@class='ytabout__content']"));
            String aboutMsg = message.getText();
            System.out.println("The About Message is   :   "+aboutMsg);
            success=true;
        }catch(Exception e){
            success= false;
        }
        return success;
    }
    
    public static Boolean nextButton(WebDriver driver,By locator){
        Boolean success;
        try{
            WebElement next = driver.findElement(locator);
            while (next.isDisplayed()) {
                next.click();
                Thread.sleep(3000);
            }
            
            success=true;

        }catch(Exception e){
            success=false;
        }
        return success;
    }

    public static String veryfy(WebDriver driver,By locator){
        
            java.util.List<WebElement> videos= driver.findElements(locator);
            WebElement lastVideoA = null;
            for(int i =0 ; i<=videos.size();i++){
                if(i==videos.size()-1){
                    lastVideoA=videos.get(i);
                }
            }
            String videoLastA=lastVideoA.getText();
            System.out.println(videoLastA);
            if(videoLastA.equals("U")){
                System.out.println("Last video is marked as U");
            }else{
                System.out.println("Last video is not marked as U");
            }
        
        return videoLastA;
    }

    public static String veryfyType(WebDriver driver,By locator){

            java.util.List<WebElement> videos= driver.findElements(locator);
            WebElement lastVideoA = null;
            Boolean isshowing=false;
            for(int i =0 ; i<=videos.size();i++){
                if(i==videos.size()-1){
                    lastVideoA=videos.get(i);   
                }
            }
            isshowing=lastVideoA.isDisplayed();
            System.out.println("Is catagory showing  : "+isshowing);
            String videoLastA=lastVideoA.getText();
            // System.out.println(videoLastA);
            String extract = videoLastA.split(" ")[0];
            System.out.println(extract);
            if (extract.isEmpty()){
                System.out.println("Catagory not mentioned");
            }else if(extract.equals("Comedy")){
                System.out.println("Catagory is mentioned as "+extract);
            }else if(extract.equals("Animation")){
                System.out.println("Catagory is mentioned as "+extract);
            }else if(extract.equals("Drama")){
                System.out.println("Catagory is mentioned as "+extract);
            }else{
                System.out.println("It have another catagory...");
            }
            
        return extract;
    }
    public static Boolean printTitle(WebDriver driver,By locator){
        Boolean success;
        try{
            java.util.List<WebElement> videos= driver.findElements(locator);
            WebElement lastMusicListTitle = null;
            for(int i =0 ; i<=videos.size();i++){
                if(i==videos.size()-1){
                    lastMusicListTitle=videos.get(i);
                }
            }
            String lastMusicListTitleText=lastMusicListTitle.getText();
            System.out.println(lastMusicListTitleText);
            
            success=true;

        }catch(Exception e){
            success=false;
        }
        return success;
    }
    public static Boolean musicTracks(WebDriver driver,By locator){
        Boolean success;
            java.util.List<WebElement> videos= driver.findElements(locator);
            WebElement lastMusicListTrack = null;
            for(int i =0 ; i<=videos.size();i++){
                if(i==videos.size()-1){
                    lastMusicListTrack=videos.get(i);
                }
            }
            String lastMusicListTrackText=lastMusicListTrack.getText();
            System.out.println(lastMusicListTrackText);
            String numaricString = lastMusicListTrackText.replaceAll("\\D", "");
            int Tracks = Integer.parseInt(numaricString);
            System.out.println(Tracks);
            if(Tracks <=50){
                success=true;
                System.out.println("Tracks are <= to 50"+" That is "+ Tracks);
            }else{
                success=false;
                System.out.println("Tracks are > to 50"+" That is "+ Tracks);
            }
        return success;
        
    }

    public static boolean titleOfNews(WebDriver driver,By locator){
        Boolean success;
        try{
            java.util.List<WebElement> newstytles = driver.findElements(locator);
            int count = 0;
            for(int i =0; i<3;i++){
                String tytleIs = newstytles.get(i).getText();
                count++;
                System.out.println(count+". The tytle is : "+tytleIs);
            }
            success=true;
        }catch(Exception e){
            success=false;
        }
        return success;
    }

    public static boolean bodyOfNews(WebDriver driver,By locator){
        Boolean success;
        try{
            java.util.List<WebElement> newsbody = driver.findElements(locator);
            int count =0;
            for(int i =0; i<3;i++){
                String bodyIs = newsbody.get(i).getText();
                count++;
                System.out.println(count+". The Body is : "+bodyIs);
            }
            success=true;
        }catch(Exception e){
            success=false;
        }
        return success;
    }

    public static boolean likeCountOfNews(WebDriver driver,By locator){
        Boolean success;
        try{
            java.util.List<WebElement> newslikescount = driver.findElements(locator);
            int count =0;
            for(int i =0; i<3;i++){
                String likes = newslikescount.get(i).getText();
                String numaricString=likes.replaceAll("\\D", "");
                int like = Integer.parseInt(numaricString);
                count = count+like;
                System.out.println(like);
            }
            System.out.println("The total Likes are : "+count);
            success=true;
        }catch(Exception e){
            success=false;
        }
        return success;
    }
    public static void sendkeys(WebDriver driver,String name){
        try{
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Search'])[1]")));
            WebElement input = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
            input.clear();
            input.sendKeys(name);
            Thread.sleep(5000);
            System.out.println("Text Entered : "+name);
            input.sendKeys(Keys.ENTER);
        }catch(Exception e){
            e.getMessage();
        }
    }

    public static boolean countview(WebDriver driver,By locator) throws InterruptedException{
        Boolean success;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long totalViews = 0;
        while (totalViews < 1000000){
            java.util.List<WebElement>viewElements=driver.findElements(locator);
            for (WebElement viewElement : viewElements) {
                String viewText = viewElement.getText();
                System.out.println(viewText);
                String extract = viewText.split(" ")[0];
                System.out.println(extract);
                String contentView = extract.trim(); 
                System.out.println(contentView);
                long views = convertNumeric(contentView);
                System.out.println(views);
                // totalViews += views;

                if (totalViews < 1000000) {
                    totalViews += views;
                    System.out.println("Total views");
                }else if(totalViews >= 1000000){
                    System.out.println("Total views are grater then 10cr");
                    break;
                }
            }
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(2000);
            
    }
    System.out.println("Total views reached: "+totalViews);
    success=true;
    return success;

}

    public static long convertNumeric(String value){
        value = value.trim().toUpperCase();
            char lastChar= value.charAt(value.length()-1);
            int multiplier =1;
            switch (lastChar) {
                case 'K':
                    multiplier=1000;
                    break;
                case 'M':
                    multiplier= 1000000;
                    break;
                case 'B':
                    multiplier=1000000000;
                    break;
                default:
                     if (Character.isDigit(lastChar)){
                        return Long.parseLong(value);
                     }
                    throw new IllegalArgumentException("Invalid format : "+ value);
            }
            String numaricPart = value.substring(0, value.length()-1);
            double number = Double.parseDouble(numaricPart);
            return (long) (number*multiplier);
    }

}

//ytd-video-renderer[contains(@class,'section-renderer')]
//ytd-video-renderer[contains(@class,'section-renderer')]//following-sibling::div[@id='metadata-line']/span[1]