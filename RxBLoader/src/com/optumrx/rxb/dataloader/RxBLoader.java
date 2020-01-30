package com.optumrx.rxb.dataloader;

import java.io.File;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.optumrx.rxb.dataloader.orchestration.RxBLoadOrchestrator;
import com.optumrx.rxb.dataloader.util.ApplicationContextProvider;
import com.optumrx.rxb.dataloader.util.ExceptionUtil;
import com.optumrx.rxb.dataloader.util.RxBLoaderThreadService;
import com.optumrx.rxb.dataloader.util.RxBLoaderUtil;

/**
 * 
 * @author Aluru.Nagarjuna
 *
 */
public class RxBLoader {
	
	//private static ApplicationContext appContext = null;
	private static Logger log = LoggerFactory.getLogger(RxBLoader.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.debug("-----RxBLoader main() Start------");
		long startTime = System.currentTimeMillis();
		String jobStopTime=null;
		Long jobKillTime=0L;
		Long diffInMin=0L;
		String coolOfTime=null;
		RxBLoaderThreadService loaderThreadService = null;
		try{
			ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
			
			loaderThreadService =(RxBLoaderThreadService) appContext.getBean("rxbLoaderThreadService");
			RxBLoaderUtil loaderUtil = (RxBLoaderUtil) ApplicationContextProvider.getApplicationContext().getBean("loaderUtil");
			
			jobStopTime = loaderUtil.getJobendtime();
			coolOfTime = loaderUtil.getCoolofperiod();
			if(jobStopTime!=null) {
				log.error("-----------------********************-----------------");
				log.error("Configured RxBLoader Process StopTime :: "+jobStopTime+" && Cool Of Period ::"+coolOfTime);
				// Get the Process End Time in minutes
				jobKillTime=loaderThreadService.getDifferneceInMin(jobStopTime,new Date());
				// Check if difference is more than coolOfTime min
				if(coolOfTime != null && jobKillTime>Integer.valueOf(coolOfTime)){
					diffInMin=jobKillTime-Integer.valueOf(coolOfTime);
				}else{
					diffInMin=jobKillTime;
				}
				log.error(" RxBLoader Process will stop in :: "+jobKillTime+" minutes. ");
				log.error("-----------------********************-----------------");
			}
			log.error("Launch the Executor services");
			// launch the servant threads
			loaderThreadService.launchRxLoadJobCreatorServants(loaderUtil);
			// call Orchestration method.
			RxBLoadOrchestrator rxbLoadOrchestrator =(RxBLoadOrchestrator) appContext.getBean("rxbLoadOrchestor");
			rxbLoadOrchestrator.executeLoader();
			
			loaderThreadService.stoppingRxBLoaderServants(diffInMin, jobKillTime);
		} catch (Exception e) {
			log.error("Error in RxBLoader main()" + ExceptionUtil.getStackTrace(e));
			try {
				loaderThreadService.stoppingRxBLoaderServants(diffInMin, jobKillTime);
			} catch (Exception ex) {
				log.error("Error in RxBLoader main() while stopping Servants:" + ExceptionUtil.getStackTrace(ex));
			}
		}
		
		long endTime = System.currentTimeMillis();
		log.debug(" --------------------------------------------------------------- ");
		log.debug("TOTAL TIME TAKEN : [" + (endTime - startTime) + "]in milliseconds");
		log.debug(" --------------------------------------------------------------- ");
		log.debug("-----RxBLoader main() End------");
	}
	
	/**
	 * 
	 * @param configFile
	 * @throws Exception
	 */
	/*private static void showConfigProperties(String configFile) throws Exception {
		Resource resource =appContext.getResource("classpath:"+configFile);
		File file = resource.getFile();
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(file); // document initialization.

		doc.getDocumentElement().normalize();
		System.out.println("Root element :"+ doc.getDocumentElement().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("property"); // Reads all the property tags
		
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element jobElement = (Element) nNode;
				if(jobElement.getAttribute("name") != null && (jobElement.getAttribute("name").equals("LOG_HOME")
						|| jobElement.getAttribute("name").equals("jdbcUrl") || jobElement.getAttribute("name").equals("user")
						|| jobElement.getAttribute("name").equals("csvPath") || jobElement.getAttribute("name").equals("zipPath")
						|| jobElement.getAttribute("name").equals("reportPath") || jobElement.getAttribute("name").equals("optionKey"))) {
					System.out.print(jobElement.getAttribute("name")+":");
					System.out.println(jobElement.getAttribute("value"));
				}
			}
		}
	}*/
}
