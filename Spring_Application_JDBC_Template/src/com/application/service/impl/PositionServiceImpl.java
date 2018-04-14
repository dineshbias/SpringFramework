package com.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.dao.PositionDao;
import com.application.domain.Position;
import com.application.service.PositionService;

@Service("positionService")
public class PositionServiceImpl implements PositionService {

	@Autowired
	PositionDao positionDao;

	@Override
	public List<Position> findAll() throws Exception {
		return positionDao.findAll();
	}

	@Override
	public List<Position> findByName(String name) throws Exception {
		return positionDao.findByName(name);
	}

	@Override
	public Position findById(int id) throws Exception {
		return positionDao.findById(id);
	}

	@Override
	public void insert(Position position) throws Exception {
		positionDao.insert(position);

	}

	@Override
	public void update(Position position) throws Exception {
		positionDao.update(position);
	}

	@Override
	public void delete(Position position) throws Exception {
		positionDao.delete(position);

	}

}
