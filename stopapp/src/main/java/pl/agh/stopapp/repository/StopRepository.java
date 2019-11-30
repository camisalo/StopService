package pl.agh.stopapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.agh.stopapp.entity.Stop;

@Repository
public interface StopRepository extends CrudRepository<Stop, Integer> {

    Stop findStopByName(String name);
    Stop findStopById(Integer id);

}
