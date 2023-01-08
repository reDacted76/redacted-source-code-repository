public class Asset {

    private long id;
    private long time;
    private String name;
    private double open;
    private double high;
    private double low;
    private double close;
    private double adjClosed;
    private double volume;

    public Asset(long id) {
        this.id = id;
    }

    public Asset(long time, String name, double open, double high, double low, double close, double adjClosed, double volume) {
        this.time = time;
        this.name = name;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjClosed = adjClosed;
        this.volume = volume;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getAdjClosed() {
        return adjClosed;
    }

    public void setAdjClosed(double adjClosed) {
        this.adjClosed = adjClosed;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", time=" + time +
                ", name='" + name + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", adjClosed=" + adjClosed +
                ", volume=" + volume +
                '}';
    }
}
