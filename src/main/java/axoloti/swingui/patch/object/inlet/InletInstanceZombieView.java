package axoloti.swingui.patch.object.inlet;

import axoloti.patch.object.iolet.IoletInstanceController;
import axoloti.swingui.components.LabelComponent;
import axoloti.swingui.patch.object.AxoObjectInstanceViewAbstract;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class InletInstanceZombieView extends InletInstanceView {

    public InletInstanceZombieView(IoletInstanceController controller, AxoObjectInstanceViewAbstract o) {
        super(controller, o);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        jack = new axoloti.swingui.components.JackInputComponent();
        jack.setForeground(getModel().getDataType().GetColor());
        add(jack);
        add(Box.createHorizontalStrut(2));
        add(new LabelComponent(getModel().getName()));
        add(Box.createHorizontalGlue());
    }

}
