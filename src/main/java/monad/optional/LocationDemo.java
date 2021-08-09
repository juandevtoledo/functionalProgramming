package monad.optional;

import monad.optional.dto.Order;
import monad.optional.dto.TrackingInfo;

import java.util.Optional;

//Use Case:

/**
 * Find Current Localtion By OderId
 * An order should have a tracking id for us to be able to tell the current location.
 * If location information cannot be found then return No location found.
 */
public class LocationDemo {

    private final OrderService orderService;
    private final ShippingService shippingService;

    public LocationDemo() {
        this.orderService = orderId -> null;
        this.shippingService = trackingId -> null;
    }

    private String getCurrentLocationOfOrderWithId_Functional(String orderId) {
        return Optional.ofNullable(orderId)
                .map(orderService::findOrderByOrderId)
                .filter(Order::hasTrackingId)
                .map(Order::getTrackingId)
                .map(shippingService::findTrackingInfoByTrackingId)
                .map(TrackingInfo::getCurrentLocation)
                .orElse("No location found");
    }

    private String getCurrentLocationOfOrderWithId_Imperative(String orderId) {
        if (orderId != null) {
            Order order = orderService.findOrderByOrderId(orderId);
            if (order != null && order.hasTrackingId()) {
                TrackingInfo trackingInfo =
                        shippingService.findTrackingInfoByTrackingId(order.getTrackingId());

                if (trackingInfo != null) {
                    return trackingInfo.getCurrentLocation();
                }
            }
        }
        return "No location found";
    }

    public static void main(String... args) {
        LocationDemo demo = new LocationDemo();
        System.out.println(" Functional Way " + demo.getCurrentLocationOfOrderWithId_Functional("1"));
        System.out.println(" Imperative Way " + demo.getCurrentLocationOfOrderWithId_Imperative("1"));
    }
}
