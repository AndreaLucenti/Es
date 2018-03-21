package BancaV2;

public abstract class AbstractAccountable implements Accountable{
    private Accountabletype Type;

    public AbstractAccountable(Accountabletype type) {
        Type = type;
    }

    public Accountabletype getType() {
        return Type;
    }


}
