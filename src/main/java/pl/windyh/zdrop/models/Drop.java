package pl.windyh.zdrop.models;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Drop {

    private Material source;
    private Material drop;
    private int quantity;
    private int minY;
    private int maxY;
    private String message;
    private double chance;
    private String tools;

    public Drop(Material source, Material drop, int quantity, double chance) {
        this.source = source;
        this.drop = drop;
        this.quantity = quantity;
        this.chance = chance;
    }

    public Material getSource() {
        return source;
    }

    public void setSource(Material source) {
        this.source = source;
    }

    public Material getDrop() {
        return drop;
    }

    public void setDrop(Material drop) {
        this.drop = drop;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }
}
