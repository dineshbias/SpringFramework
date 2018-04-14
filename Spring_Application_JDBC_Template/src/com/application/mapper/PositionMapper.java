/**
 * 
 */
package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.application.domain.Position;

/**
 * @author edinjos
 *
 */
public class PositionMapper implements RowMapper<Position> {

	public PositionMapper() {
		System.out.println(PositionMapper.class + " instantiated...");
	}

	@Override
	public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(Position.class + " mapRow... ");
		Position empPos = new Position();

		empPos.setId(rs.getInt("ID"));
		empPos.setName(rs.getString("NAME"));

		return empPos;
	}

}
