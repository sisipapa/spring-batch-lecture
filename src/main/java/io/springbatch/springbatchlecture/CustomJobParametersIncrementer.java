package io.springbatch.springbatchlecture;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class CustomJobParametersIncrementer implements JobParametersIncrementer {

    static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-hhmmss");

    @Override
    public JobParameters getNext(JobParameters jobParameters) {
        String id = format.format(LocalDateTime.now());
        return new JobParametersBuilder().addString("run.id", id).toJobParameters();
    }
}
