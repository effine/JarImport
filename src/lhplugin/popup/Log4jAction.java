/**
 * @author Verphen
 * @date 2013��8��8��  ����2:27:50
 */

package lhplugin.popup;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class Log4jAction extends SuperDelegate {

	/**
	 * Constructor for Action1.
	 */
	public Log4jAction() {
		super();
	}

	// Ӧ���ǲ��jar������Ӧjar����λ��
	private String dir = "lib/log4j";
	private String sign = "log4j";

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IJavaProject project = super.run(dir, sign);
		super.createFile(project,
				new String[] { "lib/log4j/log4j.properties" },
				new String[] { "src/log4j.properties" });

	}

}
