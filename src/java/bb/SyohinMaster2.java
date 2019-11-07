/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bb;

import java.util.Date;

/**
 *
 * @author WITC_NP02410A
 */
public class SyohinMaster2 extends SyohinMaster{

    public SyohinMaster2(final String syohinCode,
                          final Integer onlineNum,
                          final String shiireCode,
                          final Integer shiireYen, 
                          final Integer yesNo,
                          final Integer monthAvarage,
                          final Integer leadTime, 
                          final Integer orderlot,
                          final String syohinName,
                          final String JANCode, 
                          final String shiireName,
                          final Integer shiireGaika,
                          final Integer irisu, 
                          final String warehouseName,
                          final Integer reorderPoint, 
                          final Integer maxHoldingNum, 
                          final String syohinKana,
                          final Date haibanDate, 
                          final String shiireSyohinCode, 
                          final Integer rackNum, 
                          final Integer qSafetyStock, 
                          final Integer uiOrderLimitNum, 
                          final Integer orderLimitNum, 
                          final Integer unitSellingPrice,
                          final Integer quantityDiscount){
       
        this.setSyohinCode(syohinCode);
        this.setOnlineNum(onlineNum);
        this.setShiireCode(shiireCode);
        this.setShiireYen(shiireYen);
        this.setYesNo(yesNo);
        this.setMaxHoldingNum(maxHoldingNum);
        this.setLeadTime(leadTime);
        this.setOrderLot(orderlot);
        this.setSyohinName(syohinName);
        this.setJANCode(JANCode);
        this.setShiireCode(shiireName);
        this.setShiireGaika(shiireGaika);
        this.setIrisu(irisu);
        this.setWarehouseName(warehouseName);
        this.setReorderPoint(reorderPoint);
        this.setMaxHoldingNum(maxHoldingNum);
        this.setSyohinKana(syohinKana);
        this.setHaibanDate(haibanDate);
        this.setShiireShohinCode(shiireSyohinCode);
        this.setRackNum(rackNum); 
        this.setQSafetyStock(qSafetyStock);
        this.setUiOrderLimitNum(uiOrderLimitNum);
        this.setOrderLimitNum(orderLimitNum);
        this.setUnitSellingPrice(unitSellingPrice);
        this.setQuantityDiscount(quantityDiscount);

    }
    
    
}

