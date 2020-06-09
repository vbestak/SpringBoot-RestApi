package hr.tvz.bestak.studapp.api;

import hr.tvz.bestak.studapp.model.Course;
import hr.tvz.bestak.studapp.model.CourseCommand;
import hr.tvz.bestak.studapp.model.CourseDTO;
import hr.tvz.bestak.studapp.model.StudentDTO;
import hr.tvz.bestak.studapp.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("course")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(@Qualifier("CourseServiceImpl") final CourseService courseService) {
        this.courseService = courseService;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "")
    public List<CourseDTO> getAllCourses(@RequestParam(required = false) Optional<String> jmbag){
        if (jmbag.isPresent()) return this.courseService.findCoursesByStudentJmbag(jmbag.get());

        return this.courseService.findAll();
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(path = "/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable final Integer  id){
        CourseDTO courseDTO = this.courseService.findCourse(id);

        if (courseDTO != null)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(courseDTO);
        else
            return ResponseEntity
                    .notFound()
                    .build();
    }
}
