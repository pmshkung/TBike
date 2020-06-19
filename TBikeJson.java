package tbike;

/**
 *
 * @author Webb
 */
public class TBikeJson {
    private TBikeJson() {
        throw new AssertionError();
    }
        
    public static final String TBikeFeatures = "features";
    
    public static final String TBikeSingle[] = {
            "type",
            "geometry",
            "properties",
    };

    public static final String TBikeGeometry[] = {
            "type",
            "coordinates",
    };

    public static final String TBikeProperty[] = {
            "markerColor",
            "title",
            "address",
            "tel",
            "locationType",
            "picture",
            "icon",
            "url",
            "avaliableCarCount",
            "avaliableSpaceCount",
            "format",
            "code",
            "normalFullSizeCar",
            "normalMicrocar",
            "handicapMicrocar",
            "maternalAndChildMicrocar",
            "greenEnergyMicrocar",
            "normalScooter",
            "handicapScooter",
            "chargeableTime",
            "rate",
            "updateTime",
    };    
}
