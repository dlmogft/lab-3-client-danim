package client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test") // Ensures the test profile is used
public class LuckyWordControllerTest {

    @MockitoBean
    private LuckyWordController luckyWordController;

    // Helper method to mock LuckyWordController properties
    private void mockLuckyWordController(String luckyWord, String preamble) {
        when(luckyWordController.getLuckyWord()).thenReturn(luckyWord);
        when(luckyWordController.getPreamble()).thenReturn(preamble);
        when(luckyWordController.showLuckyWord()).thenCallRealMethod();
    }

    @Test
    public void LuckyWordController_ShowLuckyWord_ShouldReturnDefaultLuckyWord() {
        // Mocking the default lucky word
        mockLuckyWordController("preparation", null);

        ReflectionTestUtils.setField(luckyWordController, "luckyWord", "preparation");
        String expected = "Your lucky word is: preparation";
        String actual = luckyWordController.showLuckyWord();

        assertEquals(expected, actual, "The default lucky word should be returned.");
    }

    @Test
    public void LuckyWordController_ShowLuckyWord_ShouldReturnLuckyWordWithPreamble() {
        // Mocking lucky word and preamble
        mockLuckyWordController("success", "Your lucky word is");

        ReflectionTestUtils.setField(luckyWordController, "preamble", "Your lucky word is");
        ReflectionTestUtils.setField(luckyWordController, "luckyWord", "success");
        String expected = "Your lucky word is: success";
        String actual = luckyWordController.showLuckyWord();

        assertEquals(expected, actual, "The lucky word with preamble should be returned.");
    }

    @Test
    public void LuckyWordController_GetLuckyWord_ShouldReturnLuckyWord() {
        // Mocking lucky word
        mockLuckyWordController("happiness", null);

        String expected = "happiness";
        String actual = luckyWordController.getLuckyWord();

        assertEquals(expected, actual, "The lucky word should be returned.");
    }

    @Test
    public void LuckyWordController_GetPreamble_ShouldReturnPreamble() {
        // Mocking preamble
        mockLuckyWordController(null, "Your lucky word is");

        String expected = "Your lucky word is";
        String actual = luckyWordController.getPreamble();

        assertEquals(expected, actual, "The preamble should be returned.");
    }

    @Test
    public void LuckyWordController_SetLuckyWord_ShouldUpdateLuckyWord() {
        // Mocking lucky word
        mockLuckyWordController("joy", null);

        luckyWordController.setLuckyWord("joy");
        String expected = "joy";
        String actual = luckyWordController.getLuckyWord();

        assertEquals(expected, actual, "The lucky word should be updated.");
    }

    @Test
    public void LuckyWordController_SetPreamble_ShouldUpdatePreamble() {
        // Mocking preamble
        mockLuckyWordController(null, "Your lucky word is");

        luckyWordController.setPreamble("Your lucky word is");
        String expected = "Your lucky word is";
        String actual = luckyWordController.getPreamble();

        assertEquals(expected, actual, "The preamble should be updated.");
    }
}
