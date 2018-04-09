package hei.devweb.traderz.dao.impl;

import hei.devweb.traderz.dao.CotationDao;
import hei.devweb.traderz.dao.DataSourceProvider;
import hei.devweb.traderz.entities.Cotation;
import yahoofinance.Stock;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CotationDaoImpl implements CotationDao {

    //Retourne un objet Cotation à partir de su identifiant
    public Cotation CreateCotationFromId (Integer id){
        java.text.DecimalFormat df = new java.text.DecimalFormat("0.###"); // Utilisé pour donner un double avec seulement 2 chiffres

        String query = "SELECT * FROM cotations WHERE cotation_id = ?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()){

                    return new Cotation(
                            resultSet.getInt("cotation_id"),
                            resultSet.getString("cotation_nom"),
                            resultSet.getString("cotation_categorie"),
                            resultSet.getDouble("cotation_prix"),
                            resultSet.getDouble("cotation_haut"),
                            resultSet.getDouble("cotation_bas"),
                            resultSet.getDouble("cotation_varjour"),
                            resultSet.getDouble("cotation_veille"),
                            resultSet.getDouble("cotation_ouverture"),
                            resultSet.getInt("cotation_volume"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Double GetCotationPrixById (Integer id){

        String query = "SELECT cotation_prix FROM cotations WHERE cotation_id = ?";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()){

                    return new Double(
                            resultSet.getDouble("cotation_prix"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cotation> listCotationAD(){
        List<Cotation> cotations = new ArrayList<>();
        String query = "SELECT * FROM cotations WHERE cotation_nom LIKE 'A%' OR cotation_nom LIKE 'B%' OR cotation_nom LIKE 'C%' OR cotation_nom LIKE 'D%'";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cotations.add(new Cotation(
                            resultSet.getInt("cotation_id"),
                            resultSet.getString("cotation_nom"),
                            resultSet.getString("cotation_categorie"),
                            resultSet.getDouble("cotation_prix"),
                            resultSet.getDouble("cotation_haut"),
                            resultSet.getDouble("cotation_bas"),
                            resultSet.getDouble("cotation_varjour"),
                            resultSet.getDouble("cotation_veille"),
                            resultSet.getDouble("cotation_ouverture"),
                            resultSet.getInt("cotation_volume")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotations;
    }

    public List<Cotation> listCotationEG(){
        List<Cotation> cotations = new ArrayList<>();
        String query = "SELECT * FROM cotations WHERE cotation_nom LIKE 'E%' OR cotation_nom LIKE 'F%' OR  cotation_nom LIKE 'G%'";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cotations.add(new Cotation(
                            resultSet.getInt("cotation_id"),
                            resultSet.getString("cotation_nom"),
                            resultSet.getString("cotation_categorie"),
                            resultSet.getDouble("cotation_prix"),
                            resultSet.getDouble("cotation_haut"),
                            resultSet.getDouble("cotation_bas"),
                            resultSet.getDouble("cotation_varjour"),
                            resultSet.getDouble("cotation_veille"),
                            resultSet.getDouble("cotation_ouverture"),
                            resultSet.getInt("cotation_volume")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotations;
    }


    public List<Cotation> listCotationHL(){
        List<Cotation> cotations = new ArrayList<>();
        String query = "SELECT * FROM cotations WHERE cotation_nom LIKE 'H%' OR cotation_nom LIKE 'I%'OR cotation_nom LIKE 'J%' OR cotation_nom LIKE 'K%' OR cotation_nom LIKE 'L%'";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cotations.add(new Cotation(
                            resultSet.getInt("cotation_id"),
                            resultSet.getString("cotation_nom"),
                            resultSet.getString("cotation_categorie"),
                            resultSet.getDouble("cotation_prix"),
                            resultSet.getDouble("cotation_haut"),
                            resultSet.getDouble("cotation_bas"),
                            resultSet.getDouble("cotation_varjour"),
                            resultSet.getDouble("cotation_veille"),
                            resultSet.getDouble("cotation_ouverture"),
                            resultSet.getInt("cotation_volume")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotations;
    }

    public List<Cotation> listCotationMP(){
        List<Cotation> cotations = new ArrayList<>();
        String query = "SELECT * FROM cotations WHERE cotation_nom LIKE 'M%' OR cotation_nom LIKE 'N%'OR cotation_nom LIKE 'O%' OR cotation_nom LIKE 'P%'";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cotations.add(new Cotation(
                            resultSet.getInt("cotation_id"),
                            resultSet.getString("cotation_nom"),
                            resultSet.getString("cotation_categorie"),
                            resultSet.getDouble("cotation_prix"),
                            resultSet.getDouble("cotation_haut"),
                            resultSet.getDouble("cotation_bas"),
                            resultSet.getDouble("cotation_varjour"),
                            resultSet.getDouble("cotation_veille"),
                            resultSet.getDouble("cotation_ouverture"),
                            resultSet.getInt("cotation_volume")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotations;
    }

    public List<Cotation> listCotationQT(){
        List<Cotation> cotations = new ArrayList<>();
        String query = "SELECT * FROM cotations WHERE cotation_nom LIKE 'Q%' OR cotation_nom LIKE 'R%'OR cotation_nom LIKE'S%' OR cotation_nom LIKE'T%'";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cotations.add(new Cotation(
                            resultSet.getInt("cotation_id"),
                            resultSet.getString("cotation_nom"),
                            resultSet.getString("cotation_categorie"),
                            resultSet.getDouble("cotation_prix"),
                            resultSet.getDouble("cotation_haut"),
                            resultSet.getDouble("cotation_bas"),
                            resultSet.getDouble("cotation_varjour"),
                            resultSet.getDouble("cotation_veille"),
                            resultSet.getDouble("cotation_ouverture"),
                            resultSet.getInt("cotation_volume")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotations;
    }

    public List<Cotation> listCotationUZ(){
        List<Cotation> cotations = new ArrayList<>();
        String query = "SELECT * FROM cotations WHERE cotation_nom LIKE 'U%' OR cotation_nom LIKE 'V%' OR cotation_nom LIKE 'W%' OR cotation_nom LIKE 'X%' OR cotation_nom LIKE 'Y%' OR cotation_nom LIKE'Z%'";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cotations.add(new Cotation(
                            resultSet.getInt("cotation_id"),
                            resultSet.getString("cotation_nom"),
                            resultSet.getString("cotation_categorie"),
                            resultSet.getDouble("cotation_prix"),
                            resultSet.getDouble("cotation_haut"),
                            resultSet.getDouble("cotation_bas"),
                            resultSet.getDouble("cotation_varjour"),
                            resultSet.getDouble("cotation_veille"),
                            resultSet.getDouble("cotation_ouverture"),
                            resultSet.getInt("cotation_volume")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cotations;
    }

    /**
     * Rentre les details d'une action provenant de l'API Yahoo Finance dans la table cotation
     * @param stock  objet retourné par l'API contenant toutes les informations sur l'action
     */
    public void InitCotation (Stock stock){
        String query = "INSERT INTO `cotations` (`cotation_categorie`,`cotation_nom`,`cotation_prix`,`cotation_haut`,`cotation_bas`,`cotation_varjour`,`cotation_veille`,`cotation_ouverture`,`cotation_volume`)\n" +
                "VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1,stock.getCurrency());
            statement.setString(2,stock.getName());
            statement.setDouble(3,(stock.getQuote().getPrice()).doubleValue());
            statement.setDouble(4,(stock.getQuote().getDayHigh()).doubleValue());
            statement.setDouble(5,(stock.getQuote().getDayLow()).doubleValue());
            statement.setDouble(6,(stock.getQuote().getChangeInPercent()).doubleValue());
            statement.setDouble(7,(stock.getQuote().getPreviousClose()).doubleValue());
            statement.setDouble(8,(stock.getQuote().getOpen()).doubleValue());
            statement.setInt(9,(stock.getQuote().getVolume().intValue()));
            statement.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException("Error when getting cotations stats");
        }
    }

   /* public void AllCotationsCAC40(){
        String[] listeCotations = new String[]{"BN.PA","SAN.PA","ORA.PA","ML.PA","OR.PA","CAP.PA","FP.PA","EI.PA","GLE.PA","KER.PA","SGO.PA","EN.PA","LHN.PA","ENGI.PA","FR.PA","SW.PA","ATO.PA","UG.PA","AIR.PA","DG.PA","SU.PA","MC.PA","VIV.PA","AI.PA","BNP.PA","VIE.PA","ACA.PA","CA.PA","AC.PA","LR.PA"};
        Map<String, Stock> stocks = YahooFinance.get(listeCotations);
        String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
        Map<String, Stock> stocks = YahooFinance.get(symbols);
        for (int i = 0; i < listeCotations.length; i++) { // Boucle qui va récupérer les noms des cotations du tableaux de string symbols
            String cotation = listeCotations[i];
            InitCotation(YahooFinance.get("BN.PA"));
        }
    }*/

    /**
     * Supprime les valeurs contenues dans la table cotation
     */
    public void CleanCotations (){
        String query = "DELETE FROM `cotations`";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException("Error when deleting table ",e);
        }

    }
}
