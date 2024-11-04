package model.entity;

public class Product {

    private int id;
    private String imagePath;
    private String name;
    private String description;
    private double price;

    public Product(int id, String imagem, String nome, String descricao, double valor) {
        this.id = id;
        this.imagePath = imagem;
        this.name = nome;
        this.description = descricao;
        this.price = valor;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
