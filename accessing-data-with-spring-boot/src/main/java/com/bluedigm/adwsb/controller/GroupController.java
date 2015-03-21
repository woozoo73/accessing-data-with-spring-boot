package com.bluedigm.adwsb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluedigm.adwsb.BaseComponent;
import com.bluedigm.adwsb.domain.Group;
import com.bluedigm.adwsb.service.MemberService;

@Controller
@RequestMapping("/groups")
public class GroupController extends BaseComponent {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		List<Group> groups = memberService.listGroup();
		model.addAttribute("groups", groups);

		return "group/list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Integer id, Model model) {
		Group group = memberService.getGroup(id);
		model.addAttribute("group", group);

		return "group/view";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Group group) {
		return "group/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String create(@ModelAttribute Group group) {
		memberService.createGroup(group);

		return "redirect:/groups";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String updateForm(@PathVariable Integer id, Model model) {
		Group group = memberService.getGroup(id);
		model.addAttribute("group", group);

		return "group/edit";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String update(@ModelAttribute Group group) {
		memberService.updateGroup(group);

		return "redirect:/groups";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer id) {
		memberService.deleteGroup(id);

		return "redirect:/groups";
	}

}
