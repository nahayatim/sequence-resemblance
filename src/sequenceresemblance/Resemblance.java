package sequenceresemblance;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Resemblance {

    public Long getSequence(String sentence) {
        return IntStream.range(0, sentence.length())
                .boxed()
                .map(i -> getSubString(sentence, sentence.length(), i))
                .collect(Collectors.toMap(o -> o, s -> sentence))
                .entrySet().stream()
                .map(map -> getDeference(map))
                .reduce(0L, (e1, e2) -> e1 + e2);
    }

    private long getDeference(Map.Entry<String, String> map) {
        return IntStream.range(0, map.getKey().length())

                .boxed()
                .takeWhile(i -> map.getKey().charAt(i) == map.getValue().charAt(i))
                .count();
    }

    private String getSubString(String sentence, int length, Integer i) {
        return sentence.substring(i, length);
    }
}
