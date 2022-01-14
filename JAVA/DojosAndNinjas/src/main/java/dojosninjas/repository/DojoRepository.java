package dojosninjas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dojosninjas.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

}
