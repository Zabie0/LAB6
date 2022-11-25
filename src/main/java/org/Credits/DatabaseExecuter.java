package org.Credits;

import org.Credits.User.biler;

import java.sql.*;
public class DatabaseExecuter {
    private static final String connectionUrl =
            "jdbc:sqlserver://DESKTOP-1RDNU8A:1433;"
                    + "database=CreditsBase;"
                    + "user=Vlad;"
                    + "password=1337;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";

    public static void dbExecute(String sqlRequest) {
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static biler dbExecuteSelect(int num,String tot,String sqlRequest) throws SQLException {
        ResultSet resultSet = null;
        biler biler = new biler();
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {

            // Create and execute a SELECT SQL statement.
            resultSet = statement.executeQuery(sqlRequest);
            while(resultSet.next()){
               biler.setId(resultSet.getInt(num));
               if(tot != "null") {
                   biler.setName(resultSet.getString(tot));
               }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return biler;
    }
    public static biler dbExecuteSelect4(String name1, String name2, String name3, String name4, String sqlRequest) throws SQLException {
        ResultSet resultSet = null;
        biler biler = new biler();
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {
            // Create and execute a SELECT SQL statement.
            resultSet = statement.executeQuery(sqlRequest);
            while(resultSet.next()){
                biler.setId(resultSet.getInt(name1));
                biler.setId1(resultSet.getInt(name2));
                biler.setId2(resultSet.getInt(name3));
                biler.setId3(resultSet.getInt(name4));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return biler;
    }
    public static biler dbExecuteSelect8(String name1, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String sqlRequest) throws SQLException {
        ResultSet resultSet = null;
        biler biler = new biler();
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {
            // Create and execute a SELECT SQL statement.
            resultSet = statement.executeQuery(sqlRequest);
            while(resultSet.next()){
                biler.setId(resultSet.getInt(name1));
                biler.setId1(resultSet.getInt(name2));
                biler.setId2(resultSet.getInt(name3));
                biler.setId3(resultSet.getInt(name4));
                biler.setId4(resultSet.getInt(name5));
                biler.setId5(resultSet.getInt(name6));
                biler.setId6(resultSet.getInt(name7));
                biler.setId7(resultSet.getInt(name8));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return biler;
    }
    public static void dbExecuteShowAllBanks(String sqlRequest) {
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {

            resultSet = statement.executeQuery(sqlRequest);
            while(resultSet.next()){
                System.out.println("Bank id: "+resultSet.getInt("bankId")+"\nName: "+resultSet.getString("name")+"\nAddress: "+resultSet.getString("address")+"\nEmail: "+resultSet.getString("email")+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dbExecuteShowAllCredits(String sqlRequest) {
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {

            resultSet = statement.executeQuery(sqlRequest);
            while(resultSet.next()){
                System.out.println("CreditId: "+resultSet.getInt("creditId")+"\nMoney given: "+resultSet.getString("moneyGiven")+"\nPercentage: "+resultSet.getString("percentage")+"\nMonths to repay: "+resultSet.getString("months")+"\nDebt: "+resultSet.getString("moneyToGive")+"\nCredit line is extendable: "+resultSet.getString("creditLineExtendable")+"\nMax extendable money: "+resultSet.getString("maxExtendableMoney")+"\nExtended percentage: "+resultSet.getString("extendedPercentage")+"\nBank: "+resultSet.getString("name")+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dbExecuteShowFilter(String sqlRequest) {
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement()) {

            resultSet = statement.executeQuery(sqlRequest);
            while (resultSet.next()) {
                System.out.println("CreditId: "+resultSet.getInt("creditId")+"\nMoney given: "+resultSet.getString("moneyGiven")+"\nPercentage: "+resultSet.getString("percentage")+"\nMonths to repay: "+resultSet.getString("months")+"\nDebt: "+resultSet.getString("moneyToGive")+"\nCredit line is extendable: "+resultSet.getString("creditLineExtendable")+"\nMax extendable money: "+resultSet.getString("maxExtendableMoney")+"\nExtended percentage: "+resultSet.getString("extendedPercentage")+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}