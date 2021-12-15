package e1;

public class Date {

    private final int day;
    private final int month;
    private final int year;

    Date(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 0) {
            throw new IllegalArgumentException();
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() { return day; }

    public int getMonth() { return month; }

    public int getYear() { return year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Date date = (Date) o;
        return getDay() == date.getDay() && getMonth() == date.getMonth() && getYear() == date.getYear();
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
