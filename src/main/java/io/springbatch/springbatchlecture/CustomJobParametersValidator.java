package io.springbatch.springbatchlecture;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

public class CustomJobParametersValidator implements JobParametersValidator {
    @Override
    public void validate(JobParameters jobParameters) throws JobParametersInvalidException {
        if(StringUtils.isEmpty(jobParameters.getString("name2"))){
            throw new JobParametersInvalidException("name parameters is not found.");
        }
    }
}
