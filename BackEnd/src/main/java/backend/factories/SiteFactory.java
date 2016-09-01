package backend.factories;

import backend.domain.Site;

import java.util.Map;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
public class SiteFactory {
    public static Site createSite(Map<String, String> values, String reservationUrl)
    {
        Site site = new Site.Builder()
                .name(values.get("name"))
                .url("url")
                .reservationUrl("reservationUrl")
                .build();
        return site;
    }
}
