/**
 * @author Verphen
 * @date 2013��8��8��  ����2:30:49
 */

package lhplugin.popup;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class SSHAction extends SuperDelegate {

	/**
	 * Constructor for Action1.
	 */
	public SSHAction() {
		super();
	}

	// Ӧ���ǲ��jar������Ӧjar����λ��
	private String dir = "lib/ssh";
	private String sign = "ssh";

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
