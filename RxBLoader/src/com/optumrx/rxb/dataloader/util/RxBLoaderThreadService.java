package com.optumrx.rxb.dataloader.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.optumrx.rxb.dataloader.dao.db2.IRxBLoadDao;
import com.optumrx.rxb.dataloader.model.RxBAudit;
import com.optumrx.rxb.dataloader.orchestration.component.RxBLoadJobExecutor;
import com.optumrx.rxb.dataloader.orchestration.component.RxBLoadJobExecutorQ;
import com.optumrx.rxb.dataloader.orchestration.component.RxBLoadJobCreator;
import com.optumrx.rxb.dataloader.orchestration.component.RxBLoadReportExecutor;
import com.optumrx.rxb.dataloader.orchestration.component.RxBLoadReportExecutorQ;

/**
 * 
 * @author Aluru.Nagarjuna
 *
 */
public class RxBLoaderThreadService 
{

	private static Logger log = LoggerFactory.getLogger(RxBLoaderThreadService.class);

	private ScheduledExecutorService jobCreatorService;
	private ScheduledExecutorService jobExecutorService;
	private ScheduledExecutorService reportExecutorService;

	private ThreadLocal<SimpleDateFormat> fullDateFormat = new ThreadLocal<SimpleDateFormat>() {
	    @Override
	    protected SimpleDateFormat initialValue() {
	        return new SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH);
	    }
	};
	
	private ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
	    @Override
	    protected SimpleDateFormat initialValue() {
	        return new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
	    }
	};
	
	/**
	 * RxBLoader: Creator and Executor Queues initialization
	 */
	public void launchRxLoadJobCreatorServants(RxBLoaderUtil loaderUtil) throws Exception {
		log.debug("************** RxBLoadJob Creator & Executor Sevices launch START **************");
		// only one thread for RxBLoadJobCreator
		jobCreatorService = Executors.newScheduledThreadPool(1);
		// will be launched 1 minute after the previous launch completes
		jobCreatorService.scheduleWithFixedDelay(new RxBLoadJobCreator(), 1, 1, TimeUnit.MINUTES);
		log.info("************** jobCreatorService Wakeup Time = 1 Min **************");
		
		// only one threads for RxBLoadJobExecutor
		jobExecutorService = Executors.newScheduledThreadPool(1);// multi-threading.
		// will be launched 1 minute after the previous launch completes
		jobExecutorService.scheduleWithFixedDelay(new RxBLoadJobExecutor(), 1, 1, TimeUnit.MINUTES);
		log.info("************** jobExecutorService Wakeup Time = 1 Min **************");
		
		// only one threads for RxBLoadReportExecutor
		reportExecutorService = Executors.newScheduledThreadPool(1);// multi-threading.
		// will be launched 1 minute after the previous launch completes
		reportExecutorService.scheduleWithFixedDelay(new RxBLoadReportExecutor(), 1, 1, TimeUnit.MINUTES);
		log.info("************** reportExecutorService Wakeup Time = 1 Min **************");
		
		log.error("************** RxBLoadJob Creator & Executor Sevices launched **************");	
	}

	/**
	 * RxBLoader: Creator and Executor Queues shutdown
	 */
	@SuppressWarnings("rawtypes")
	public void stoppingRxBLoaderServants(Long stopTime,Long jobKillTime) throws Exception {
		log.info("stoppingRxBLoaderServants() : Scheduling time to Stop Creator and Executor Services");

		// schedule StartStopExecutors
		ScheduledExecutorService jobStartStopExecutorService = Executors.newScheduledThreadPool(1);
		ScheduledFuture scheduledFuture = jobStartStopExecutorService.schedule(new Callable<Object>() {
			public Object call() throws Exception {
				clearExecutorQueues();
				return "Called";
			}
		}, stopTime, // Pass the stopTime to it
		TimeUnit.MINUTES);
		// Stop all Executor services once time out
		if (scheduledFuture.get().toString().equalsIgnoreCase("Called")) {
			jobStartStopExecutorService.shutdown();
			jobKillTime=jobKillTime-stopTime;
			log.error("Executor services will stop all services in "+jobKillTime +" minutes");
			stopAndExitRxBLoader(jobKillTime);
		} else {
			log.error("Executor services not Stopped properly.");
		}
	}

	/**
	 * RxBLoader: Stop and exit
	 */
	@SuppressWarnings("rawtypes")
	public void stopAndExitRxBLoader(Long stopTime) throws Exception {
		log.info("stopAndExitRxBLoader() :: stopping all Services");

		// schedule StartStopExecutors
		ScheduledExecutorService jobStartStopExecutorService = Executors.newScheduledThreadPool(1);
		ScheduledFuture scheduledFuture = jobStartStopExecutorService.schedule(new Callable<Object>() {
			public Object call() throws Exception {
				return "Called";
			}
		}, stopTime, // Pass the stopTime to it
		TimeUnit.MINUTES);
		// Stop all Executor services once time out
		if (scheduledFuture.get().toString().equalsIgnoreCase("Called")) {
			jobStartStopExecutorService.shutdown();
			log.error("-------------------------- All RxBLoader jobs stopped successfully --------------------------");
			System.exit(0);
		} else {
			log.error("Executor services not Stopped properly.");
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void clearExecutorQueues() throws Exception {
		log.info("Clearing the queues data from Executor queues");

		// Shutdown Creator service
		jobExecutorService.shutdown();
		// Clear the Executor queue
		log.info("Before clear RxBLoadJobExecutorQ size="+ RxBLoadJobExecutorQ.getQSize());
		
		Object[] objs=RxBLoadJobExecutorQ.getArray();
		RxBLoadJobExecutorQ.removeAll(objs);
		List<String> remainingEofFiles=new ArrayList<String>();
		for (Object obj : objs) {
			 Map<String,Boolean> eofVal = (Map<String, Boolean>) obj;
			 Map.Entry<String,Boolean> eofEntry = eofVal.entrySet().iterator().next();
			String eofFilename = eofEntry.getKey();
			if(eofFilename != null)
				remainingEofFiles.add(eofFilename);
		}
		log.error("***** EOF Files in EXECUTOR Q(size["+remainingEofFiles.size()
				+ "]) can't be processed are : "+remainingEofFiles +" *****");
		log.info("After clear RxBLoadJobExecutorQ size=" + RxBLoadJobExecutorQ.getQSize());
		
		// Shutdown Job Executor service
		reportExecutorService.shutdown();
		// Clear the Job Executor queue
		log.info("Before clear RxBLoadReportExecutorQ size="+ RxBLoadReportExecutorQ.getQSize() );
		
		Object[] repObjs = RxBLoadReportExecutorQ.getArray();
		RxBLoadReportExecutorQ.removeAll(repObjs);
		List<String> eofFilesLeft =new ArrayList<String>();
		for (Object obj : repObjs) {
			Map<Integer,String> eofVal = (Map<Integer,String>) obj;
			 Map.Entry<Integer,String> eofEntry = eofVal.entrySet().iterator().next();
			String eofFilename = eofEntry.getValue();
			if(eofFilename != null)
				eofFilesLeft.add(eofFilename);
		}
		log.error("***** EOF Files in REPORT EXECUTOR Q(size["+eofFilesLeft.size()
				+ "]) can't be processed are : "+eofFilesLeft +" *****");
		log.info("After clear RxBLoadReportExecutorQ size=" + RxBLoadReportExecutorQ.getQSize());
		
		// Shutdown Creator service
		jobCreatorService.shutdownNow();

		log.error("************** Shutdown of all the services **************");
	}
	
	/**
	 * 
	 * @param stopTime
	 * @param startDate
	 * @return
	 * @throws Exception
	 */
	public Long getDifferneceInMin(String stopTime, Date startDate) throws Exception {
		Long diffInMinutes = null;
		Long duration = null;
		try {
			log.error("Current System Date and Time= " + fullDateFormat.get().format(startDate));
			Date stopDate = fullDateFormat.get().parse(dateFormat.get().format(startDate) + " " + stopTime);
			log.error("Job will end @ ::  " + fullDateFormat.get().format(stopDate));

			if (stopDate.getTime() > startDate.getTime()) {
				log.error("configured stopTime is greater than currentTime");
				duration = stopDate.getTime() - startDate.getTime();
				diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
			} else {
				log.error("configured stopTime is lesser than currentTime");
				Calendar c = Calendar.getInstance();
				c.setTime(stopDate);
				c.add(Calendar.DATE, 1);
				stopDate = c.getTime();
				log.info("So increment in stop dateTime= " + fullDateFormat.get().format(stopDate));
				duration = stopDate.getTime() - startDate.getTime();
				diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
			}
		} catch (ParseException e) {
			log.error("Error in getDifferneceInMin() ParseExceptions : " + ExceptionUtil.getStackTrace(e));
		}
		return diffInMinutes;
	}

	public ScheduledExecutorService getJobCreatorService() {
		return jobCreatorService;
	}
	public void setJobCreatorService(ScheduledExecutorService jobCreatorService) {
		this.jobCreatorService = jobCreatorService;
	}
	public ScheduledExecutorService getJobExecutorService() {
		return jobExecutorService;
	}
	public void setJobExecutorService(ScheduledExecutorService jobExecutorService) {
		this.jobExecutorService = jobExecutorService;
	}
	public ScheduledExecutorService getReportExecutorService() {
		return reportExecutorService;
	}
	public void setReportExecutorService(ScheduledExecutorService reportExecutorService) {
		this.reportExecutorService = reportExecutorService;
	}

}
