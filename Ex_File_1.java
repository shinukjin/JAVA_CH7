package a.b.c.ch7;

public class Ex_File_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userHome = System.getProperty("user.home");
		System.out.println("userHome ����Ȩ >>> : " + userHome);
		
		String javaVersion = System.getProperty("java.version");
		System.out.println("javaVersion ����Ȩ >>> : " + javaVersion);

		String userDir = System.getProperty("user.dir");
		System.out.println("userDir ����Ȩ >>> : " + userDir);

		String osName = System.getProperty("os.name");
		System.out.println("osName ����Ȩ >>> : " + osName);	
		
		String fileSeparator = System.getProperty("file.separator");
		System.out.println("fileseparation ���� ������ >>>> : " + fileSeparator);
		System.out.println("java.io.File.separation ���� ������ " + java.io.File.separator);
		
		String pathSeparator = System.getProperty("path.separatop");
		System.out.println("pathSeparator ��� ������ >>> : " + pathSeparator);
		
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
