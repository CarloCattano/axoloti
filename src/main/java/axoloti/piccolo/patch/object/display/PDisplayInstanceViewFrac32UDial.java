package axoloti.piccolo.patch.object.display;

import axoloti.abstractui.IAxoObjectInstanceView;
import axoloti.patch.object.display.DisplayInstance;
import axoloti.patch.object.display.DisplayInstanceController;
import axoloti.piccolo.components.displays.PDispComponent;
import java.beans.PropertyChangeEvent;

class PDisplayInstanceViewFrac32UDial extends PDisplayInstanceViewFrac32 {

    private PDispComponent dial;
    private IAxoObjectInstanceView axoObjectInstanceView;

    public PDisplayInstanceViewFrac32UDial(DisplayInstanceController controller, IAxoObjectInstanceView axoObjectInstanceView) {
        super(controller, axoObjectInstanceView);
	this.axoObjectInstanceView = axoObjectInstanceView;
        initComponents();
    }

    private void initComponents() {
        dial = new PDispComponent(0.0, 0.0, 64.0, axoObjectInstanceView);
        addChild(dial);
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
        super.modelPropertyChange(evt);
        if (DisplayInstance.DISP_VALUE.is(evt)) {
            dial.setValue((Double) evt.getNewValue());
        }
    }
}
