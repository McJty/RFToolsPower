package mcjty.rftoolspower.modules.monitor.client;

import mcjty.lib.container.GenericContainer;
import mcjty.lib.gui.GenericGuiContainer;
import mcjty.lib.gui.Window;
import mcjty.lib.gui.widgets.Panel;
import mcjty.lib.gui.widgets.ScrollableLabel;
import mcjty.lib.gui.widgets.Slider;
import mcjty.lib.gui.widgets.Widgets;
import mcjty.rftoolsbase.tools.ManualHelper;
import mcjty.rftoolspower.RFToolsPower;
import mcjty.rftoolspower.modules.monitor.blocks.PowerMonitorTileEntity;
import mcjty.rftoolspower.setup.RFToolsPowerMessages;
import net.minecraft.entity.player.PlayerInventory;

import java.awt.*;

public class GuiPowerMonitor extends GenericGuiContainer<PowerMonitorTileEntity, GenericContainer> {

    private ScrollableLabel minimumLabel;
    private ScrollableLabel maximumLabel;

    public GuiPowerMonitor(PowerMonitorTileEntity te, GenericContainer container, PlayerInventory inventory) {
        super(RFToolsPower.instance, te, container, inventory, ManualHelper.create("rftoolspower:powermonitor/powermonitor"));

        xSize = 256;
        ySize = 50;
    }

    @Override
    public void init() {
        super.init();

        minimumLabel = new ScrollableLabel().name("minimum").suffix("%").desiredWidth(30).realMinimum(0).realMaximum(100)
                .realValue(tileEntity.getMinimum());
        Slider mininumSlider = new Slider().desiredHeight(15).horizontal().minimumKnobSize(15).tooltips("Minimum level").scrollableName("minimum");
        Panel minimumPanel = Widgets.horizontal().children(Widgets.label("Min:").desiredWidth(30), mininumSlider, minimumLabel).desiredHeight(20);

        maximumLabel = new ScrollableLabel().name("maximum").suffix("%").desiredWidth(30).realMinimum(0).realMaximum(100)
                .realValue(tileEntity.getMaximum());
        Slider maximumSlider = new Slider().desiredHeight(15).horizontal().minimumKnobSize(15).tooltips("Maximum level").scrollableName("maximum");
        Panel maximumPanel = Widgets.horizontal().children(Widgets.label("Max:").desiredWidth(30), maximumSlider, maximumLabel).desiredHeight(20);

        Panel toplevel = Widgets.vertical().filledRectThickness(2).children(minimumPanel, maximumPanel);
        toplevel.setBounds(new Rectangle(guiLeft, guiTop, xSize, ySize));
        window = new Window(this, toplevel);

        window.bind(RFToolsPowerMessages.INSTANCE, "minimum", tileEntity, PowerMonitorTileEntity.VALUE_MINIMUM.getName());
        window.bind(RFToolsPowerMessages.INSTANCE, "maximum", tileEntity, PowerMonitorTileEntity.VALUE_MAXIMUM.getName());
    }
}