package com.mypackage.gestion2.repo;

import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.web.command.SearchCommand;

import java.util.List;

public interface BaseRepository<T> {
	
	public T saveDomain(T command);
	
	public Page<T> getAll(int page, int size);
	
	public T getOne(Long id) ; 

	public void deleteDomain(Long id); 
	
	public Page<T> search(SearchCommand searchCommand); 

	public Long countAll();

	public List<T> listAll();

}
