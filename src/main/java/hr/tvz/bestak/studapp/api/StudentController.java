package hr.tvz.bestak.studapp.api;

import hr.tvz.bestak.studapp.model.Student;
import hr.tvz.bestak.studapp.model.StudentCommand;
import hr.tvz.bestak.studapp.model.StudentDTO;
import hr.tvz.bestak.studapp.service.StudentService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RequestMapping("student")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(@Qualifier("StudentServiceImpl") final StudentService studentService) {
        this.studentService = studentService;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{JMBAG}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable final String  JMBAG){
        StudentDTO studentDTO = this.studentService.findStudentByJMBAG(JMBAG);

        if (studentDTO != null)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(studentDTO);
        else
            return ResponseEntity
                    .notFound()
                    .build();
    }
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "")
    public List<StudentDTO> getAllStudents(){
        return this.studentService.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping(path = "")
    public ResponseEntity<StudentDTO> saveStudent(@Valid @RequestBody final StudentCommand command){
        StudentDTO studentDTO = this.studentService.saveStudent(command);

        if (studentDTO != null){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(studentDTO);
        }else{
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }
    }

    @Secured({"ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{JMBAG}")
    public void updateStudent(@Valid @RequestBody final StudentCommand command, @PathVariable String JMBAG){
        this.studentService.updateStudent(command, JMBAG);
    }

    @Secured({"ROLE_ADMIN", "ROLE_DELETER"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public void delete(@PathVariable String JMBAG){
        this.studentService.deleteStudent(JMBAG);
    }
}
