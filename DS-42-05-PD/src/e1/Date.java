package e1;

import java.util.Objects;

public class Date {

    private int day;
    private int month;
    private int year;

    Date(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            throw new IllegalArgumentException();
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) { this.day = day; }
    public int getDay() { return day; }

    public void setMonth(int month) { this.month = month; }
    public int getMonth() { return month; }

    public void setYear(int year) { this.year = year; }
    public int getYear() { return year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Date date = (Date) o;
        return getDay() == date.getDay() && getMonth() == date.getMonth() && getYear() == date.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDay(), getMonth(), getYear());
    }
}
