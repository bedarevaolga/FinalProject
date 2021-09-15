//import org.openqa.selenium.WebElement;
//import java.util.function.Function;
//import java.util.regex.Pattern;
//
//public class MyConditions {
//
//    public static Function<WebElement, Boolean> elementIsVisibleAndEnabled(){
//        return webElement -> webElement.isDisplayed() && webElement.isEnabled();
//    }
//
//    public static Function<WebElement, Boolean> elementTextCorrespondsToAPattern(String artistName, String  songName){
//        return webElement -> {
//            String elementText = webElement.getText();
//            if(elementText.contains(artistName)&& elementText.contains(songName)){
//                return true;
//            }else{
//                return false;
//            }
//        };
//    }
//
//}