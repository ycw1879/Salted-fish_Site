/* @(#)FileUtil.java
 * @version 	v0.0  Oct 6, 2007
 * Copyright (c) 2002 Jazz Virtual Machine, Inc. (Seoul, Korea.)
 * http://www.jazzvm.net All rights reserved.
 */
package com.gomso.core.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class FileUtil {

    protected static Log logger = LogFactory.getLog(FileUtil.class);
    
    /** forbidden file extention names array for uploading */
    private static final String[] FOBIDDEN_FILE_EXTENSION = { "", "htm", "html", "jsp", "js" };


    /**
     * @param fileName
     * @return boolean
     */
    public static boolean isForbidenFile(String fileName) {
        StringTokenizer tokens = new StringTokenizer(fileName, ".", true);
        int index = tokens.countTokens();
        boolean value = false;
    
        if (index < 2) {
            return true;
        } else {
            String extension = "";
            for (int i = 0; tokens.hasMoreTokens(); i++) {
                if (i == (index - 1))
                    extension = tokens.nextToken();
                else
                    tokens.nextToken();
            }
            for (int i = 0; i < FOBIDDEN_FILE_EXTENSION.length; i++) {
                if (extension.equalsIgnoreCase(FOBIDDEN_FILE_EXTENSION[i])) {
                    return true;
                }
            }
            return value;
        }
    }

    
    public static boolean validFileExtension(String filename,
            String[] AVAILABLE_ARR) {
        String[] splitted = filename.split("[.]");
        if (splitted.length < 2)
            return false;
        else {
            String extension = splitted[splitted.length - 1];
            for (int i = 0; i < AVAILABLE_ARR.length; i++) {
                if (extension.equalsIgnoreCase(AVAILABLE_ARR[i])) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * buff�� ����� ���ڿ�; absoluteFilePath�����̸�8�� ����
     * 
     * @param buff
     * @param absoluteFilePath
     * @throws IOException
     */
    public static void publishStringBufferToFile(StringBuffer buff,
            String absoluteFilePath) throws IOException {
        writeStringToFile(buff.toString(), absoluteFilePath);
    }

    public static void writeStringToFile(String contents, String absoluteFilePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
                absoluteFilePath)));
        writer.write(contents);
        writer.flush();
        writer.close();
    }
 
    
    /**
     * path����� fileName�� ����; ã�� ��f��
     * 
     * @param path
     * @param fileName
     */
    public static void deleteFile(String path, String fileName) {
        String fullFileName = path + fileName;
        FileUtil.deleteFile(fullFileName);
    }

    /**
     * ��ü ��η� ��d�� ����; ��f
     * 
     * @param absolutePath
     */
    public static void deleteFile(String absolutePath) {
        File abs = new File(absolutePath);
        if (abs.exists()) {
            abs.delete();
        }
    }

    /**
     * path��θ� ���� ���丮�� ��f �ش� ���丮�ȿ� ��' ���丮 Ȥ: ������ �ִ0�� ���� ��f
     * 
     * @param path
     */
    public static void deleteDirectory(String path) {
        File absDirectory = new File(path);
    
        if (absDirectory.exists()) {
            if (absDirectory.isDirectory()) {
                File[] fileList = absDirectory.listFiles();
                for (int i = 0; i < fileList.length; i++) {
                    if (fileList[i].exists())
                        fileList[i].delete();
                }
                absDirectory.delete();
            }
        }
    }

    /**
     * path�� ���� ��f ���丮�� x���ϸ� true, �ƴϸ� false��ȯ
     * 
     * @param path
     * @return boolean
     */
    public static boolean verifyDirectory(String path) {
    
        File dircectory = new File(path);
        if (dircectory.exists()) {
            return true;
        } else {
            return dircectory.mkdirs();
        }
    }

 
    public static void copyFile(String sourceByFullname, String targetByFullname)
            throws Exception {
        if (StringUtils.isEmpty(sourceByFullname)) {
            throw new IllegalArgumentException(
                    "sourceByFullname can't be empty [" + sourceByFullname
                            + "]");
        }
        if (StringUtils.isEmpty(targetByFullname)) {
            throw new IllegalArgumentException(
                    "targetByFullname can't be empty [" + targetByFullname
                            + "]");
        }
    
        File source = new File(sourceByFullname);
        File target = new File(targetByFullname);
        if (!source.isFile()) {
            throw new FileNotFoundException(
                    "sourceByFullname is not exsit or valid file type ["
                            + sourceByFullname + "]");
        }
    
        int length = 0;
        byte[] size = new byte[1024 * 4];
    
        BufferedInputStream input = new BufferedInputStream(
                new FileInputStream(source));
        BufferedOutputStream output = new BufferedOutputStream(
                new FileOutputStream(target));
    
        try {
            while ((length = input.read(size)) != -1) {
                output.write(size, 0, length);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
    
    public static void copyDirectory(File sourceLocation , File targetLocation) throws IOException {
    	
        if (sourceLocation.isDirectory()) {
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }
    
    
    public static boolean deleteDirectory(File directory) {
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(null!=files){
                for(int i=0; i<files.length; i++) {
                    if(files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    }
                    else {
                        files[i].delete();
                    }
                }
            }
        }
        return(directory.delete());
    }

    public static void serializeWithFile(Object obj, String fullFilePath)
            throws Exception {
        File file = new File(fullFilePath);
        FileUtil.serializeWithFile(obj, file);
    
    }

    public static void serializeWithFile(Object obj, File targetFile)
            throws Exception {
        ObjectOutputStream output = null;
    
        try {
            targetFile.createNewFile();
            output = new ObjectOutputStream(new FileOutputStream(targetFile));
            output.writeObject(obj);
    
        } catch (Exception e) {
            logger.error(e);
            throw e;
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static Object deSerializeFromFile(String fullFilPath)
            throws Exception {
        File file = new File(fullFilPath);
        return FileUtil.deSerializeFromFile(file);
    }

    public static Object deSerializeFromFile(File sourceFile) throws Exception {
    
        ObjectInputStream input = null;
    
        try {
            if (!sourceFile.isFile()) {
                throw new IllegalArgumentException(sourceFile.getName()
                        + " is not exist");
            }
    
            input = new ObjectInputStream(new FileInputStream(sourceFile));
            return input.readObject();
    
        } catch (Exception e) {
            throw e;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    public static File getFileOnClasspath(String name) throws FileNotFoundException  {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        File file = new File(loader.getResource(name).getPath());
    
        if (!file.isFile()) {
            logger.error(file.getAbsolutePath());
            throw new FileNotFoundException();
        }
        return new File(loader.getResource(name).getFile());
    }
    
    
    public static String getFileNameOnClasspath(String name){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResource(name).getPath();
    }

    public static ResourceBundle findBundleOnClasspath(String resourceBundleName)
            throws Exception {
        File file = getFileOnClasspath(resourceBundleName);
        String bundleName = FileUtil.getFileNameExceptExtension(file.getName());
        return ResourceBundle.getBundle(bundleName);
    }

    public static String getFileExtensionName(String fileName) {
        int dilimeter = fileName.lastIndexOf(".");
        if (dilimeter != -1) {
            return fileName.substring(dilimeter + 1).trim();
        } else {
            return "";
        }
    }

    public static String getFileNameExceptExtension(String fileName) {
        int dilimeter = fileName.lastIndexOf(".");
        if (dilimeter != -1) {
            return fileName.substring(0, dilimeter).trim();
        } else {
            return "";
        }
    }
    
    public static void combineFiles(String[] files, String destFileName, String encoding) throws Exception {
    	
    	String executionPath = System.getProperty("user.dir");
    	
    	System.out.println("\n>>>>> Current Execution Path : " + executionPath + "\n");
    	File destFile = new File( destFileName );
    	
    	if( destFile.exists() ) {
    		destFile.delete();
    		System.out.println("---------- >>>>>> Delete File " + destFileName + "----------");
    	}
    	
    	for( String fileName : files ) {
    		System.out.println(">>>>>> Append File : " + fileName);
    		File file = new File( fileName );
    		BufferedReader fi = new BufferedReader( new  InputStreamReader(new FileInputStream(file), encoding) );
    		BufferedWriter fo = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(destFile, true), encoding ) );
    		
    		String line = fi.readLine();
    		
    		while( line != null  ) {
    			fo.write(line + "\n");
    			line = fi.readLine();
    			
    		}
    		fo.flush();
    		fi.close();
    		fo.close();
    		
    		System.out.println(">>>>>> Finished Combine To : " + destFileName + " For [" + fileName + "]" );
    	}
    }
    
    
    public static void main(String[] args) {
    	
    	List<String> files = new ArrayList<String>();
    	
    	String dir = "db.script";
    	
    	files.add( dir + "/" + "00_database.sql");
    	files.add( dir + "/" + "01_user.sql");
    	
    	files.add( dir + "/" + "0301_schem_core.sql");
    	files.add( dir + "/" + "0302_schem_abap.sql");
    	files.add( dir + "/" + "0303_schem_java.sql");
    	
    	files.add( dir + "/" + "04_meta_data_abap.sql");
    	files.add( dir + "/" + "0402_meta_data_java.sql");
    	files.add( dir + "/" + "0403_meta_column_data.sql");
    	files.add( dir + "/" + "0404_meta_duration_data.sql");
    	files.add( dir + "/" + "0406_meta_user_data.sql");
    	
    	files.add( dir + "/" + "05_msg_bundle.sql");
    	files.add( dir + "/" + "0501_msg_bundle_abap.sql");
    	files.add( dir + "/" + "0502_msg_bundle_java.sql");
    	
    	files.add( dir + "/" + "09_site_template.sql");
    	
    	try {
			combineFiles( files.toArray(new String[0]), dir + "/" + "100_combine_sqls.sql", "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    

}
