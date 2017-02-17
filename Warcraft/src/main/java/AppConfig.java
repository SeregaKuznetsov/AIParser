import interfaces.impl.Enigma;
import interfaces.impl.Orchid;
import interfaces.impl.ShivaGuard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Enigma enigma() {
        Enigma enigma = new Enigma();
        enigma.setArmor(shivaGuard());
        enigma.setWeapon(orchid());
        return enigma;
    }

    @Bean
    public ShivaGuard shivaGuard() {
        ShivaGuard shivaGuard = new ShivaGuard();
        return shivaGuard;
    }

    @Bean
    public Orchid orchid() {
        Orchid orchid = new Orchid();
        return orchid;
    }
}
