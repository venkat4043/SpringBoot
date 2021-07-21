package com.spring.springweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.springweb.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

	List<Alien> findByAname(String aname);
	
	List<Alien> findByAnameOrderByAid(String aname);
		
	@Query("from Alien where aname= :name")
	List<Alien> find(@Param("name") String aname);
	
//	void deleteByID(int aid);
}
