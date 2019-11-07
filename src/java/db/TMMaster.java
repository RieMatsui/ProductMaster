/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matsuirie
 */
@Entity
@Table(name = "t_m_master", catalog = "witc_si_kenshu", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMMaster.findAll", query = "SELECT t FROM TMMaster t")
    , @NamedQuery(name = "TMMaster.findBySyohinCode", query = "SELECT t FROM TMMaster t WHERE t.syohinCode = :syohinCode")
    , @NamedQuery(name = "TMMaster.findByOnlineNum", query = "SELECT t FROM TMMaster t WHERE t.onlineNum = :onlineNum")
    , @NamedQuery(name = "TMMaster.findByShiireCode", query = "SELECT t FROM TMMaster t WHERE t.shiireCode = :shiireCode")
    , @NamedQuery(name = "TMMaster.findByShiireYen", query = "SELECT t FROM TMMaster t WHERE t.shiireYen = :shiireYen")
    , @NamedQuery(name = "TMMaster.findByYesNo", query = "SELECT t FROM TMMaster t WHERE t.yesNo = :yesNo")
    , @NamedQuery(name = "TMMaster.findByMonthAvarage", query = "SELECT t FROM TMMaster t WHERE t.monthAvarage = :monthAvarage")
    , @NamedQuery(name = "TMMaster.findByLeadTime", query = "SELECT t FROM TMMaster t WHERE t.leadTime = :leadTime")
    , @NamedQuery(name = "TMMaster.findByOrderlot", query = "SELECT t FROM TMMaster t WHERE t.orderlot = :orderlot")
    , @NamedQuery(name = "TMMaster.findBySyohinName", query = "SELECT t FROM TMMaster t WHERE t.syohinName = :syohinName")
    , @NamedQuery(name = "TMMaster.findByJANCode", query = "SELECT t FROM TMMaster t WHERE t.jANCode = :jANCode")
    , @NamedQuery(name = "TMMaster.findByShiireName", query = "SELECT t FROM TMMaster t WHERE t.shiireName = :shiireName")
    , @NamedQuery(name = "TMMaster.findByShiireGaika", query = "SELECT t FROM TMMaster t WHERE t.shiireGaika = :shiireGaika")
    , @NamedQuery(name = "TMMaster.findByIrisu", query = "SELECT t FROM TMMaster t WHERE t.irisu = :irisu")
    , @NamedQuery(name = "TMMaster.findByWarehouseName", query = "SELECT t FROM TMMaster t WHERE t.warehouseName = :warehouseName")
    , @NamedQuery(name = "TMMaster.findByReoderPoint", query = "SELECT t FROM TMMaster t WHERE t.reoderPoint = :reoderPoint")
    , @NamedQuery(name = "TMMaster.findByMaxHoldingNum", query = "SELECT t FROM TMMaster t WHERE t.maxHoldingNum = :maxHoldingNum")
    , @NamedQuery(name = "TMMaster.findBySyohinKana", query = "SELECT t FROM TMMaster t WHERE t.syohinKana = :syohinKana")
    , @NamedQuery(name = "TMMaster.findByHaibanDate", query = "SELECT t FROM TMMaster t WHERE t.haibanDate = :haibanDate")
    , @NamedQuery(name = "TMMaster.findByShiireShohinCode", query = "SELECT t FROM TMMaster t WHERE t.shiireShohinCode = :shiireShohinCode")
    , @NamedQuery(name = "TMMaster.findByRackNum", query = "SELECT t FROM TMMaster t WHERE t.rackNum = :rackNum")
    , @NamedQuery(name = "TMMaster.findByQSafetyStock", query = "SELECT t FROM TMMaster t WHERE t.qSafetyStock = :qSafetyStock")
    , @NamedQuery(name = "TMMaster.findByUiOrderLimitNum", query = "SELECT t FROM TMMaster t WHERE t.uiOrderLimitNum = :uiOrderLimitNum")
    , @NamedQuery(name = "TMMaster.findByOrderLimitNum", query = "SELECT t FROM TMMaster t WHERE t.orderLimitNum = :orderLimitNum")
    , @NamedQuery(name = "TMMaster.findByUnitSellingPrice", query = "SELECT t FROM TMMaster t WHERE t.unitSellingPrice = :unitSellingPrice")
    , @NamedQuery(name = "TMMaster.findByQuantityDiscount", query = "SELECT t FROM TMMaster t WHERE t.quantityDiscount = :quantityDiscount")
    , @NamedQuery(name = "TMMaster.findByDiscountRate", query = "SELECT t FROM TMMaster t WHERE t.discountRate = :discountRate")
    , @NamedQuery(name = "TMMaster.findByCreateUser", query = "SELECT t FROM TMMaster t WHERE t.createUser = :createUser")})
