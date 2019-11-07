package ejb;

import java.util.Date;
import javax.ejb.Stateless;
import db.TMMaster;
import javax.ejb.EJB;


/**
 *
 * @author WITC_NP02410A
 * 
 * バッキングビーンでもらってきた値を相関チェックするためのメソッド
 * 
 * 
 */
@Stateless
public class SampleSessionBean {

@EJB
TMMasterFacade facade;

@EJB
Db db;
/**
 * デフォルトコンストラクタは記載すること
 */
public SampleSessionBean(){
    System.out.println("[DEBUG:SampleSessionBean] START -------- コンストラクタ");
    System.out.println("[DEBUG:SampleSessionBean] END   -------- コンストラクタ");
}
//接続確認のメソッド
public  SampleSessionBean(final String _param01){
    
    System.out.println("[DEBUG:SampleSessinBean] START -------- overload コンストラクタ");
    System.out.println("[DEBUG:SampleSessionBean] _param01 =" + _param01);
    System.out.println("[DEBUG:SampleSessionBean] END -------- overload コンストラクタ");
    
}

//在庫の値を取得しboolean型で返すメソッド
public boolean getZaiko(final Integer _paramYesNo){
   if(_paramYesNo == 1){
      return false;
   }
   else{
       return true;
   }
           
}

public void toConsole(){
    
    System.out.println("[DEBUG:SampleSessionBean] START -------- toConsole");
    System.out.println("[DEBUG:SampleSessionBean] END   -------- toConsole");

}


public void test(final String _prmSyohinCode,
                 final Integer _prmOnlineNum,
                 final String _prmShiireCode,
                 final Integer _prmShiireYen,
                 final Integer _prmShireYesNo,
                 final Integer _prmMonthAvaragre,
                 final Integer _prmLeadtime,
                 final Integer _prmOrderLot,
                 final String _prmSyohinName,
                 final String _prmJanCode,
                 final String _prmShiireName,
                 final Integer _prmShiireGaika,
                 final Integer _prmIrisu,
                 final Integer _prmWarehouseName,
                 final String _prmReoderPoint,
                 final Integer _prmMaxHoldingNumInteger,
                 final Integer _prmSyohinKana,
                 final Date _prmHaibanDate,
                 final String _prmShiireSyohinCode,
                 final Integer _prmRackNum,
                 final Integer _prmQSafetyStock,
                 final Integer _prmUiOrderLimitNum,
                 final Integer _prmOderLimitNum,
                 final Integer _prmUnitSellingPrice,
                 final Integer _prmQuantitiyDiscount,
                 final Integer _prmEditable){
    
    
    System.out.println("値を取得するクラス");
//    System.out.println(_prmShiireCode);
  
    
}

//ファサードパターンで値を登録する(未完成)
public void createDataTMMaster(TMMaster entity){
    
 System.out.println("DEBUG[SampleSessionBean:]createDataTMMaster ---- START");
 
    try {
        
        System.out.println("DEBUG[SampleSessionBean:]商品コード" + entity.getSyohinCode());
        System.out.println("DEBUG[SampleSessionBean:]仕入れコード" + entity.getShiireCode());
        System.out.println("DEBUG[SampleSessionBean:]仕入単価(円)" + entity.getShiireYen());
        System.out.println("DEBUG[SampleSessionBean:]商品名" + entity.getSyohinName());
        System.out.println("DEBUG[SampleSessionBean:]棚番" + entity.getRackNum());
        
        
        facade.create(entity);
        
    } catch (Exception e) {
        
        e.printStackTrace();
    }
    
 System.out.println("DEBUG[SampleSessionBean:]createDataTMMaster ---- END");
}


}
