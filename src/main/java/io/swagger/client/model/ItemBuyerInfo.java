/*
 * Selling Partner API for Orders
 * The Selling Partner API for Orders helps you programmatically retrieve order information. These APIs let you develop fast, flexible, custom applications in areas like order synchronization, order research, and demand-based decision support tools.
 *
 * OpenAPI spec version: v0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.BuyerCustomizedInfoDetail;
import io.swagger.client.model.Money;
import java.io.IOException;

/**
 * A single item&#39;s buyer information.
 */
@ApiModel(description = "A single item's buyer information.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-02-16T11:36:58.944+05:00")
public class ItemBuyerInfo {
  @SerializedName("BuyerCustomizedInfo")
  private BuyerCustomizedInfoDetail buyerCustomizedInfo = null;

  @SerializedName("GiftWrapPrice")
  private Money giftWrapPrice = null;

  @SerializedName("GiftWrapTax")
  private Money giftWrapTax = null;

  @SerializedName("GiftMessageText")
  private String giftMessageText = null;

  @SerializedName("GiftWrapLevel")
  private String giftWrapLevel = null;

  public ItemBuyerInfo buyerCustomizedInfo(BuyerCustomizedInfoDetail buyerCustomizedInfo) {
    this.buyerCustomizedInfo = buyerCustomizedInfo;
    return this;
  }

   /**
   * Buyer information for custom orders from the Amazon Custom program.
   * @return buyerCustomizedInfo
  **/
  @ApiModelProperty(value = "Buyer information for custom orders from the Amazon Custom program.")
  public BuyerCustomizedInfoDetail getBuyerCustomizedInfo() {
    return buyerCustomizedInfo;
  }

  public void setBuyerCustomizedInfo(BuyerCustomizedInfoDetail buyerCustomizedInfo) {
    this.buyerCustomizedInfo = buyerCustomizedInfo;
  }

  public ItemBuyerInfo giftWrapPrice(Money giftWrapPrice) {
    this.giftWrapPrice = giftWrapPrice;
    return this;
  }

   /**
   * The gift wrap price of the item.
   * @return giftWrapPrice
  **/
  @ApiModelProperty(value = "The gift wrap price of the item.")
  public Money getGiftWrapPrice() {
    return giftWrapPrice;
  }

  public void setGiftWrapPrice(Money giftWrapPrice) {
    this.giftWrapPrice = giftWrapPrice;
  }

  public ItemBuyerInfo giftWrapTax(Money giftWrapTax) {
    this.giftWrapTax = giftWrapTax;
    return this;
  }

   /**
   * The tax on the gift wrap price.
   * @return giftWrapTax
  **/
  @ApiModelProperty(value = "The tax on the gift wrap price.")
  public Money getGiftWrapTax() {
    return giftWrapTax;
  }

  public void setGiftWrapTax(Money giftWrapTax) {
    this.giftWrapTax = giftWrapTax;
  }

  public ItemBuyerInfo giftMessageText(String giftMessageText) {
    this.giftMessageText = giftMessageText;
    return this;
  }

   /**
   * A gift message provided by the buyer.
   * @return giftMessageText
  **/
  @ApiModelProperty(value = "A gift message provided by the buyer.")
  public String getGiftMessageText() {
    return giftMessageText;
  }

  public void setGiftMessageText(String giftMessageText) {
    this.giftMessageText = giftMessageText;
  }

  public ItemBuyerInfo giftWrapLevel(String giftWrapLevel) {
    this.giftWrapLevel = giftWrapLevel;
    return this;
  }

   /**
   * The gift wrap level specified by the buyer.
   * @return giftWrapLevel
  **/
  @ApiModelProperty(value = "The gift wrap level specified by the buyer.")
  public String getGiftWrapLevel() {
    return giftWrapLevel;
  }

  public void setGiftWrapLevel(String giftWrapLevel) {
    this.giftWrapLevel = giftWrapLevel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemBuyerInfo itemBuyerInfo = (ItemBuyerInfo) o;
    return Objects.equals(this.buyerCustomizedInfo, itemBuyerInfo.buyerCustomizedInfo) &&
        Objects.equals(this.giftWrapPrice, itemBuyerInfo.giftWrapPrice) &&
        Objects.equals(this.giftWrapTax, itemBuyerInfo.giftWrapTax) &&
        Objects.equals(this.giftMessageText, itemBuyerInfo.giftMessageText) &&
        Objects.equals(this.giftWrapLevel, itemBuyerInfo.giftWrapLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buyerCustomizedInfo, giftWrapPrice, giftWrapTax, giftMessageText, giftWrapLevel);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemBuyerInfo {\n");
    
    sb.append("    buyerCustomizedInfo: ").append(toIndentedString(buyerCustomizedInfo)).append("\n");
    sb.append("    giftWrapPrice: ").append(toIndentedString(giftWrapPrice)).append("\n");
    sb.append("    giftWrapTax: ").append(toIndentedString(giftWrapTax)).append("\n");
    sb.append("    giftMessageText: ").append(toIndentedString(giftMessageText)).append("\n");
    sb.append("    giftWrapLevel: ").append(toIndentedString(giftWrapLevel)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

