package com.maheshb.springbootkafkaintro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maheshb.springbootkafkaintro.entities.TagEntity;
import com.maheshb.springbootkafkaintro.repo.TagRepo;

@Service
public class TagService {

	@Autowired
	private TagRepo tagRepo;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void save(TagEntity tagEntity) {
		tagRepo.save(tagEntity);
	}

}
