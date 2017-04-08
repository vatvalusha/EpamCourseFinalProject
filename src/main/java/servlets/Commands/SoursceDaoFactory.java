package servlets.Commands;

import dao.factory.DAOFactory;


/**
 * Created by valeriyartemenko on 05.04.17.
 */
public class SoursceDaoFactory {

    public static DAOFactory getDAOFactory() {
        return DAOFactory.getDaoFactory(DAOFactory.ConnTypes.BDConnection);
    }
}
