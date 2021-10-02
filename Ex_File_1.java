package a.b.c.ch7;

public class Ex_File_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userHome = System.getProperty("user.home");
		System.out.println("userHome 蜡历权 >>> : " + userHome);
		
		String javaVersion = System.getProperty("java.version");
		System.out.println("javaVersion 蜡历权 >>> : " + javaVersion);

		String userDir = System.getProperty("user.dir");
		System.out.println("userDir 蜡历权 >>> : " + userDir);

		String osName = System.getProperty("os.name");
		System.out.println("osName 蜡历权 >>> : " + osName);	
		
		String fileSeparator = System.getProperty("file.separator");
		System.out.println("fileseparation 颇老 备巩磊 >>>> : " + fileSeparator);
		System.out.println("java.io.File.separation 颇老 备巩磊 " + java.io.File.separator);
		
		String pathSeparator = System.getProperty("path.separatop");
		System.out.println("pathSeparator 版肺 备盒磊 >>> : " + pathSeparator);
		
//		java.util.Properties p = System.getProperties();
//		// System.out.println("System.getProperties() \n" + p);
//		
//		for (java.util.Enumeration e = p.propertyNames(); e.hasMoreElements();) {
//			String key = (String)e.nextElement();
//			String value = p.getProperty(key);	
//			//System.out.println(key + "=" + value);
//		}
//		
//		p.list(System.out);
	}

}
