package life.persistence;

import life.model.Universe;

import java.util.*;

public class UnvierseDAOImpl implements IUniverseDAO {
    private final List<Universe> universeList = new ArrayList<>();
    private final Map<Integer, Universe> universeMap = new HashMap<>();

    @Override
    public List<Universe> getUniverseList() {
        return null;
    }

    @Override
    public Universe getUniverse(int generation) {
        return null;
    }

    @Override
    public void addUniverse(Universe universe) {

    }

    @Override
    public void addUniverse(Collection<Universe> universeCollection) {

    }

    @Override
    public void changeUniverse(int generation, Universe newUniverse) {

    }

    @Override
    public void removeUniverse(int generation) {

    }
}
