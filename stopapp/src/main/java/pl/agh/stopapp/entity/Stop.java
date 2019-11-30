package pl.agh.stopapp.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "stop")
@EntityListeners(AuditingEntityListener.class)
public class Stop implements Serializable {

    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Transient
    private List<Next> nextList;

    @Override
    public String toString() {
        return "Stop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Next> getNextList() {
        return nextList;
    }

    public void setNextList(List<Next> nextList) {
        this.nextList = nextList;
    }
}
