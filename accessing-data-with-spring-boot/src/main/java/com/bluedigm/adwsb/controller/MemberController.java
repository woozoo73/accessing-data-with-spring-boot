package com.bluedigm.adwsb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bluedigm.adwsb.BaseComponent;
import com.bluedigm.adwsb.domain.Group;
import com.bluedigm.adwsb.domain.Member;
import com.bluedigm.adwsb.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController extends BaseComponent {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		List<Member> members = memberService.listMember();
		model.addAttribute("members", members);

		return "member/list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable String id, Model model) {
		Member member = memberService.getMember(id);
		model.addAttribute("member", member);

		return "member/view";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Member member) {
		return "member/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String create(@Valid Member member, BindingResult result) {
		if (member.getGroup().getId() == null) {
			result.rejectValue("group.id", "NotEmpty");
		} else {
			Group group = memberService.getGroup(member.getGroup().getId());
			if (group == null) {
				result.rejectValue("group.id", "Invalid");
			}
		}

		if (result.hasErrors()) {
			return "member/new";
		}

		memberService.createMember(member);

		return "redirect:/members";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String updateForm(@PathVariable String id, Model model) {
		Member member = memberService.getMember(id);
		model.addAttribute("member", member);

		return "member/edit";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String update(@Valid Member member, BindingResult result) {
		if (member.getGroup().getId() == null) {
			result.rejectValue("group.id", "NotEmpty");
		} else {
			Group group = memberService.getGroup(member.getGroup().getId());
			if (group == null) {
				result.rejectValue("group.id", "Invalid");
			}
		}

		if (result.hasErrors()) {
			return "member/edit";
		}

		memberService.updateMember(member);

		return "redirect:/members";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String id) {
		memberService.deleteMember(id);

		return "redirect:/members";
	}

}
