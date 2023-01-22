package net.codejava.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.codejava.Usuario;
import net.codejava.entity.Formulario;
import net.codejava.entity.Imc;
import net.codejava.entity.Product;
import net.codejava.services.ImcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private ImcService service;

    @RequestMapping("/")
    public String viewHomePage(HttpSession session, Model model) {

        if (session.getAttribute("mySessionAttribute") != null) {
            List<Imc> listImc = service.listAll();
            model.addAttribute("listImc", listImc);
            return "index";
        } else {
            model.addAttribute("formulario", new Formulario());
            return "login";
        }
        //model.addAttribute("listProducts", listProducts);
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("mySessionAttribute", "sasas");

        // model.addAttribute("listProducts", listProducts);
        return "redirect:/";
    }

    @RequestMapping("/new")
    public String showNewImc(Model model) {
        Imc imc = new Imc();
        model.addAttribute("imc", imc);

        return "new_imc";
    }
    
    @RequestMapping("/redes")
    public String redes() {
      
        return "redes";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveImc(@ModelAttribute("imc") Imc imc) {
        service.save(imc);
        
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditImc(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_imc");
        Imc imc = service.get(id);
        mav.addObject("imc", imc);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteImc(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
