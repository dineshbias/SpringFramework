/**
 * 
 */
package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.application.dto.PositionDto;
import com.application.service.PositionService;

/**
 * @author edinjos
 *
 */
@Controller
@RequestMapping("/position")
public class PositionProfileController {

	@Autowired
	private PositionService positionService;

	public PositionProfileController() {
		System.out.println(PositionProfileController.class + " instantiated....");
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		System.out.println(PositionProfileController.class + " mainPage....");
		return "profiles/main";
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView position() {
		System.out.println(PositionProfileController.class + " position....");

		return new ModelAndView("profiles/profile", "command", new PositionDto());

	}

	@RequestMapping(method = RequestMethod.POST, value = "addPosition")
	public ModelAndView addPosition(ModelMap model, @ModelAttribute PositionDto position) {
		System.out.println(PositionProfileController.class + " addPosition....");

		try {
			positionService.insert(position);

			System.out.println(PositionProfileController.class + " addProfile completed ....");

		} catch (Exception e) {
			System.out.println(PositionProfileController.class + " addProfile..." + e);

			return new ModelAndView("errorPage", "message", "Error adding Profile to database");
		}

		model.addAttribute("name", position.getName());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("profiles/createSuccess");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.GET, value = "list")
	public ModelAndView listPositions(ModelMap model) {
		System.out.println(PositionProfileController.class + " listPositions....");
		List<Position> positions = null;
		try {

			positions = positionService.findAll();
			for (Position position : positions) {
				System.out.println(position.getId() + "--" + position.getName());
			}
			System.out.println(PositionProfileController.class + " listPositions completed ....");

		} catch (Exception e) {
			System.out.println(PositionProfileController.class + " listPositions..." + e);
			return new ModelAndView("errorPage", "message", "Error fetching Positions from Database");
		}

		if (null == positions || positions.isEmpty()) {
			return new ModelAndView("errorPage", "message", "No Positions Found");
		}

		model.addAttribute("Positions", positions);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("position/positions");
		return modelAndView;
	}

}
