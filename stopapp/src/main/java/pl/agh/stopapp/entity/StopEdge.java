package pl.agh.stopapp.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "stopedge")
@EntityListeners(AuditingEntityListener.class)
public class StopEdge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "stop1", nullable = false)
    private Integer stop1;

    @Column(name = "stop2", nullable = false)
    private Integer stop2;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStop1() {
        return stop1;
    }

    public void setStop1(Integer stop1) {
        this.stop1 = stop1;
    }

    public Integer getStop2() {
        return stop2;
    }

    public void setStop2(Integer stop2) {
        this.stop2 = stop2;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}