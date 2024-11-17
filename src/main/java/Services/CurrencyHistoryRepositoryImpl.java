package Services;

import Databases.DatabaseConnection;
import Records.CurrencyHistory;
import Repository.CurrencyHistoryRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyHistoryRepositoryImpl implements CurrencyHistoryRepository {
    @Override
    public void save(CurrencyHistory history) {
        String query = "INSERT INTO currency_history (base_currency, target_currency, amount, result) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, history.base_code());
            preparedStatement.setString(2, history.target_code());
            preparedStatement.setDouble(3, history.amountToConvert() );
            preparedStatement.setDouble(4, history.amountConverted());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    @Override
    public List<CurrencyHistory> findAll() {
        List<CurrencyHistory> historyList = new ArrayList<>();
        String query = "SELECT * FROM currency_history";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query))
        {
            while (resultSet.next()){

                CurrencyHistory history = new CurrencyHistory(
                        resultSet.getString("base_currency"),
                        resultSet.getDouble("amount"),
                        resultSet.getString("target_currency"),
                        resultSet.getDouble("result"),
                        resultSet.getString("timestamp")
                );
                historyList.add(history);
            }
        }catch (SQLException e){
            System.err.println("Database error: " + e.getMessage());
        }
        return  historyList;
    }

    public void deleteAll(){
        String query = "DELETE FROM currency_history";

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){

            int rowsDeleted = preparedStatement.executeUpdate();

            System.out.println("Se eliminaron " + rowsDeleted + " registros de currency_history.");

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

}
