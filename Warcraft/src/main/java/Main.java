import interfaces.impl.Ember;
import interfaces.impl.Enigma;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergey on 14.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        Ember ember = (Ember) context.getBean("ember");
        ember.attack();

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Enigma enigma = ctx.getBean(Enigma.class);
        enigma.defence();
    }
}
