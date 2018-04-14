/**
 * 
 */
package com.application.dao;

import java.util.List;

/**
 * @author edinjos
 *
 */
public interface GenericDao<T> {

	public List<T> findAll() throws Exception;
	
	public T find(T domain) throws Exception;
	
	public void saveOrUpdate(T domain) throws Exception;
	
	public void delete(T domain) throws Exception;
	
}
