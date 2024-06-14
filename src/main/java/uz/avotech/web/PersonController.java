package uz.avotech.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.avotech.domain.PersonEntity;
import uz.avotech.service.PersonDataBaseService;

import java.util.List;

@Controller
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonDataBaseService service;

    @PostMapping
    public String save(@RequestParam(name = "test", required = false) String test) {
        service.save(test);
        return "";
    }

    @GetMapping
    public String getAllPersons() {

        try {
        List<PersonEntity> all = service.getAll();

        all.forEach(personEntity -> System.out.println(personEntity.getName()));
            System.out.println("controller : " + all);
        } catch (Exception exc) {
            System.out.println(exc);
        }



        return "";
    }

    @DeleteMapping
    public String delete() {
        service.delete();
        return "";
    }

    @PutMapping
    public String update(@RequestParam(name = "name") String name) {
        try {
            service.update(name);
        } catch (Exception exc) {
            System.out.println("");
        }
        return "";
    }

}
