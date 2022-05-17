package FinalProject.ApiMessageSystem.Controllers;

import FinalProject.ApiMessageSystem.Models.UserPerson;
import FinalProject.ApiMessageSystem.Services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class UserPersonController {

    @Autowired
    PersonService ps;

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<UserPerson> userPersons = ps.getAll();
        if(!userPersons.isEmpty()){
            return ResponseEntity.status(200).body(userPersons);
        }
        else {
            return ResponseEntity.status(204).body(userPersons);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> getByUsername(@PathVariable("username") String username){
        UserPerson up = ps.getByUsername(username);
        if (up == null)
            return ResponseEntity.status(204).body(up);
        else
            return ResponseEntity.status(200).body(up);
    }


    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid UserPerson up){
        boolean flag = ps.save(up);
        if(flag)
            return ResponseEntity.status(200).body("Sucess.");
        else
            return ResponseEntity.status(400).body("Error.");
    }

    @PutMapping("/update/{dni}")
    public ResponseEntity<Object> update(@RequestBody @Valid UserPerson up, @PathVariable("dni") String dni) {
        UserPerson person = ps.update(up, dni);
        if (person == null)
            return ResponseEntity.status(204).body(person);
        else
            return ResponseEntity.status(200).body(person);

    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Object> delete(@PathVariable("dni") String dni){
        try{
            boolean flag = ps.delete(dni);
            if(flag){
                return ResponseEntity.status(200).body("Sucess.");
            } else {
                return ResponseEntity.status(204).body("No username found with the specified DNI.");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error.");
        }
    }




}