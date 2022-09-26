package examples.unit01.components.e15_gridbag;

import java.awt.*;

/**
 * This class simplifies the use of the GridConstraints class
 * @author German Carreño
 */
public class GBC extends GridBagConstraints {

    /**
     * Construct a GBC with given gridx and gridy position and all other grid
     * bag constraint values set to default
     * @param gridx the gridx, position
     * @param gridy the gridy, position
     */
    public GBC(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    /**
     * Construct a GBC with given gridx, gridy, gridwidth, gridheight and
     * all other grid bag constraint values set to the default
     * @param gridx The gridx position
     * @param gridy The gridy position
     * @param gridwidth The cell span in x-direction
     * @param gridheight The cell span in y-direction
     */
    public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    /**
     * Sets the fill direction
     * @param anchor The fill direction
     * @return this object for further modification
     */
    public GBC setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    /**
     * Sets the fill direction
     * @param fill The fill direction
     * @return this object for further modification
     */
    public GBC setFill(int fill) {
        this.fill = fill;
        return this;
    }

    /**
     * Sets the cell weight
     * @param weightx The cell weight in x-direction
     * @param weighty The cell weight in y-direction
     * @return this object for further modification
     */
    public GBC setWeight(double weightx, double weighty) {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    /**
     * Sets the insets of this cell
     * @param distance The spacing to use in all directions
     * @return this object for further modification
     */
    public GBC setInsets(int distance) {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    /**
     * Sets the insets of this cell
     * @param top The spacing to use on top
     * @param left The spacing to use on left
     * @param bottom The spacing to use on bottom
     * @param right The spacing to use on right
     * @return this object for further modification
     */
    public GBC setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     * Sets the internal padding
     * @param ipadx The internal padding in x-direction
     * @param ipady The internal padding in y-direction
     * @return this object for further modification
     */
    public GBC setIpad(int ipadx, int ipady) {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
