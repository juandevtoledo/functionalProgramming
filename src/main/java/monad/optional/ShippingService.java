
package monad.optional;

import monad.optional.dto.TrackingInfo;

interface ShippingService {
    TrackingInfo findTrackingInfoByTrackingId(String trackingId);
}