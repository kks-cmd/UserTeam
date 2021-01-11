package com.css.app.base.cron.action;

import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slw.framework.annotation.ActionInvoke;
import org.slw.framework.annotation.SlwRestService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/cron")
@Tag(description = "定时器表达式", name = "cron")
@Server(url = "/rest/cron")
@SlwRestService
public class CronResource {

	/**
	 * 获取最近执行时间
	 * @param cronExpression 定时器表达式
	 * @return
	 */
	@POST
	@Path("/getNextExecTime")
	@ActionInvoke(actionName = GetNextExecTime.class)
	@Produces(MediaType.APPLICATION_JSON)
	public static String getNextExecTime(@QueryParam(value = "cronExpression") String cronExpression) {
		return null;
	}
}
