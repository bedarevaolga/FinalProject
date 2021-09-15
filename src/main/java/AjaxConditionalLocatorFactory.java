//import java.util.function.Function;
//import org.openqa.selenium.SearchContext;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
//import org.openqa.selenium.support.pagefactory.ElementLocator;
//import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
//import java.lang.reflect.Field;
//
//public class AjaxConditionalLocatorFactory implements ElementLocatorFactory {
//
//    final SearchContext searchContext;
//    final int timeOutInSeconds;
//    final Function<WebElement, Boolean> condition;
//
//    public AjaxConditionalLocatorFactory(SearchContext searchContext,
//                                         int timeOutInSeconds,
//                                         Function<WebElement, Boolean> condition) {
//        this.searchContext = searchContext;
//        this.timeOutInSeconds = timeOutInSeconds;
//        this.condition = condition;
//    }
//
//    @Override
//    public ElementLocator createLocator(Field field) {
//        return new AjaxElementLocator(searchContext, field, timeOutInSeconds) {
//            @Override
//            protected boolean isElementUsable(WebElement element) {
//                return condition.apply(element);
//            }
//        };
//    }
//}