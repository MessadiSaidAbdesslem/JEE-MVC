package mybootapp.web;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybootapp.model.Course;
import mybootapp.repo.CourseRepository;

@Controller
@RequestMapping("/course")
public class CourseControler {

	/*
	 * Injection de la DAO de manipulation des cours.
	 */
	@Autowired
	CourseRepository repo;

	@PostConstruct
	public void init() {
		repo.save(Course.builder().name("Architecture JEE").build());
		repo.save(Course.builder().name("Données post-relationnelles").build());
	}

	@RequestMapping("/list")
	public ModelAndView listCourses() {
		return new ModelAndView("course", "courses", repo.findAll());
	}

	@RequestMapping("/new")
	public String newCourse() {
		final var name = String.format("UE %d", System.currentTimeMillis());
		final var course = Course.builder().name(name).build();
		repo.save(course);
		return "redirect:/course/list";
	}

	@RequestMapping("/find")
	public ModelAndView findCourses(String name) {
		final var result = repo.findByNameLike("%" + name + "%");
		return new ModelAndView("course", "courses", result);
	}

}
