package client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller read the value from the lucky-word property
 * placed in the yml file in a Git repository read by the server project
 *
 * A default value is set just in case the server project is not started
 */
@RestController
public class LuckyWordController {

    /**
     * The default value is specified
     */
    @Value("${lucky-word:preparation}") String luckyWord;

    @GetMapping("/lucky-word")
    public String showLuckyWord() {
        return "The lucky word is: " + luckyWord;
    }

}
