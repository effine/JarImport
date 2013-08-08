/**
 * @author Verphen
 * @date 2013年8月8日  下午2:14:43
 */

package lhplugin.popup;

import jarimport.Activator;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;

/**
 * 处理拷贝 jar 包的任务；每一个类型的jar包添加菜单对应一个Action,且都实现该继承
 */
public abstract class SuperDelegate implements IObjectActionDelegate {

	public String[] getAllJar(String sign) throws IOException {
		// 通过获取jar包中的 config文件从而不去到对应的jar包的名称
		URL config = Activator.getDefault().getBundle()
				.getEntry("jarconfig.properties");
		InputStream stream = config.openStream();
		Properties p = new Properties();
		p.load(stream);
		String sshpackage = p.getProperty(sign);
		return sshpackage.split(";");
	}

	public static void createFolder(IJavaProject project, String src) {
		URL proUrl = Activator.getDefault().getBundle().getEntry(src);
		IFolder folder = project.getProject().getFolder(src);
		if (!folder.exists())
			try {
				folder.create(true, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
	}

	public static void createFile(IJavaProject project, String[] src,
			String[] dst) {
		for (int i = 0; i < src.length; i++) {
			String pro = src[i];
			URL proUrl = Activator.getDefault().getBundle().getEntry(pro);
			IFile file = project.getProject().getFile(dst[i]);
			try {
				file.create(proUrl.openStream(), false,
						new NullProgressMonitor());
			} catch (CoreException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean classPathExists(IClasspathEntry[] entrys,
			IClasspathEntry entry) {
		for (int i = 0, n = entrys.length; i < n; i++) {
			if (entrys[i].getPath().equals(entry.getPath())) {
				return true;
			}
		}
		return false;
	}

	public IJavaProject run(final String dir, final String sign) {

		final Object obj = selection.getFirstElement();
		if (obj instanceof IJavaProject) {
			final IJavaProject project = (IJavaProject) obj;
			IRunnableWithProgress process = new IRunnableWithProgress() {

				public void run(IProgressMonitor m)
						throws InvocationTargetException, InterruptedException {
					try {
						m.beginTask("开始获取源路径和对应jar包路径", 2);
						// 获取jar包中的lib目录

						// 获取到工程下面所有的classpath
						// 通过配置文件获取到对应的jar包
						String[] list = getAllJar(sign);
						m.worked(1);
						m.setTaskName("开始拷贝jar包及设置源路径");
						// 判断lib到底是在根目录下 还是web工程的webroot下面
						String libPath = "lib/";
						IFolder libFolder = project.getProject().getFolder(
								"WebRoot/WEB-INF/lib/");
						if (libFolder.exists())
							libPath = "WebRoot/WEB-INF/lib/";

						// 循环拷贝jar包 以及设置环境变量
						for (String file : list) {
							// 如何是jar包的话 就要设置环境变量
							if (file.endsWith(".jar")) {
								IClasspathEntry[] entry = project
										.readRawClasspath();

								IClasspathEntry newentry = JavaCore
										.newLibraryEntry(project.getProject()
												.getFile(libPath + file)
												.getFullPath(), null, null);
								if (!classPathExists(entry, newentry)) {
									IClasspathEntry[] ceArray = new IClasspathEntry[entry.length + 1];
									System.arraycopy(entry, 0, ceArray, 0,
											entry.length);

									IFile ctFile = project.getProject()
											.getFile(libPath + file);
									URL fileUrl = Activator.getDefault()
											.getBundle()
											.getEntry(dir + "/" + file);

									IFolder folder = project.getProject()
											.getFolder(libPath);
									if (!folder.exists())
										folder.create(true, true, null);
									ctFile.create(fileUrl.openStream(), false,
											m);

									ceArray[ceArray.length - 1] = newentry;
									project.setRawClasspath(ceArray, m);

								}
								// 如果不是jar包就不管
							}
						}
						m.worked(1);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						m.done();
					}

				}

			};
			ProgressMonitorDialog d = new ProgressMonitorDialog(null);
			try {
				d.run(true, false, process);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return project;
		}
		return null;

	}

	IStructuredSelection selection = null;

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection != null && selection instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) selection;
		}
	}

}
