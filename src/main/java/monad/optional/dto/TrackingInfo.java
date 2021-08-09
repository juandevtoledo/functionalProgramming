
package monad.optional.dto;

public class TrackingInfo {
    private final String currentLocation;

    TrackingInfo(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public static TrackingInfo defaultTrakingInfo(){
        return new TrackingInfo("Bogota - DC ");
    }
}