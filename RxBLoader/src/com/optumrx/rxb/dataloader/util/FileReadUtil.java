/**
 * 
 */
package com.optumrx.rxb.dataloader.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.optumrx.rxb.dataloader.model.EOFCSV;

/**
 * 
 * @author Aluru.Nagarjuna
 *
 * @param 
 */
public class FileReadUtil {
	
	private static Logger log = LoggerFactory.getLogger(FileReadUtil.class);
	
	RxBLoaderUtil loaderUtil = (RxBLoaderUtil) ApplicationContextProvider.getApplicationContext().getBean("loaderUtil");

	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public List<EOFCSV> processSummaryCsv(String filePath, String fileName) throws Exception {
		List<EOFCSV> tierList = new ArrayList<EOFCSV>();
		if(fileName != null && !fileName.isEmpty()) {
			CSVReader headerReader = new CSVReader(new FileReader(filePath+fileName), ',', '\"');
			CSVReader reader = new CSVReader(new FileReader(filePath+fileName), ',', '\"', 1);
			ColumnPositionMappingStrategy<EOFCSV> mappingStrategy  = new ColumnPositionMappingStrategy<EOFCSV>();
			mappingStrategy.setType(EOFCSV.class);
			mappingStrategy.setColumnMapping(headerReader.readNext());
			CsvToBean<EOFCSV> csv = new CsvToBean<EOFCSV>();
			tierList = csv.parse(mappingStrategy, reader);			
		}
		return tierList;
	}
	
	/**
	 * 
	 * @param zipFilePath
	 * @throws IOException 
	 */
	public void zipIt(String zipFilePath, List<String> fileList, String csvPath,
			String errorReport, String loadReport, String detailReport, String reportsPath) throws IOException {
		byte[] buffer = new byte[1024];
		try {
			FileOutputStream fos = new FileOutputStream(zipFilePath);
			ZipOutputStream zos = new ZipOutputStream(fos);
			log.info("************** Files adding to ZIP "+ fileList +" **************");	
			log.info("************** Report Files adding to ZIP :"+ errorReport
					+","+loadReport+","+detailReport+" **************");	
			for (String file : fileList) {
				if(file == null)
					continue;
				addFileToZip(zos,buffer,file,csvPath);
			}
			if(errorReport!=null) {
				addFileToZip(zos,buffer,errorReport,reportsPath);
			}
			if(loadReport!=null) {
				addFileToZip(zos,buffer,loadReport,reportsPath);
			}
			if(detailReport!=null) {
				addFileToZip(zos,buffer,detailReport,reportsPath);
			}
			zos.closeEntry();
			zos.close();
			log.debug("Zip completed successfully");
		} catch (IOException ex) {
			log.error("Error in zipIt() :"+ExceptionUtil.getStackTrace(ex));
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param zos
	 * @param file
	 * @param csvPath
	 * @throws IOException 
	 */
	private void addFileToZip(ZipOutputStream zos, byte[] buffer, String file, String csvPath) throws IOException {
		File zipEntry = new File(csvPath + file);
		if(zipEntry.exists()){
			ZipEntry ze = new ZipEntry(file);
			zos.putNextEntry(ze);
			FileInputStream in = new FileInputStream(zipEntry);
			int len;
			while ((len = in.read(buffer)) > 0) {
				zos.write(buffer, 0, len);
			}
			in.close();
		} else {
			log.error("CSV file not found to add zip ::"+csvPath + file);
		}
	}

	/**
	 * 
	 * @param csvFolderPath
	 * @param fileList
	 */
	public void deleteCSVFiles(String csvFolderPath, List<String> fileList) {
		File indivitualCSVfile ;
		try {
			log.info("************** Files deleting "+ fileList +" **************");
			if(fileList != null && fileList.size()>0){
				for(String csvFile : fileList){
					indivitualCSVfile = new File(csvFolderPath+csvFile);
					log.info("Files to be deleted "+indivitualCSVfile);
					if(indivitualCSVfile.exists()){
						indivitualCSVfile.delete();
					} else {
						log.error("File not exists to delete :"+indivitualCSVfile);
					}
				}
			}
		} catch (Exception ex) {
			log.error("Error in deleteCSVFiles() ::"+ExceptionUtil.getStackTrace(ex));
		}
	}
	
	/**
	 * @param fileName
	 * @return
	 * @throws Exception 
	 */
	public String getRegionBatchIds(String fileName, boolean onlyBatch) throws Exception {
		String regionBatch = null;
		try{
			if(onlyBatch) {
				regionBatch = fileName.substring(fileName.indexOf("#") + 1, fileName.lastIndexOf("#"));
			}else {
				regionBatch = fileName.substring(0, fileName.lastIndexOf("#")).replace("#", "_");
			}
		}  catch(IndexOutOfBoundsException ioob){
			log.error("Error in getRegionBatchIds() ::"+ExceptionUtil.getStackTrace(ioob));
			throw new Exception("Invalid EOF file name format :"+fileName);
		} catch (Exception ex) {
			log.error("Error in getRegionBatchIds() ::"+ExceptionUtil.getStackTrace(ex));
			throw new Exception("Error while getting Region Batch info ::"+fileName);
		}
		return regionBatch;
	}
	
	/**
	 * Traverse a directory and get all files, and add the file into fileList
	 * @param node
	 *            file or directory
	 */
	public List<String> generateFileList(List<EOFCSV> csvList, String eofFileName, File node) {
		List<String> fileList = new ArrayList<String>();
		if(eofFileName != null && !eofFileName.isEmpty()){
			for(EOFCSV  csvObj : csvList){
				if(csvObj.getFileName() != null){
					fileList.add(csvObj.getFileName());
				}
			}
			fileList.add(eofFileName);
		}
		return fileList;
	}
	
}
