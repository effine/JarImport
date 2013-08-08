/**
 * @author Verphen
 * @date 2013年8月8日  下午2:35:40
 */

package lhplugin.util;

public class FtpGen {
	protected static String nl;

	public static synchronized FtpGen create(String lineSeparator) {
		nl = lineSeparator;
		FtpGen result = new FtpGen();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties()
			.getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "package com.lh.utils;"
			+ NL
			+ "import java.io.File;"
			+ NL
			+ ""
			+ NL
			+ "import org.apache.ftpserver.FtpServer;"
			+ NL
			+ "import org.apache.ftpserver.FtpServerFactory;"
			+ NL
			+ "import org.apache.ftpserver.ftplet.FtpException;"
			+ NL
			+ "import org.apache.ftpserver.listener.ListenerFactory;"
			+ NL
			+ "import org.apache.ftpserver.ssl.SslConfigurationFactory;"
			+ NL
			+ "import org.apache.ftpserver.usermanager.PasswordEncryptor;"
			+ NL
			+ "import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;"
			+ NL
			+ ""
			+ NL
			+ "public class FtpServerUtils {"
			+ NL
			+ ""
			+ NL
			+ "/t/**"
			+ NL
			+ "/t * @param args"
			+ NL
			+ "/t * @throws FtpException"
			+ NL
			+ "/t */"
			+ NL
			+ "/tpublic static void startServer() throws FtpException {"
			+ NL
			+ "/t/t// TODO Auto-generated method stub"
			+ NL
			+ "/t/tFtpServerFactory serverFactory = new FtpServerFactory();"
			+ NL
			+ "/t/tListenerFactory factory = new ListenerFactory();"
			+ NL
			+ "/t/tfactory.setPort(21);"
			+ NL
			+ "/t/t// define SSL configuration"
			+ NL
			+ "/t/t/**"
			+ NL
			+ "/t/t * 使用ssl会导致客户端无法连接 SslConfigurationFactory ssl = new"
			+ NL
			+ "/t/t * SslConfigurationFactory(); ssl.setKeystoreFile(new"
			+ NL
			+ "/t/t * File(System.getProperty('user.dir')+'/conf/ftpserver.jks'));"
			+ NL
			+ "/t/t * ssl.setKeystorePassword('password');"
			+ NL
			+ "/t/t *  // set the SSL configuration for the listener"
			+ NL
			+ "/t/t * factory.setSslConfiguration(ssl.createSslConfiguration());"
			+ NL
			+ "/t/t * factory.setImplicitSsl(true);"
			+ NL
			+ "/t/t */"
			+ NL
			+ "/t/t// replace the default listener"
			+ NL
			+ "/t/tserverFactory.addListener('default', factory.createListener());"
			+ NL
			+ ""
			+ NL
			+ "/t/tPropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();"
			+ NL
			+ "/t/tuserManagerFactory.setFile(new File(System.getProperty('user.dir')"
			+ NL
			+ "/t/t/t/t+ '/conf/users.properties'));"
			+ NL
			+ "/t/tuserManagerFactory.setPasswordEncryptor(new PasswordEncryptor() {"
			+ NL
			+ ""
			+ NL
			+ "/t/t/tpublic String encrypt(String pwd) {"
			+ NL
			+ "/t/t/t/t// TODO Auto-generated method stub"
			+ NL
			+ "/t/t/t/treturn null;"
			+ NL
			+ "/t/t/t}"
			+ NL
			+ "/t/t/t//storedPassword 配置文件中配置的密码 passwordToCheck 是用户输入的密码"
			+ NL
			+ "/t/t/tpublic boolean matches(java.lang.String passwordToCheck,"
			+ NL
			+ "/t/t/t/t/tjava.lang.String storedPassword) {"
			+ NL
			+ "/t/t/t/tif (passwordToCheck.equals(storedPassword))"
			+ NL
			+ "/t/t/t/t/treturn true;"
			+ NL
			+ "/t/t/t/treturn false;"
			+ NL
			+ "/t/t/t}"
			+ NL
			+ ""
			+ NL
			+ "/t/t});"
			+ NL
			+ "/t/tserverFactory.setUserManager(userManagerFactory.createUserManager());"
			+ NL + "" + NL + "/t/t// start the server" + NL
			+ "/t/tFtpServer server = serverFactory.createServer();" + NL + ""
			+ NL + "/t/tserver.start();" + NL + "/t/t" + NL + "/t}" + NL + ""
			+ NL + "}";
	protected final String TEXT_2 = NL;

	public String generate(Object argument) {
		final StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}
}
