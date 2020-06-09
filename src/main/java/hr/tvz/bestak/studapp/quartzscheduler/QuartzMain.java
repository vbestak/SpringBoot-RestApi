package hr.tvz.bestak.studapp.quartzscheduler;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class QuartzMain {

    @Bean
    public JobDetail studentJobDetail(){
        return JobBuilder.newJob(StudentLogJob.class).withIdentity("studentLogJob").storeDurably().build();
    }

    @Bean
    public Trigger studentLogJobTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(studentJobDetail()).withSchedule(scheduleBuilder).build();
    }

    @Bean
    public Trigger studentLogJobSecondTrigger(){
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.atHourAndMinuteOnGivenDaysOfWeek(12, 00,
                DateBuilder.MONDAY,
                DateBuilder.TUESDAY,
                DateBuilder.WEDNESDAY,
                DateBuilder.THURSDAY,
                DateBuilder.FRIDAY);

        return TriggerBuilder.newTrigger().forJob(studentJobDetail()).withSchedule(scheduleBuilder).build();
    }

}
