package backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
@Entity
public class System implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String userDetails;
    private String reservationDetails;

    public System() {    }

    public Long getId() {
        return id;
    }

    public String getUserDetails() {
        return userDetails;
    }

    public String getReservationDetails() {
        return reservationDetails;
    }

    public static class Builder{
        private Long id;
        private String userDetails;
        private String reservationDetails;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder userDetails(String value){
            this.userDetails = value;
            return this;
        }
        public Builder reservationDetails(String value){
            this.reservationDetails = value;
            return this;
        }

        public Builder copy(System value){
            this.id = value.id;
            this.userDetails = value.userDetails;
            this.reservationDetails = value.reservationDetails;
            return this;
        }

        public System build() {return new System(this);}
    }

    public System(Builder builder){
        this.id = builder.id;
        this.userDetails = builder.userDetails;
        this.reservationDetails = builder.reservationDetails;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        System system = (System) obj;

        return id == system.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
