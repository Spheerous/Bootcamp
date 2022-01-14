package dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dojosninjas.models.Dojo;

@Service
public interface DojoServices {

	List<Dojo> dojoList();

	Dojo findDojo(long id);

	Dojo createDojo(Dojo dojo) throws Exception;

}