public class TMMaster implements Serializable {
    @Column(name = "yesNo")
    private Boolean yesNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rackNum")
    private int rackNum;
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "createUser")
    private String createUser;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "syohinCode")
    private String syohinCode;
    @Column(name = "onlineNum")
    private Integer onlineNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "shiireCode")
    private String shiireCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shiireYen")
    private int shiireYen;
    @Column(name = "monthAvarage")
    private Integer monthAvarage;
    @Column(name = "leadTime")
    private Integer leadTime;
    @Column(name = "orderlot")
    private Integer orderlot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "syohinName")
    private String syohinName;
    @Size(max = 50)
    @Column(name = "JANCode")
    private String jANCode;
    @Size(max = 50)
    @Column(name = "shiireName")
    private String shiireName;
    @Column(name = "shiireGaika")
    private Integer shiireGaika;
    @Column(name = "irisu")
    private Integer irisu;
    @Size(max = 50)
    @Column(name = "warehouseName")
    private String warehouseName;
    @Column(name = "reoderPoint")
    private Integer reoderPoint;
    @Column(name = "maxHoldingNum")
    private Integer maxHoldingNum;
    @Size(max = 50)
    @Column(name = "syohinKana")
    private String syohinKana;
    @Basic(optional = false)
    @Column(name = "haibanDate")
    @Temporal(TemporalType.DATE)
    private Date haibanDate;
    @Size(max = 50)
    @Column(name = "shiireShohinCode")
    private String shiireShohinCode;
    @Column(name = "qSafetyStock")
    private Integer qSafetyStock;
    @Column(name = "uiOrderLimitNum")
    private Integer uiOrderLimitNum;
    @Column(name = "orderLimitNum")
    private Integer orderLimitNum;
    @Column(name = "unitSellingPrice")
    private Integer unitSellingPrice;
    @Column(name = "quantityDiscount")
    private Integer quantityDiscount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "discountRate")
    private Double discountRate;

    public TMMaster() {
    }

    public TMMaster(String syohinCode) {
        this.syohinCode = syohinCode;
    }

    public TMMaster(String syohinCode, 
                   Integer onlineNum,
                    String shiireCode,
                    Integer shiireYen, 
                    boolean yesNo,
                    Integer monthAvarage,
                    Integer leadTime,
                    Integer orderlot,
                    String syohinName,
                    String JANCode,
                    String shiireName,
                    Integer shiireGaika,
                    Integer irisu,
                    String warehouaeName,
                    Integer reoderPoint,
                    Integer maxHoldingNum,
                    String syohinKana,
                    Date haibanDate,
                    String shiireShohinCode,
                    Integer rackNum,
                    Integer qSafetyStock,
                    Integer uiOrderLimtNum,
                    Integer oderLimitNum,
                    Integer unitSellingPrice,
                    Integer quanityDiscount,
                    Double discountRate,
                    String createUser,
                    Date createDate) {
        
        System.out.println("[DEBUG:TMMaster:コンストラクタ]-------- START");
        System.out.println("商品コード=" + syohinCode);
        System.out.println("オンライン=" + onlineNum);
        System.out.println("仕入先コード=" + shiireCode);
        System.out.println("仕入単価(円)=" + shiireYen);
        System.out.println("商品名=" + syohinName);
        System.out.println("棚番=" + rackNum);
        
        this.syohinCode = syohinCode;
        this.onlineNum = onlineNum;
        this.shiireCode = shiireCode;
        this.shiireYen = shiireYen;
        this.yesNo = yesNo;
        this.monthAvarage = monthAvarage;
        this.leadTime = leadTime;
        this.orderlot = orderlot;
        this.syohinName = syohinName;
        this.jANCode = JANCode;
        this.shiireName = shiireName;
        this.shiireGaika = shiireGaika;
        this.irisu = irisu;
        this.warehouseName = warehouaeName;
        this.reoderPoint = reoderPoint;
        this.maxHoldingNum = maxHoldingNum;
        this.syohinKana = syohinKana;
        this.haibanDate = haibanDate;
        this.shiireShohinCode = shiireShohinCode;
        this.rackNum = rackNum;
        this.qSafetyStock = qSafetyStock;
        this.uiOrderLimitNum = uiOrderLimtNum;
        this.orderLimitNum = oderLimitNum;
        this.unitSellingPrice = unitSellingPrice;
        this.quantityDiscount = quanityDiscount;
        this.discountRate = discountRate;
        this.createUser = createUser;
        this.createDate = createDate;
       
        System.out.println("[DEBUG:TMMaster:コンストラクタ]-------- END");
    }

    public String getSyohinCode() {
        return syohinCode;
    }

    public void setSyohinCode(String syohinCode) {
        this.syohinCode = syohinCode;
    }

    public Integer getOnlineNum() {
        return onlineNum;
    }

    public void setOnlineNum(Integer onlineNum) {
        this.onlineNum = onlineNum;
    }

    public String getShiireCode() {
        return shiireCode;
    }

    public void setShiireCode(String shiireCode) {
        this.shiireCode = shiireCode;
    }

    public int getShiireYen() {
        return shiireYen;
    }

    public void setShiireYen(int shiireYen) {
        this.shiireYen = shiireYen;
    }


    public Integer getMonthAvarage() {
        return monthAvarage;
    }

    public void setMonthAvarage(Integer monthAvarage) {
        this.monthAvarage = monthAvarage;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Integer getOrderlot() {
        return orderlot;
    }

    public void setOrderlot(Integer orderlot) {
        this.orderlot = orderlot;
    }

    public String getSyohinName() {
        return syohinName;
    }

    public void setSyohinName(String syohinName) {
        this.syohinName = syohinName;
    }

    public String getJANCode() {
        return jANCode;
    }

    public void setJANCode(String jANCode) {
        this.jANCode = jANCode;
    }

    public String getShiireName() {
        return shiireName;
    }

    public void setShiireName(String shiireName) {
        this.shiireName = shiireName;
    }

    public Integer getShiireGaika() {
        return shiireGaika;
    }

    public void setShiireGaika(Integer shiireGaika) {
        this.shiireGaika = shiireGaika;
    }

    public Integer getIrisu() {
        return irisu;
    }

    public void setIrisu(Integer irisu) {
        this.irisu = irisu;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getReoderPoint() {
        return reoderPoint;
    }

    public void setReoderPoint(Integer reoderPoint) {
        this.reoderPoint = reoderPoint;
    }

    public Integer getMaxHoldingNum() {
        return maxHoldingNum;
    }

    public void setMaxHoldingNum(Integer maxHoldingNum) {
        this.maxHoldingNum = maxHoldingNum;
    }

    public String getSyohinKana() {
        return syohinKana;
    }

    public void setSyohinKana(String syohinKana) {
        this.syohinKana = syohinKana;
    }

    public Date getHaibanDate() {
        return haibanDate;
    }

    public void setHaibanDate(Date haibanDate) {
        this.haibanDate = haibanDate;
    }

    public String getShiireShohinCode() {
        return shiireShohinCode;
    }

    public void setShiireShohinCode(String shiireShohinCode) {
        this.shiireShohinCode = shiireShohinCode;
    }


    public Integer getQSafetyStock() {
        return qSafetyStock;
    }

    public void setQSafetyStock(Integer qSafetyStock) {
        this.qSafetyStock = qSafetyStock;
    }

    public Integer getUiOrderLimitNum() {
        return uiOrderLimitNum;
    }

    public void setUiOrderLimitNum(Integer uiOrderLimitNum) {
        this.uiOrderLimitNum = uiOrderLimitNum;
    }

    public Integer getOrderLimitNum() {
        return orderLimitNum;
    }

    public void setOrderLimitNum(Integer orderLimitNum) {
        this.orderLimitNum = orderLimitNum;
    }

    public Integer getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(Integer unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public Integer getQuantityRate() {
        return quantityDiscount;
    }

    public void setQuantityDiscount(Integer quantityDiscount) {
        this.quantityDiscount = quantityDiscount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (syohinCode != null ? syohinCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMMaster)) {
            return false;
        }
        TMMaster other = (TMMaster) object;
        if ((this.syohinCode == null && other.syohinCode != null) || (this.syohinCode != null && !this.syohinCode.equals(other.syohinCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.TMMaster[ syohinCode=" + syohinCode + " ]";
    }

    public Boolean getYesNo() {
        return yesNo;
    }

    public void setYesNo(Boolean yesNo) {
        this.yesNo = yesNo;
    }

    public int getRackNum() {
        return rackNum;
    }

    public void setRackNum(int rackNum) {
        this.rackNum = rackNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    
}
