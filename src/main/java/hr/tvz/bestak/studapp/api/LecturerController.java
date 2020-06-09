package hr.tvz.bestak.studapp.api;

import hr.tvz.bestak.studapp.model.LecturerDTO;
import hr.tvz.bestak.studapp.model.StudentDTO;
import hr.tvz.bestak.studapp.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("lecturer")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LecturerController {
    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(@Qualifier("LecturerServiceImpl") LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping(path = "")
    public List<LecturerDTO> getAllLecturers(){
        return this.lecturerService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LecturerDTO> getLecturer(@PathVariable final int id){
        LecturerDTO lecturerDTO = this.lecturerService.findLecturer(id);

        if (lecturerDTO != null)
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(lecturerDTO);
        else
            return ResponseEntity
                    .notFound()
                    .build();
    }
}
