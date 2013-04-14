package domain;

public class DevScoreTrend {
    private String first;
    private String second;
    private String third;
    private String fourth;

    public void setFirst(String first) {
        this.first = first;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFirstWeek() {
        return first;
    }

    public String getFourthWeek() {
        return fourth;
    }

    public String getThirdWeek() {
        return third;
    }

    public String getSecondWeek() {
        return second;
    }
}
