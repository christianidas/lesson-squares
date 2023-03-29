package org.example.Grid.service;

import org.example.Grid.entity.Grid;
import org.example.Person.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GridService {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/squares?serverTimezone=UTC";
    private Integer id = 0;
    private final List<Grid> grids = new ArrayList<>();

    public Grid create(Grid grid) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO grid VALUES()");
            ps.executeUpdate();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Grid> getAll() {
        List<Grid> results = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement selectGridStatement = conn.prepareStatement("SELECT * FROM grid");
            ResultSet selectGridResult = selectGridStatement.executeQuery();

            while (selectGridResult.next()) {
                Grid grid = new Grid();
                int id = selectGridResult.getInt("id");
                grid.setId(id);
                results.add(grid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public Grid get(int index) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement selectGridStatement = conn.prepareStatement(String.format("SELECT * FROM grid WHERE id=%d", index));
            ResultSet selectGridResult = selectGridStatement.executeQuery();

            if (selectGridResult.next()) {
                Grid grid = new Grid();
                int id = selectGridResult.getInt("id");
                grid.setId(id);
                grid.getSquares().forEach(square -> {
                    try {
                        PreparedStatement selectExistingSquareStatement = conn.prepareStatement(String.format("SELECT * FROM square AS s LEFT JOIN person AS p ON s.person_id=p.id WHERE grid_id=%d AND row=%d AND col=%d", index, square.getRow(), square.getCol()));
                        ResultSet selectExistingSquareResult = selectExistingSquareStatement.executeQuery();

                        if (selectExistingSquareResult.next()) {
                            Person person = new Person();
                            person.setId(selectExistingSquareResult.getInt("id"));
                            person.setName(selectExistingSquareResult.getString("name"));
                            square.setOwner(person);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
                return grid;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Grid update(int index, Grid grid) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            // We'd have an UPDATE GRID call here if we had any fields to update there
            // Clearing the squares for the grid
            PreparedStatement deleteExistingSquareStatement = conn.prepareStatement(String.format("DELETE FROM square WHERE grid_id=%d", index));
            deleteExistingSquareStatement.executeUpdate();
            grid.getSquares().forEach(square -> {
                if (square.getOwner() != null) {
                    try {
                        PreparedStatement addSquareStatement = conn.prepareStatement(String.format("INSERT INTO square (grid_id, row, col, person_id) VALUES(%d, %d, %d, %d)", index, square.getRow(), square.getCol(), square.getOwner().getId()));
                        addSquareStatement.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(int index) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement deleteGridStatement = conn.prepareStatement(String.format("DELETE FROM grid WHERE id=%d", index));
            deleteGridStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
