/**
 * @author Verphen
 * @date 2013年8月8日  下午2:29:00
 */

package lhplugin.popup;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class LunceneAction extends SuperDelegate {

	/**
	 * Constructor for Action1.
	 */
	public LunceneAction() {
		super();
	}

	// 应该是插件jar包的相应jar包的位置
	private String dir = "lib/lucene";
	private String sign = "lucene";

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

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
