package stepthree;

import java.util.List;
import java.util.stream.Collectors;

public class CalHistory {

    private final List<Double> results;

    public CalHistory(List<Double> results) {
        this.results = results;
    }

    public List<Double> getGreaterThan(double value) {
        return results.stream()
                .filter(result -> result > value)
                .collect(Collectors.toList());
    }

    public List<Double> getDistinctSortedResults() {
        return results.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
