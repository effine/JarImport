/**
 * @author Verphen
 * @date 2013��8��8��  ����2:31:25
 */

package lhplugin.popup;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class Struts2Action extends SuperDelegate {

	/**
	 * Constructor for Action1.
	 */
	public Struts2Action() {
		super();
	}

	// Ӧ���ǲ��jar������Ӧjar����λ��
	private String dir = "lib/struts2";
	private String sign = "struts2";

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IJavaProject project = run(dir, sign);
		createFile(project, new String[] { "lib/struts2/struts.xml",
				"lib/struts2/system.xml", "lib/struts2/struts.properties" },
				new String[] { "src/struts.xml", "src/system.xml",
						"src/struts.properties" });
	}

}