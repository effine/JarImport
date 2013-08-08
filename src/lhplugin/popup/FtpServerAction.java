/**
 * @author Verphen
 * @date 2013年8月8日  下午2:25:50
 */

package lhplugin.popup;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import lhplugin.util.FtpGen;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class FtpServerAction extends SuperDelegate {

	/**
	 * Constructor for Action1.
	 */
	public FtpServerAction() {
		super();
	}

	// 应该是插件jar包的相应jar包的位置
	private String dir = "lib/ftpserver";
	private String sign = "ftpserver";

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		final IJavaProject project = run(dir, sign);
		IRunnableWithProgress process = new IRunnableWithProgress() {

			public void run(IProgressMonitor m)
					throws InvocationTargetException, InterruptedException {
				try {
					// TODO Auto-generated method stub
					m.beginTask("开始创建conf文件夹", 3);
					createFolder(project, "conf");
					m.worked(1);
					m.setTaskName("开始插件配置文件");
					createFile(project, new String[] {
							"lib/ftpserver/ftpserver.jks",
							"lib/ftpserver/users.properties" }, new String[] {
							"conf/ftpserver.jks", "conf/users.properties" });
					m.worked(1);
					m.setTaskName("开始生成代码");
					FtpGen gen = new FtpGen();
					String content = gen.generate(null);
					createFolder(project, "src/com");
					createFolder(project, "src/com/lh");
					createFolder(project, "src/com/lh/utils");
					IFile javaFile = project.getProject().getFile(
							"src/com/lh/utils/FtpServerUtils.java");
					project.getProject().refreshLocal(1, m);
					InputStream stream = new ByteArrayInputStream(
							content.getBytes());
					javaFile.create(stream, false, m);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
