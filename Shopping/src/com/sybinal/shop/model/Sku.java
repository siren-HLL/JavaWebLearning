package com.sybinal.shop.model;

public class Sku {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.id
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.product_id
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.quantity
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.price
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    private Integer price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.option_value_key_group
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    private String optionValueKeyGroup;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sku.sku_json
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    private String skuJson;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.id
     *
     * @return the value of sku.id
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.id
     *
     * @param id the value for sku.id
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.product_id
     *
     * @return the value of sku.product_id
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.product_id
     *
     * @param productId the value for sku.product_id
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.quantity
     *
     * @return the value of sku.quantity
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.quantity
     *
     * @param quantity the value for sku.quantity
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.price
     *
     * @return the value of sku.price
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.price
     *
     * @param price the value for sku.price
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.option_value_key_group
     *
     * @return the value of sku.option_value_key_group
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public String getOptionValueKeyGroup() {
        return optionValueKeyGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.option_value_key_group
     *
     * @param optionValueKeyGroup the value for sku.option_value_key_group
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public void setOptionValueKeyGroup(String optionValueKeyGroup) {
        this.optionValueKeyGroup = optionValueKeyGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sku.sku_json
     *
     * @return the value of sku.sku_json
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public String getSkuJson() {
        return skuJson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sku.sku_json
     *
     * @param skuJson the value for sku.sku_json
     *
     * @mbg.generated Wed Oct 26 10:17:30 CST 2016
     */
    public void setSkuJson(String skuJson) {
        this.skuJson = skuJson;
    }
}