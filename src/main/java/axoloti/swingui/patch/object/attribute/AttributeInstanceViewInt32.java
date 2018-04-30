package axoloti.swingui.patch.object.attribute;

import axoloti.abstractui.IAxoObjectInstanceView;
import axoloti.patch.object.attribute.AttributeInstanceController;
import axoloti.patch.object.attribute.AttributeInstanceInt32;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@Deprecated // we shall not use Swing controls in a patch
class AttributeInstanceViewInt32 extends AttributeInstanceViewInt {

    JSlider slider;
    JLabel vlabel;

    AttributeInstanceViewInt32(AttributeInstanceController controller, IAxoObjectInstanceView axoObjectInstanceView) {
        super(controller, axoObjectInstanceView);
        initComponents();
    }

    @Override
    public AttributeInstanceInt32 getModel() {
        return (AttributeInstanceInt32) super.getModel();
    }

    private void initComponents() {
        slider = new JSlider();
        Dimension d = slider.getSize();
        d.width = 128;
        d.height = 22;
        if (getModel().getValueInteger() < getModel().getModel().getMinValue()) {
            getModel().setValue(getModel().getModel().getMinValue());
        }
        if (getModel().getValueInteger() > getModel().getModel().getMaxValue()) {
            getModel().setValue(getModel().getModel().getMaxValue());
        }
        slider.setMinimum(getModel().getModel().getMinValue());
        slider.setMaximum(getModel().getModel().getMaxValue());
        slider.setValue(getModel().getValueInteger());
        slider.setMaximumSize(d);
        slider.setMinimumSize(d);
        slider.setPreferredSize(d);
        slider.setSize(d);
        add(slider);
        vlabel = new JLabel();
        vlabel.setText("       " + getModel().getValue());
        add(vlabel);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                getModel().setValue(slider.getValue());
                vlabel.setText("" + getModel().getValue());
            }
        });
    }

    @Override
    public void Lock() {
        if (slider != null) {
            slider.setEnabled(false);
        }
    }

    @Override
    public void UnLock() {
        if (slider != null) {
            slider.setEnabled(true);
        }
    }
}
