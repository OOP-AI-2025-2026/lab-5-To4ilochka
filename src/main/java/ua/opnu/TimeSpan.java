package ua.opnu;

public class TimeSpan {

    private final int hours;
    private final int minutes;

    public TimeSpan(int hours, int minutes) {
        int totalMinutes = (hours * 60) + minutes;

        if (totalMinutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }

    public TimeSpan(int minutes) {
        this(0, minutes);
    }

    public TimeSpan() {
        this(0, 0);
    }

    public TimeSpan(TimeSpan other) {
        if (other != null) {
            this.hours = other.hours;
            this.minutes = other.minutes;
        } else {
            this.hours = 0;
            this.minutes = 0;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getTotalHours() {
        return this.hours + this.minutes / 60.0;
    }

    public int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    public TimeSpan add(int hours, int minutes) {
        int newTotalMinutes = this.getTotalMinutes() + (hours * 60) + minutes;
        return new TimeSpan(0, newTotalMinutes);
    }

    public TimeSpan add(int minutes) {
        return this.add(0, minutes);
    }

    public TimeSpan add(TimeSpan timespan) {
        if (timespan == null) {
            return this;
        }
        return this.add(timespan.getHours(), timespan.getMinutes());
    }

    public TimeSpan subtract(TimeSpan span) {
        if (span == null) {
            return this;
        }

        int totalCurrent = this.getTotalMinutes();
        int totalOther = span.getTotalMinutes();

        if (totalOther >= totalCurrent) {
            return new TimeSpan(0, 0);
        }

        int result = totalCurrent - totalOther;
        return new TimeSpan(0, result);
    }

    public TimeSpan subtract(int hours, int minutes) {
        int totalMinutesToSubtract = (hours * 60) + minutes;
        if (totalMinutesToSubtract < 0) {
            return this.add(0, -totalMinutesToSubtract);
        }

        int totalCurrent = this.getTotalMinutes();
        if (totalMinutesToSubtract >= totalCurrent) {
            return new TimeSpan(0, 0);
        }

        return new TimeSpan(0, totalCurrent - totalMinutesToSubtract);
    }

    public TimeSpan subtract(int minutes) {
        return this.subtract(0, minutes);
    }

    public TimeSpan scale(int factor) {
        if (factor <= 0) {
            return new TimeSpan(0, 0);
        }

        int totalMinutes = getTotalMinutes() * factor;
        return new TimeSpan(0, totalMinutes);
    }

    @Override
    public String toString() {
        return String.format("%d h. %02d min.", this.hours, this.minutes);
    }
}