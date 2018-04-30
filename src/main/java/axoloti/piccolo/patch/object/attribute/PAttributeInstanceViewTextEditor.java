package axoloti.piccolo.patch.object.attribute;

import axoloti.abstractui.DocumentWindow;
import axoloti.abstractui.IAxoObjectInstanceView;
import axoloti.patch.object.attribute.AttributeInstanceController;
import axoloti.patch.object.attribute.AttributeInstanceTextEditor;
import axoloti.piccolo.components.control.PButtonComponent;
import axoloti.swingui.TextEditor;
import javax.swing.SwingUtilities;

class PAttributeInstanceViewTextEditor extends PAttributeInstanceViewString {

    PButtonComponent bEdit;

    public PAttributeInstanceViewTextEditor(AttributeInstanceController controller, IAxoObjectInstanceView axoObjectInstanceView) {
        super(controller, axoObjectInstanceView);
        initComponents();
    }

    @Override
    public AttributeInstanceTextEditor getModel() {
        return (AttributeInstanceTextEditor) super.getModel();
    }

    void showEditor() {
        if (getModel().editor == null) {
            DocumentWindow dw = (DocumentWindow) SwingUtilities.getWindowAncestor(this.getProxyComponent());
            getModel().editor = new TextEditor(AttributeInstanceTextEditor.ATTR_VALUE, getController(), dw);
            getModel().editor.setTitle(getModel().getParent().getInstanceName() + "/" + getModel().getModel().getName());
        }
        getModel().editor.toFront();

        // TODO verify this
        getModel().editor.setState(java.awt.Frame.NORMAL);
        getModel().editor.setVisible(true);
    }

    private void initComponents() {
        bEdit = new PButtonComponent("Edit", axoObjectInstanceView);
        addChild(bEdit);
        bEdit.addActListener(new PButtonComponent.ActListener() {
            @Override
            public void OnPushed() {
                showEditor();
            }
        });
    }

    @Override
    public void Lock() {
        if (bEdit != null) {
            bEdit.setEnabled(false);
        }
    }

    @Override
    public void UnLock() {
        if (bEdit != null) {
            bEdit.setEnabled(true);
        }
    }

    @Override
    public void setString(String sText) {
        getModel().setValue(sText);
        if (getModel().editor != null) {
            getModel().editor.SetText(sText);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
