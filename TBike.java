package tbike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Webb
 */
public class TBike {
    private static final int TIME_OUT = 120000;
    private static final String ACCEPT_ENCODING = "gzip, deflate";
    private static final String HOST = "tbike.tainan.gov.tw";
    private static final String ACCEPT = "*/*";
    private static final String ACCEPT_LANGUAGE = "zh-TW,zh;q=0.8,en-US;q=0.5,en;q=0.3";
    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:73.0) Gecko/20100101 Firefox/73.0";
    
    private static boolean jsonToData(final String jsonData) {
        boolean result = false;
        
        if (null != jsonData) {
            try {
                JSONObject object = new JSONObject(jsonData);
                if (null != object) {
                    JSONArray array = object.getJSONArray(TBikeJson.TBikeFeatures);
                    int length = array.length();
                    
                    System.out.print("All TBike Stop Numbers: ");
                    System.out.println(length);
                    
                    for (int i = 0; i < length; i++) {
                        JSONObject jsonObject = array.isNull(i) ? null : array.getJSONObject(i);
                        
                        if (null != jsonObject) {
                            TBikeData data = new TBikeData();
                            JSONObject jsonObject1 = jsonObject.isNull(TBikeJson.TBikeSingle[1]) ? null : jsonObject.getJSONObject(TBikeJson.TBikeSingle[1]);
                            if (null != jsonObject1) {
                                data.mType = jsonObject1.isNull(TBikeJson.TBikeGeometry[0]) ? "null" : jsonObject1.get(TBikeJson.TBikeGeometry[0]).toString();
                                
                                JSONArray jsonArray1 = jsonObject1.getJSONArray(TBikeJson.TBikeGeometry[1]);
                                if (2 == jsonArray1.length()) {
                                    data.mLon = jsonArray1.isNull(0) ? "0" : jsonArray1.get(0).toString();
                                    data.mLat = jsonArray1.isNull(1) ? "0" : jsonArray1.get(1).toString();
                                }
                            }                                                
                            
                            JSONObject jsonObject2 = jsonObject.isNull(TBikeJson.TBikeSingle[2]) ? null : jsonObject.getJSONObject(TBikeJson.TBikeSingle[2]);
                            if (null != jsonObject2) {
                                data.mMarkerColor = jsonObject2.isNull(TBikeJson.TBikeProperty[0]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[0]).toString();
                                data.mTitle = jsonObject2.isNull(TBikeJson.TBikeProperty[1]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[1]).toString();
                                data.mAddress = jsonObject2.isNull(TBikeJson.TBikeProperty[2]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[2]).toString();
                                data.mTel = jsonObject2.isNull(TBikeJson.TBikeProperty[3]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[3]).toString();
                                data.mLocationType = jsonObject2.isNull(TBikeJson.TBikeProperty[4]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[4]).toString();
                                data.mPicture = jsonObject2.isNull(TBikeJson.TBikeProperty[5]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[5]).toString();
                                data.mIcon = jsonObject2.isNull(TBikeJson.TBikeProperty[6]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[6]).toString();
                                data.mUrl = jsonObject2.isNull(TBikeJson.TBikeProperty[7]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[7]).toString();
                                data.mAvailableCarCount = jsonObject2.isNull(TBikeJson.TBikeProperty[8]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[8]).toString();
                                data.mAvailableSpaceCount = jsonObject2.isNull(TBikeJson.TBikeProperty[9]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[9]).toString();
                                data.mFormat = jsonObject2.isNull(TBikeJson.TBikeProperty[10]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[10]).toString();
                                data.mCode = jsonObject2.isNull(TBikeJson.TBikeProperty[11]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[11]).toString();
                                data.mNormalFullSizeCar = jsonObject2.isNull(TBikeJson.TBikeProperty[12]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[12]).toString();
                                data.mNormalMicrocar = jsonObject2.isNull(TBikeJson.TBikeProperty[13]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[13]).toString();
                                data.mHandicapMicrocar = jsonObject2.isNull(TBikeJson.TBikeProperty[14]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[14]).toString();
                                data.mMaternalAndChildMicrocar = jsonObject2.isNull(TBikeJson.TBikeProperty[15]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[15]).toString();
                                data.mGreenEnergyMicrocar = jsonObject2.isNull(TBikeJson.TBikeProperty[16]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[16]).toString();
                                data.mNormalScooter = jsonObject2.isNull(TBikeJson.TBikeProperty[17]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[17]).toString();
                                data.mHandicapScooter = jsonObject2.isNull(TBikeJson.TBikeProperty[18]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[18]).toString();
                                data.mChargeableTime = jsonObject2.isNull(TBikeJson.TBikeProperty[19]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[19]).toString();                                
                                data.mRate = jsonObject2.isNull(TBikeJson.TBikeProperty[20]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[20]).toString();
                                data.mUpdateTime = jsonObject2.isNull(TBikeJson.TBikeProperty[21]) ? "null" : jsonObject2.get(TBikeJson.TBikeProperty[21]).toString();
                            }
                            
                            System.out.println("Stop: " + (i + 1));
                            System.out.println(data);
                        }                        
                    }

                }                               
            }
            catch (JSONException e) {
                System.out.println(e.toString());
            }
        }
        
        return result;
    }

    private static String getTBike(HttpURLConnection conn, final String lat, final String lng) throws IOException {                
        String result = "", encoding, line;
        boolean gzipped;
        Reader reader;
        StringBuilder response;
        BufferedReader br;
        
        String mUrl = "https://tbike.tainan.gov.tw/Portal/zh-TW/Station/GetStations?lat=[LAT]&lng=[LNG]";
        mUrl = mUrl.replace("[LAT]", lat);
        mUrl = mUrl.replace("[LNG]", lng);
        
        conn = null;       
        try {
            URL url = new URL(mUrl);
            if (url.getProtocol().toLowerCase().equals("https")) {
                SSLSocketFactory.trustAllHosts();
                HttpsURLConnection https = (HttpsURLConnection)url.openConnection();

                if ( null != https ) {
                    https.setHostnameVerifier(SSLSocketFactory.DO_NOT_VERIFY);
                    conn = https;
                }
            } else {
                conn = (HttpURLConnection)url.openConnection();
            }

            if (null != conn) {
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setConnectTimeout(TIME_OUT);
                conn.setReadTimeout(TIME_OUT);
                conn.setRequestProperty("Accept-Encoding", ACCEPT_ENCODING);
                conn.setRequestProperty("host", HOST);
                conn.setRequestProperty("Accept", ACCEPT);
                conn.setRequestProperty("Accept-Language", ACCEPT_LANGUAGE);
                conn.setRequestProperty("User-Agent", USER_AGENT);
            
                conn.connect();
            
                encoding = conn.getHeaderField("Content-Encoding");
                gzipped = ((encoding != null) && (encoding.toLowerCase().contains("gzip")));    
                if (conn.getResponseCode() == 200) {
                    System.out.println("Get UBike Response Code OK.");
                    response = new StringBuilder();
                    if (gzipped) {
                        reader = new InputStreamReader(new GZIPInputStream(conn.getInputStream()), "UTF-8");
                    } else {
                        reader = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    }
                
                    br = new BufferedReader(reader);
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                
                    reader.close();
                    br.close();
        
                    result = response.toString();
                }
            }
        }
         catch (Exception ex) {
            System.out.println("Error Happen");
        }
        finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        
        return result;
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String tbikeJsonData;
        HttpURLConnection myConn = null;
        tbikeJsonData = getTBike(myConn, "22.9971157", "120.2126007");
        
        if (null != tbikeJsonData) {
            System.out.print("TBike Json Data: ");
            System.out.println(tbikeJsonData);
            
            jsonToData(tbikeJsonData);            
        }
    }
    
}
