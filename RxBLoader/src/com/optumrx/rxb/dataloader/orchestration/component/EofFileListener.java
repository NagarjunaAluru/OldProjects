/**
 * 
 */
package com.optumrx.rxb.dataloader.orchestration.component;

import java.io.File;
import java.util.List;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.optumrx.rxb.dataloader.util.ExceptionUtil;

/**
 * @author Aluru.Nagarjuna
 *
 */
public class EofFileListener {


	private static Logger log = LoggerFactory.getLogger(EofFileListener.class);

	public void processEofFileList(String filePath, List<String> eofFileList) {
		// The monitor will perform polling on the folder every 5 seconds
		final long pollingInterval = 5 * 1000;
		File folder = new File(filePath);

		if (!folder.exists()) {
			throw new RuntimeException("Directory not found: " + filePath);
		}
		
		for(String eofFile : eofFileList) {
			RxBLoadJobCreatorQ.addToQ(eofFile);
			log.error(" *** EOF File added to RxBLoadJobCreatorQ : "+eofFile+" ***");
		}
		
		FileAlterationObserver observer = new FileAlterationObserver(folder);
		FileAlterationMonitor monitor = new FileAlterationMonitor(pollingInterval);
		FileAlterationListener listener = new FileAlterationListenerAdaptor() {
			@Override
			public void onFileCreate(File file) {
				try {
					log.info(" File added to directory :"+file.getName());
					if(file.getName().contains("#ZEOF") && file.getName().toUpperCase().endsWith(".CSV")) {
						RxBLoadJobCreatorQ.addToQ(file.getName());
						log.error(" **** EOF File added to RxBLoadJobCreatorQ : "+file.getName()+" ****");
					}
				} catch (Exception e) {
					log.error("Error in processEofFileList()--> onFileCreate() : "+ExceptionUtil.getStackTrace(e));
				}
			}
		};

		try {
			observer.addListener(listener);
			monitor.addObserver(observer);
			monitor.start();
		} catch (Exception e) {
			log.error("Error in processEofFileList() :"+ExceptionUtil.getStackTrace(e));
		}
	}

}
