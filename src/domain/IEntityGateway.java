package domain;

import java.util.List;

public interface IEntityGateway {

    public List<String> readLines();

    public void reset();

}
