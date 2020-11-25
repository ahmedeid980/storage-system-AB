package com.ahmedeid.securityandjwt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmedeid.securityandjwt.demo.entities.Project;
import com.ahmedeid.securityandjwt.demo.services.ProjectService;

@CrossOrigin
@RestController
@RequestMapping(value = "/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@GetMapping
	public List<Project> getAll() {
		
		return projectService.getAll();
	}
	
	@GetMapping("{projectId}")
	public Project getProjectById(@PathVariable("projectId") int projectId)
	{
		return projectService.getProjectById(projectId);
	}

	@PostMapping
	public Project saveProject(@RequestBody Project project)
	{
		return projectService.saveOrUpdateProject(project);
	}
	
	@DeleteMapping("{projectId}")
	public void deleteProject(@PathVariable("projectId") int projectId)
	{
		projectService.deleteProject(projectId);
	}
	
}
