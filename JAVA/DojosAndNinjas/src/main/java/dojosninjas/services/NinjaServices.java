package dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dojosninjas.models.Ninja;

@Service
public interface NinjaServices {

	Ninja createNinja(Ninja ninja) throws Exception;

	List<Ninja> ninjaList();

	Ninja findNinja(long id);

	List<Ninja> ninjasbyDojo(long id);

}
