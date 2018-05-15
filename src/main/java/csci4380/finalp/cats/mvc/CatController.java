/**
 * 
 */
package csci4380.finalp.cats.mvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;


/**
 * @author stajekankati
 *
 */
@Controller 
@RequestMapping("/mvc/cats")
public class CatController {
	@Autowired
	private CatRepository catRepository;
	
	public String echoMessage(@RequestParam(value="msg", defaultValue="Hello Staje") String message) {
		return "echoMessage echoes: " + message;
	}
	
	@GetMapping("/list")
	public String showCatList(Model model, @RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage", defaultValue="5") int size) {
		Page<Cat> catsPage = catRepository.findAll(new PageRequest(page, size));
		model.addAttribute("catsData", catsPage);
		model.addAttribute("currentPage", page);	// for UI nav-pills to high light "active" page
		model.addAttribute("rowsPerPage", size);	// example of passing 2 uri params
		return "catList";
	}
	
	@PostMapping("/save")
	public String saveStudent(Cat cat) {
		catRepository.save(cat);
		return "redirect:/mvc/student/list";	// after student is added, want to go to student list view, so redirect to it's url
	}
	
	@GetMapping("/delete")
	public String deleteCat(Integer catId) {
		catRepository.deleteById(catId);
		return "redirect:/mvc/cat/list";	// after student is deleted, want to go to student list view, so redirect to it's url
	}
	
	@GetMapping("/detail")
	@ResponseBody			// NOTE ilker since will be using jQuery for this, let it return
	public Optional<Cat> showCatDetail(Integer catId) {
		return catRepository.findById(catId);
	}
	
	}
	
	


