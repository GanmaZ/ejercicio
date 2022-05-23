package pe.edu.upc.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.edu.upc.demo.entities.Person;
import pe.edu.upc.demo.serviceimplements.PersonServiceImpls;

@Controller
public class PersonController {

	@Autowired
	private PersonServiceImpls pService;
	
	@RequestMapping("/")
	public String verPaginaDeInicio(Model modelo, @Param("palabraClave") String palabraClave) {
		List<Person> listaPersonas = pService.list(palabraClave);
		
		modelo.addAttribute("listaPersonas", listaPersonas);
		modelo.addAttribute("palabraClave", palabraClave);
		
		return "index";
	}
	
	@RequestMapping("/nuevo")
	public String mostrarFormularioDeInsertarPersona(Model modelo) {
		Person persona = new Person();
		modelo.addAttribute("persona", persona);
		return "nueva_persona";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardarPersona(@ModelAttribute("persona") Person persona) {
		pService.insert(persona);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{idPersona}")
	public ModelAndView mostrarFormularioDeEditarPersona(@PathVariable(name = "idPersona")Integer id) {
		ModelAndView modelo = new ModelAndView("editar_persona");
		
		Person persona = pService.get(id);
		modelo.addObject("persona", persona);
		
		return modelo;
	}
	
	@RequestMapping("/eliminar/{idPersona}")
	public String eliminarPersona(@PathVariable(name = "idPersona")Integer id) {
		pService.delete(id);
		return "redirect:/";
	}
}
