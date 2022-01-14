package studentlist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import studentlist.models.Info;

@Service
public interface InfoServices {

	List<Info> infoList();

	Info findInfo(long id);

	Info createInfo(Info info) throws Exception;

}
