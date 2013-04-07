package domain;

import java.util.Comparator;

public class ComparatorPeople implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        People p1 = (People)o1;
        People p2 = (People)o2;

        return p1.getScore() - p2.getScore();
    }
}
