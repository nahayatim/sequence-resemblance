package sequenceresemblance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResemblanceTest {
    Resemblance resemblance =  new Resemblance();
    @Test
    void test(){
        assertEquals(11,resemblance.getSequence("ababaa"));
        assertEquals(3,resemblance.getSequence("aa"));
    }

}