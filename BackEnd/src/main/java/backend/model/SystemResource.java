package backend.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
public class SystemResource extends ResourceSupport {

    private Long idNumber;
    private String userDetails;
    private String reservationDetails;

    public SystemResource(){}

    public Long getIdNumber() {
        return idNumber;
    }

    public String getUserDetails() {
        return userDetails;
    }

    public String getReservationDetails() {
        return reservationDetails;
    }

    public SystemResource(SystemResource.Builder builder){
        this.idNumber = builder.idNumber;
        this.userDetails = builder.userDetails;
        this.reservationDetails = builder.reservationDetails;
    }

    public static class Builder {
        private Long idNumber;
        private String userDetails;
        private String reservationDetails;

        public SystemResource.Builder idNumber(Long value){
            this.idNumber = value;
            return this;
        }
        public SystemResource.Builder userDetails(String value){
            this.userDetails = value;
            return this;
        }
        public SystemResource.Builder reservationDetails(String value){
            this.reservationDetails = value;
            return this;
        }
        public SystemResource.Builder copy(SystemResource value){
            this.idNumber = value.idNumber;
            this.userDetails = value.userDetails;
            this.reservationDetails = value.reservationDetails;

            return this;
        }

        public SystemResource build(){
            return new SystemResource(this);
        }
    }
}
