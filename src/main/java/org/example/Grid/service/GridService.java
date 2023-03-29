package org.example.Grid.service;

import org.example.Grid.entity.Grid;

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
        return grids;
    }

    public Grid get(int index) {
        return grids.get(index);
    }

    public Grid update(int index, Grid grid) {
        Grid res = get(index);
        res.setSquares(grid.getSquares());
        return res;
    }

    public void delete(int index) {
        grids.remove(index);
    }
}
