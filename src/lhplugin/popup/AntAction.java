/**
 * @author Verphen
 * @date 2013��8��8��  ����2:21:46
 */

package lhplugin.popup;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPart;

public class AntAction extends SuperDelegate {

	/**
	 * Constructor for Action1.
	 */
	public AntAction() {
		super();
	}

	// Ӧ���ǲ��jar������Ӧjar����λ��
	private String dir = "lib/ant";
	private String sign = "ant";

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	@Override
	public void run(IAction action) {
		IJavaProject project = super.run(dir, sign);
		super.createFile(project, new String[] { "lib/ant/build.xml" },
				new String[] { "build.xml" });
	}
}
