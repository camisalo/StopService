package pl.agh.stopapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.agh.stopapp.entity.StopEdge;

import java.util.List;

@Repository
public interface StopEdgeRepository extends CrudRepository<StopEdge, Integer> {

    List<StopEdge> findByStop1OrStop2(Integer stop1, Integer stop2);

}
