package hei.devweb.traderz.dao.impl;

import hei.devweb.traderz.dao.DataSourceProvider;
import hei.devweb.traderz.dao.TransactionDao;
import hei.devweb.traderz.entities.Cotation;
import hei.devweb.traderz.entities.Transaction;
import hei.devweb.traderz.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {


    // Ajoute à la BDD une nouvelle transaction dont le sens vaut 0 --> ACHETER
    public void Acheter (User user, Cotation cotation, Double volume){
        String query = "INSERT INTO `transactions` (`transac_user_pseudo`,`transac_volume`,`transac_cotation_categorie`,`transac_cotation_id`,`transac_cotation_prix`,`transac_cotation_nom`,`transac_sens`)\n" +
                "VALUE (?, ?, ?, ?, ?, ?, false)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,user.getIdentifiant());
            statement.setDouble(2,volume);
            statement.setString(3,cotation.getCategorie());
            statement.setInt(4,cotation.getIdCotation());
            statement.setDouble(5,cotation.getPrix());
            statement.setString(6,cotation.getCotationNom());
            statement.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException("Error when getting user",e);
        }
    }



    // Ajoute à la BDD une nouvelle transaction dont le sens vaut & --> VENDRE
    public void Vendre (User user, Cotation cotation, Double volume){
        String query = "INSERT INTO `transactions` (`transac_user_pseudo`,`transac_volume`,`transac_cotation_categorie`,`transac_cotation_id`,`transac_cotation_prix`,`transac_cotation_nom`,`transac_sens`)\n" +
                "VALUE (?, ?, ?, ?, ?, ?, true)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,user.getIdentifiant());
            statement.setDouble(2,volume);
            statement.setString(3,cotation.getCategorie());
            statement.setInt(4,cotation.getIdCotation());
            statement.setDouble(5,cotation.getPrix());
            statement.setString(6,cotation.getCotationNom());
            statement.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException("Error when getting user",e);
        }
    }


    public List<Transaction> listTransacByUser (String username){
        List<Transaction> transactions= new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE transac_user_pseudo = ?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    transactions.add(new Transaction(
                            resultSet.getInt("transac_id"),
                            resultSet.getString("transac_user_pseudo"),
                            resultSet.getString("transac_cotation_categorie"),
                            resultSet.getString("transac_cotation_nom"),
                            resultSet.getInt("transac_cotation_id"),
                            resultSet.getDouble("transac_cotation_prix"),
                            resultSet.getDouble("transac_volume"),
                            resultSet.getBoolean("transac_sens")));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }




}
