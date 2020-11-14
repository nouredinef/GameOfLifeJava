package life.persistence;

import life.model.Universe;

import java.util.Collection;
import java.util.List;

public interface IUniverseDAO {

    /**
     * @return The list of all saved Universes
     */
    public List<Universe> getUniverseList();

    /**
     * @param generation the generation wanted
     * @return The universe corresponding to the given generation
     */
    public Universe getUniverse(int generation);

    /**
     * @param universe The universe to add. It will be added to the end.
     */
    public void addUniverse(Universe universe);

    /**
     * @param universeCollection The collection of universes to add
     *                           It will be added to the end of the current data
     */
    public void addUniverse(Collection<Universe> universeCollection);

    /**
     * @param generation  the generation number to change
     * @param newUniverse the new universe
     */
    public void changeUniverse(int generation, Universe newUniverse);

    /**
     * @param generation The generation to remove
     */
    public void removeUniverse(int generation);
}
