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
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    private String duration;

    public Reservation() {    }

    public Reservation(Builder builder){
        this.id = builder.id;
        this.date = builder.date;
        this.duration = builder.duration;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }

    public static class Builder{
        private long id;
        private String date;
        private String duration;

        public Builder id(long value){
            this.id = value;
            return this;
        }
        public Builder date(String value){
            this.date = value;
            return this;
        }
        public Builder duration(String value){
            this.duration = value;
            return this;
        }

        public Builder copy(Reservation value){
            this.id = value.id;
            this.date = value.date;
            this.duration = value.duration;
            return this;
        }

        public Reservation build(){
            return new Reservation(this);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Reservation reservation = (Reservation) obj;

        return id == reservation.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
