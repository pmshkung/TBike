package tbike;

import java.io.Serializable;

/**
 *
 * @author Webb
 */
public class TBikeData implements Serializable {
    public String mType;
    public String mLat;
    public String mLon;
    
    public String mMarkerColor;
    public String mTitle;
    public String mAddress;
    public String mTel;
    public String mLocationType;
    public String mPicture;
    public String mIcon;
    public String mUrl;
    public String mAvailableCarCount;
    public String mAvailableSpaceCount;
    public String mFormat;
    public String mCode;
    public String mNormalFullSizeCar;
    public String mNormalMicrocar;
    public String mHandicapMicrocar;
    public String mMaternalAndChildMicrocar;
    public String mGreenEnergyMicrocar;
    public String mNormalScooter;
    public String mHandicapScooter;
    public String mChargeableTime;
    public String mRate;
    public String mUpdateTime;
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        result.append("Type"); result.append(":"); result.append(this.mType); result.append("\n");
        result.append("Lat"); result.append(":"); result.append(this.mLat); result.append("\n");
        result.append("Lon"); result.append(":"); result.append(this.mLon); result.append("\n");
        result.append(TBikeJson.TBikeProperty[0]); result.append(":"); result.append(this.mMarkerColor); result.append("\n");
        result.append(TBikeJson.TBikeProperty[1]); result.append(":");result.append(this.mTitle); result.append("\n");
        result.append(TBikeJson.TBikeProperty[2]); result.append(":");result.append(this.mAddress); result.append("\n");
        result.append(TBikeJson.TBikeProperty[3]); result.append(":");result.append(this.mTel); result.append("\n");
        result.append(TBikeJson.TBikeProperty[4]); result.append(":");result.append(this.mLocationType); result.append("\n");
        result.append(TBikeJson.TBikeProperty[5]); result.append(":");result.append(this.mPicture); result.append("\n");
        result.append(TBikeJson.TBikeProperty[6]); result.append(":");result.append(this.mIcon); result.append("\n");
        result.append(TBikeJson.TBikeProperty[7]); result.append(":");result.append(this.mUrl); result.append("\n");
        result.append(TBikeJson.TBikeProperty[8]); result.append(":");result.append(this.mAvailableCarCount); result.append("\n");
        result.append(TBikeJson.TBikeProperty[9]); result.append(":");result.append(this.mAvailableSpaceCount); result.append("\n");
        result.append(TBikeJson.TBikeProperty[10]); result.append(":");result.append(this.mFormat); result.append("\n");
        result.append(TBikeJson.TBikeProperty[11]); result.append(":");result.append(this.mCode); result.append("\n");
        result.append(TBikeJson.TBikeProperty[12]); result.append(":");result.append(this.mNormalFullSizeCar); result.append("\n");
        result.append(TBikeJson.TBikeProperty[13]); result.append(":");result.append(this.mNormalMicrocar); result.append("\n");
        result.append(TBikeJson.TBikeProperty[14]); result.append(":");result.append(this.mHandicapMicrocar); result.append("\n");
        result.append(TBikeJson.TBikeProperty[15]); result.append(":");result.append(this.mMaternalAndChildMicrocar); result.append("\n");
        result.append(TBikeJson.TBikeProperty[16]); result.append(":");result.append(this.mGreenEnergyMicrocar); result.append("\n");
        result.append(TBikeJson.TBikeProperty[17]); result.append(":");result.append(this.mNormalScooter); result.append("\n");
        result.append(TBikeJson.TBikeProperty[18]); result.append(":");result.append(this.mHandicapScooter); result.append("\n");
        result.append(TBikeJson.TBikeProperty[19]); result.append(":");result.append(this.mChargeableTime); result.append("\n");
        result.append(TBikeJson.TBikeProperty[20]); result.append(":");result.append(this.mRate); result.append("\n");
        result.append(TBikeJson.TBikeProperty[21]); result.append(":");result.append(this.mUpdateTime); result.append("\n");
        
        return result.toString();        
    }
}
