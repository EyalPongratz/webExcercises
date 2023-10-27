package com.example.webDemo2.models;

public class CryptoCurrency {
    private String id;
    private String name;
    private double price;
    private long marketCap;

    public CryptoCurrency(String id, String name, double price, long marketCap) {
        this.setId(id);
        this.name = name;
        this.price = price;
        this.marketCap = marketCap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() > 4)
            this.id = id.substring(0,4);
        else
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(long marketCap) {
        this.marketCap = marketCap;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        CryptoCurrency other = (CryptoCurrency) o;
        return this.id.equals(other.getId()) && this.name.equals(other.getName()) &&
                this.price == other.getPrice() && this.marketCap == other.getMarketCap();
    }
}
