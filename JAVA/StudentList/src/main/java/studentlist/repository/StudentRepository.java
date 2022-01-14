package studentlist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import studentlist.models.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student,Long> {

}
