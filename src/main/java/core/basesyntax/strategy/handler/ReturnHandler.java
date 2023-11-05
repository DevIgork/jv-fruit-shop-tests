package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        fruitDao.getStorage().put(fruitName, fruitDao.get(fruitName) + fruitQuantity);
    }
}