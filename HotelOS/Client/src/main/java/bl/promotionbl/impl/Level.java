package bl.promotionbl.impl;

/**
 * Created by kevin on 2016/11/18.
 */
public interface Level extends Promotion {
    /**
     * Gets level.
     *
     * @param credit the credit
     * @return the level
     */
    int getLevel(double credit);
}
