package nit;

import java.util.ArrayList;
import java.util.List;

import nit.model.BBuch;
import nit.model.PPerson;
import nit.service.BBuchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class Controler {
	@Autowired
	private BBuchService buecher;
    
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseBody
    public String greeting(@RequestParam(value="grus", required=false, defaultValue="Hallo") String grus, @RequestParam(value="name", required=false, defaultValue="Jeremia") String name, Model model)
    {
        //model.addAttribute("name", name);
        return grus+" " + name;
    }
    
    @RequestMapping(value ="/book", method = RequestMethod.GET)
    @ResponseBody
    public String getUsers()
    {
    	String s = "";
    	List<BBuch> list = buecher.findByNameLike("%");
    	for (BBuch b : list)
    		s += b.toString();
        return s;
    }
    
    @RequestMapping(value ="/book/{id1}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable int id1)
    {
        return buecher.findOne(id1).toString();
    }
    
    @RequestMapping(value ="/newbook", method = RequestMethod.GET)
    @ResponseBody
    public String postBook(@RequestParam(value="name", required=true, defaultValue="JavaIsAnIsland") String name, @RequestParam(value="author", required=true, defaultValue="1") Integer newauthor, Model model)
    { 
    	BBuch buch = new BBuch();
    	PPerson person = new PPerson();
    	person.setPName("Noob");
    	person.setPId(newauthor);
    	buch.setBName(name);
    	buch.setPPerson(person);
    	
    	
        return "okay";
    }
    
    @RequestMapping(value ="/book/{id1}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String delBook(@PathVariable int id1)
    {
    	buecher.delete(id1);
        return "OK";
}
}
