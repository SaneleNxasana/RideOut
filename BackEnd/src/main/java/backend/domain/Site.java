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
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;
    private String reservationUrl;

    public Site() {    }

    public Long getId() {
        return id;
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

    public static class Builder{
        private Long id;
        private String name;
        private String url;
        private String reservationUrl;

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder url(String value){
            this.url = value;
            return this;
        }
        public Builder reservationUrl(String value){
            this.reservationUrl = value;
            return this;
        }

        public Builder copy(Site value){
            this.id = value.id;
            this.name = value.name;
            this.url = value.url;
            this.reservationUrl = value.reservationUrl;
            return this;
        }

        public Site build(){return new Site(this);}
    }

    public Site (Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.url = builder.url;
        this.reservationUrl = builder.reservationUrl;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Site site = (Site) obj;
         return  id == site.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
