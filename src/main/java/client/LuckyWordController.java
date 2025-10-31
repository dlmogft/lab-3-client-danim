package client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller read the value from the lucky-word property
 * placed in the yml file in a Git repository read by the server project
 *
 * A default value is set just in case the server project is not started
 */
@RestController
@ConfigurationProperties(prefix="word-config")
public class LuckyWordController {

    /**
     * This is the config by default for lab-3
     */
    /*@Value("${lucky-word:preparation}") String luckyWord;

    @GetMapping("/lucky-word")
    public String showLuckyWord() {
        return "The lucky word is: " + luckyWord;
    }*/

    /**
     * This is the config for lab-5 (spring cloud bus)
     */
    String luckyWord;
    String preamble;

    @GetMapping("/lucky-word")
    public String showLuckyWord() {
        return preamble + ": " + luckyWord;
    }

    public String getLuckyWord() {
        return luckyWord;
    }

    public void setLuckyWord(String luckyWord) {
        this.luckyWord = luckyWord;
    }

    public String getPreamble() {
        return preamble;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }

}
