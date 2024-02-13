package br.tec.codewaves.stock3d.model;

public class ProductFeatures {

    private int id_feature;
    private String material;
    private String type_material;
    private String manufacturer;
    private double diameter;
    private double ret_distance;
    private double ret_speed;
    private String extrude_temp_range;
    private String bed_temp_range;

    public ProductFeatures(){
    }

    public ProductFeatures(int id_feature, String material, String type_material,
                           String manufacturer, double diameter,
                           double ret_distance, double ret_speed,
                           String extrude_temp_range, String bed_temp_range) {
        this.id_feature = id_feature;
        this.material = material;
        this.type_material = type_material;
        this.manufacturer = manufacturer;
        this.diameter = diameter;
        this.ret_distance = ret_distance;
        this.ret_speed = ret_speed;
        this.extrude_temp_range = extrude_temp_range;
        this.bed_temp_range = bed_temp_range;
    }

    public int getId_feature() {
        return id_feature;
    }

    public void setId_feature(int id_feature) {
        this.id_feature = id_feature;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType_material() {
        return type_material;
    }

    public void setType_material(String type_material) {
        this.type_material = type_material;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getRet_distance() {
        return ret_distance;
    }

    public void setRet_distance(double ret_distance) {
        this.ret_distance = ret_distance;
    }

    public double getRet_speed() {
        return ret_speed;
    }

    public void setRet_speed(double ret_speed) {
        this.ret_speed = ret_speed;
    }

    public String getExtrude_temp_range() {
        return extrude_temp_range;
    }

    public void setExtrude_temp_range(String extrude_temp_range) {
        this.extrude_temp_range = extrude_temp_range;
    }

    public String getBed_temp_range() {
        return bed_temp_range;
    }

    public void setBed_temp_range(String bed_temp_range) {
        this.bed_temp_range = bed_temp_range;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id_feature=" + id_feature +
                ", material='" + material + '\'' +
                ", type_material='" + type_material + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", diameter=" + diameter +
                ", ret_distance=" + ret_distance +
                ", ret_speed=" + ret_speed +
                ", extrude_temp_range='" + extrude_temp_range + '\'' +
                ", bed_temp_range='" + bed_temp_range + '\'' +
                '}';
    }
}
