package common.util;

import java.io.File;
/**
 * 
 * @author wangliang_gz@hotmail.com
 * @version 1.1.0
 */
public final class FileUtilsEx {

	private FileUtilsEx(){
	}
	
	public static String getRelativePath(File file, File dir) {
	    String sFile, sDir;
	    if (file == null) {
	      return null;
	    }
	    sFile = file.getAbsolutePath();
	    if (dir == null) {
	      return sFile;
	    }
	    sDir = dir.getAbsolutePath();
	    return org.apache.commons.lang.StringUtils.replace(sFile, sDir, "");
	  }
}
