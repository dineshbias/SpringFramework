/**
 * 
 */
package com.application.dao;

import java.util.List;

import com.application.domain.Position;

/**
 * @author edinjos
 *
 */
public interface PositionDao {

	public List<Position> findAll() throws Exception;

	public List<Position> findByName(String name) throws Exception;

	public Position findById(int id) throws Exception;

	public void insert(Position department) throws Exception;

	public void update(Position department) throws Exception;

	public void delete(Position position) throws Exception;

}
