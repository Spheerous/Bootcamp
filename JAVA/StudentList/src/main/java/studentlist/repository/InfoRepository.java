package studentlist.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import studentlist.models.Info;
@Repository
public interface InfoRepository extends CrudRepository <Info,Long> {

}
