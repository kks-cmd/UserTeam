package com.css.app.base.cron.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slw.rest.exception.StatusException;

import com.css.util.StringHelper;

public class GetNextExecTime {
	private String cronExpression;
	
    public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public List<String> execute(){
		if(StringHelper.isEmpty(cronExpression)){
			throw new StatusException(Response.Status.BAD_REQUEST, "表达式解析失败");
		}
    	List<String> list = new ArrayList<>();
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        try {
            cronTriggerImpl.setCronExpression(cronExpression);
        } catch(ParseException e) {
        	throw new StatusException(Response.Status.BAD_REQUEST, "表达式解析失败");
        }
        
        List<Date> dates = TriggerUtils.computeFireTimes(cronTriggerImpl, null, 6);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Date date : dates) {
            list.add(dateFormat.format(date));
        }
        return list;
    }
}
