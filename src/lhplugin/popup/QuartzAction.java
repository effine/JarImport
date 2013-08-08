/**
 * @author Verphen
 * @date 2013年8月8日  下午2:30:17
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

	// 应该是插件jar包的相应jar包的位置
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
