package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.TitleService;
import kodlama.io.hrms.dataAccess.abstracts.TitleDao;
import kodlama.io.hrms.entities.concretes.Title;

@Service
public class TitleManager implements TitleService{

	private TitleDao titleDao;
	
	
	
	@Autowired
	public TitleManager(TitleDao titleDao) {
		super();
		this.titleDao = titleDao;
	}




	@Override
	public List<Title> getAll() {
		return titleDao.findAll();
	}

}
