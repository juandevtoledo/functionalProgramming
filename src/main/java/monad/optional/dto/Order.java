package monad.optional.dto;

public class Order {
    private final String trackingId;

    Order(String trackingId) {
        this.trackingId = trackingId;
    }

    public boolean hasTrackingId() {
        return trackingId != null;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public static Order defaultOrder(){
        return new Order("1");
    }
}
