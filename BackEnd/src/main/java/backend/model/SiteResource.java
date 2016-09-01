package backend.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
public class SiteResource extends ResourceSupport {

    private Long idNumber;
    private String name;
    private String url;
    private String reservationUrl;

    public SiteResource() {}

    public Long getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getReservationUrl() {
        return reservationUrl;
    }

    public SiteResource(SiteResource.Builder builder){
        this.idNumber = builder.idNumber;
        this.name = builder.name;
        this.url = builder.url;
        this.reservationUrl = builder.reservationUrl;
    }

    public static class Builder{
        private Long idNumber;
        private String name;
        private String url;
        private String reservationUrl;

        public SiteResource.Builder idNumber(Long value){
            this.idNumber = value;
            return this;
        }
        public SiteResource.Builder name(String value){
            this.name = value;
            return this;
        }
        public SiteResource.Builder url(String value){
            this.url = value;
            return this;
        }
        public SiteResource.Builder reservationUrl(String value){
            this.reservationUrl = value;
            return this;
        }
        public SiteResource.Builder copy(SiteResource value){
            this.idNumber = value.idNumber;
            this.name = value.name;
            this.url = value.url;
            this.reservationUrl = value.reservationUrl;

            return this;
        }

        public SiteResource build() {
            return new SiteResource(this);
        }
    }
}
