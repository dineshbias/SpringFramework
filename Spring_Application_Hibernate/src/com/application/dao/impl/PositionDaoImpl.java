package com.application.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.application.dao.PositionDao;
import com.application.entity.Position;


@Repository("positionDao")
public class PositionDaoImpl implements PositionDao {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	public PositionDaoImpl() {
		System.out.println(PositionDaoImpl.class + " instantiated...");
	}

	@Override
	public List<Position> findAll() throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findAll...");

		String sql = "Select * FROM Employee_Position";

		List<Position> positions = jdbcTemplateObject.query(sql, new PositionMapper());

		System.out.println("Positions : " + positions.size());

		return positions;
	}

	@Override
	public List<Position> findByName(String name) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findByName...");

		String sql = "Select * FROM Employee_Position where NAME = ?";

		List<Position> positions = jdbcTemplateObject.query(sql, new PositionMapper(), name);

		System.out.println("Positions : " + positions.size());

		return positions;
	}

	@Override
	public Position findById(int id) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " findById...");

		String sql = "Select * FROM Employee_Position where id = ?";

		Position position = jdbcTemplateObject.queryForObject(sql, Position.class, id);

		System.out.println("Position retrieved with id: " + id);

		return position;
	}

	@Override
	public void delete(Position position) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " delete...");
		throw new Exception("Not implemented");

	}

	@Override
	public void insert(Position position) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " insert...");

		String sql = "insert into Employee_Position (name) values (?)";

		int count = jdbcTemplateObject.update(sql, position.getName());

		System.out.println(this.getClass().getCanonicalName() + count + " rows inserted ");

	}

	@Override
	public void update(Position position) throws Exception {
		System.out.println(this.getClass().getCanonicalName() + " update...");
		throw new Exception("Not implemented");

	}

}
