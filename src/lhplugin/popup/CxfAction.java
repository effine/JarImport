/**
 * @author Verphen
 * @date 2013��8��8��  ����2:24:39
 */

package lhplugin.popup;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class CxfAction extends SuperDelegate {
	/**
	 * Constructor for Action1.
	 */
	public CxfAction() {
		super();
	}

	// Ӧ���ǲ��jar������Ӧjar����λ��
	private String dir = "lib/cxf";
	private String sign = "cxf";

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		super.run(dir, sign);
	}
}
