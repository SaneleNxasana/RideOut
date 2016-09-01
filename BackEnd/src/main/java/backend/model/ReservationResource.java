package backend.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
public class ReservationResource extends ResourceSupport {

    private Long idNumber;
    private String date;
    private String duration;

    public ReservationResource() {    }

    public Long getIdNumber() {
        return idNumber;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }

    public ReservationResource(ReservationResource.Builder builder){
        this.idNumber = builder.idNumber;
        this.date = builder.date;
        this.duration = builder.duration;
    }

    public static class Builder {
        private Long idNumber;
        private String date;
        private String duration;

        public ReservationResource.Builder idNumber(Long value){
            this.idNumber = value;
            return this;
        }
        public ReservationResource.Builder date(String value){
            this.date = value;
            return this;
        }
        public ReservationResource.Builder duration(String value){
            this.duration = value;
            return this;
        }
        public ReservationResource.Builder copy(ReservationResource value){
            this.idNumber = value.idNumber;
            this.date = value.date;
            this.duration = value.duration;

            return this;
        }

        public ReservationResource build(){
            return new ReservationResource(this);
        }
    }
}
