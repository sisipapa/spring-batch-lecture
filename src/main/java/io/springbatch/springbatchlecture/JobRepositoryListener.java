package io.springbatch.springbatchlecture;

import org.springframework.batch.core.*;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobRepositoryListener implements JobExecutionListener {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String jobName = jobExecution.getJobInstance().getJobName();

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("requestDate", "20210103").toJobParameters();

        JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
        if(lastJobExecution != null){
            lastJobExecution.getStepExecutions().stream().forEach(stepExecution -> {
                BatchStatus status = stepExecution.getStatus();
                ExitStatus exitStatus = stepExecution.getExitStatus();
                String stepName = stepExecution.getStepName();
                System.out.println("status : " + status);
                System.out.println("exitStatus : " + exitStatus);
                System.out.println("stepName : " + stepName);
            });
        }
    }
}
