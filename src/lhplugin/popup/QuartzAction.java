/**
 * @author Verphen
 * @date 2013��8��8��  ����2:30:17
 */

package lhplugin.popup;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;

public class QuartzAction extends SuperDelegate {

	/**
	 * Constructor for Action1.
	 */
	public QuartzAction() {
		super();
	}

	// Ӧ���ǲ��jar������Ӧjar����λ��
	private String dir = "lib/quartz";
	private String sign = "quartz";

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
