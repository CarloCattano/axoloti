package axoloti.piccolo.patch.object.parameter;

import axoloti.abstractui.IAxoObjectInstanceView;
import axoloti.patch.object.parameter.ParameterInstanceController;
import axoloti.piccolo.components.PAssignMidiCCMenuItems;
import axoloti.piccolo.components.control.PCheckboxComponent;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

class PParameterInstanceViewBin1 extends PParameterInstanceViewBin {

    public PParameterInstanceViewBin1(ParameterInstanceController controller, IAxoObjectInstanceView axoObjectInstanceView) {
        super(controller, axoObjectInstanceView);
    }

    @Override
    public PCheckboxComponent CreateControl() {
        return new PCheckboxComponent(0, 1, axoObjectInstanceView);
    }

    @Override
    public void ShowPreset(int i) {
    }

    @Override
    public PCheckboxComponent getControlComponent() {
        return (PCheckboxComponent) ctrl;
    }

    @Override
    public void populatePopup(JPopupMenu m) {
        super.populatePopup(m);
        JMenu m1 = new JMenu("Midi CC");
        // assignMidiCCMenuItems, does stuff in ctor
        PAssignMidiCCMenuItems assignMidiCCMenuItems = new PAssignMidiCCMenuItems(this, m1);
        m.add(m1);
    }
}
