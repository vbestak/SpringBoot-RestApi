package hr.tvz.bestak.studapp.quartzscheduler;

import hr.tvz.bestak.studapp.dao.StudentJPARepository;
import hr.tvz.bestak.studapp.model.Student;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class StudentLogJob extends QuartzJobBean {

    @Autowired
    StudentJPARepository studentJPARepository;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Student> students = studentJPARepository.findAll();


        System.out.println("------------------------------------ \n Trenutno upisani studenti \n------------------------------------");

        students.stream().forEach(student ->{
            System.out.println(student.getJMBAG() + " - " + student.getName() + " " + student.getLastName() );
        });

        System.out.println("------------------------------------");
    }
}
