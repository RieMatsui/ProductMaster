
package bb;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.EJB;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


import db.TMMaster;
import ejb.Db;
import ejb.SampleSessionBean;
import ejb.TMMasterFacade;
import ejb.FileUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.swing.JOptionPane;
import org.jboss.logging.NDC;



/**
 *
 * @author WITC_NP02410A
 */
@Named
@ViewScoped
public class SyohinMaster implements Serializable{
    //『商品コード』
    private String syohinCode ;
    //『オンライン品番』
    private Integer onlineNum;
    //『仕入先コード』
    private String shiireCode;
    //『仕入単価(円)』

    private Integer shiireYen;
    //『在庫管理』
    private Integer yesNo ;
    //『月平均出荷数』
    private Integer monthAvarage;
    //『リードタイム』発注から納品までに要する時間
    private Integer leadTime;
    //『発注ロット』一回の発注のロット数の上限
    private Integer orderlot;
    //『商品名』
    private String syohinName;
    //『JANコード』
    private String JANCode;
    //『仕入先名』
    private String shiireName;
    //『仕入単価(単価)』
    private Integer shiireGaika;
    //『入数』
    private Integer irisu;
    //『倉庫名』
    private String warehouseName;
    //『発注点』発注点とは、その数量を切れば発注すると予め決めた在庫水準のことである。
    //発注してから納品までの日数の間に、商品が売れていくことを考えているのが、発注点であり、【安全在庫数量】＋【調達リードタイム】×【１日販売数量】という計算式
    private Integer reoderPonit;
    //『最大保有数』
    private Integer maxHoldingNum;
    //『商品名』
    private String syohinKana;
    //廃版予定日
    @Temporal(TemporalType.DATE)
    private Date haibanDate;
    //『仕入商品コード』
    private String shiireSyohinCode;
    //『棚番』
    private Integer rackNum;
    //『安全在庫数』
    private Integer qSafetyStock;
    //『単位発注限度数』
    private Integer uiOrderLimitNum;
    //『受注限度数』
    private Integer orderLimitNum;
    //『売単価』
    private Integer unitSellingPrice;
    //『数量割引』
    private Integer quantityDiscount;
    //『数量割引率』
    private Double discountRate;
    //『在庫管理』データベース登録用のbooleanでの変換
    private boolean zaikokanri;
    //仕入先名の編集の可否
    private boolean editable = true;
    
    //データ操作の際のメッセージ
    private String msg;
    
   
    //在庫管理の可否のプルダウン
    private static Map<String,Integer> items;
    static {
        items = new  LinkedHashMap<>();
        items.put("しない ", 1);
        items.put("する", 2);
    }
    
    //プルダウンの選択したアイテムの取得
    public Map<String,Integer>getItems(){
        return items;
    }
    
    //ビジネスロジックでのデータベース登録
    @EJB
    SampleSessionBean ejbBusinessLgc;
    
    //ファーサードパターンでのデータベース登録クラス宣言
    @EJB
    TMMasterFacade facade;
    
    //教科書のデータベース登録方法のクラス宣言
    @EJB
    Db db;
    
    @EJB
    FileUtil fileUtil;
    
    //ajaxで非同期的に項目が変更されたときに真偽値に変換しサーバーデータを送信する
    public void checkZaiko(){
        zaikokanri = ejbBusinessLgc.getZaiko(yesNo);
        System.out.println("zaikokanri" + zaikokanri);
    }
    
  //初期化処理
  public void refresh() {
      
    FacesContext context = FacesContext.getCurrentInstance();
    Application application = context.getApplication();
    ViewHandler viewHandler = application.getViewHandler();
    UIViewRoot viewRoot = viewHandler.createView(context, context
     .getViewRoot().getViewId());
    context.setViewRoot(viewRoot);
    context.renderResponse(); 

  }

  
  //ファイルを読み込むためのメソッド
  public void readProperty(){
//      System.out.println("ファイルを読み込むためのメソッド");
//      fileUtil.loadPropsConfiguration("/resourse/data/shiirename.properties");
//      shiireName = fileUtil.getProperty(shiireCode);
      
      //入力されたとき編集可能にする
      if (shiireCode != null) {
          editable = false;
      }
      else{
          editable = true;
  
      }
      System.out.println(shiireCode);
      System.out.println(editable);
  }
  
      //コンソールに表示
      public void toConsole(){
        System.out.println("コンソール呼び出しメソッド");
        System.out.println("DEBUG[syohinMaster toConsole()] 開始");  
        System.out.println("商品コード" + syohinCode);
        System.out.println("オンライン品番" + onlineNum);
        System.out.println("仕入先コード" + shiireCode);
        System.out.println("仕入単価(円)" + shiireYen);
        System.out.println("在庫管理" + yesNo);
        System.out.println("月平均出荷数" + monthAvarage);
        System.out.println("リードタイム" + leadTime);
        System.out.println("発注ロット" + orderlot);
        System.out.println("商品名" + syohinName );
        System.out.println("JANコード" + JANCode);
        System.out.println("仕入単価" + shiireGaika);
        System.out.println("入数" + irisu);
        System.out.println("倉庫名" + warehouseName);
        System.out.println("発注点" + reoderPonit);
        System.out.println("最大保有数" + maxHoldingNum);
        System.out.println("商品名カナ" + syohinKana);
        System.out.println("廃盤予定日" + haibanDate);
        System.out.println("仕入商品コード" + shiireSyohinCode);
        System.out.println("棚番" + rackNum);
        System.out.println("安全在庫数" + qSafetyStock);
        System.out.println("単位発注在庫数" + uiOrderLimitNum);
        System.out.println("受注限度数" + orderLimitNum);
        System.out.println("売単価" + unitSellingPrice);
        System.out.println("数量割引" + quantityDiscount); 
        System.out.println("数量割引率" + discountRate);
        System.out.println("DEBUG[syohinMaster toConsole()] 終了");  
    }
//    public String next(){
//        return "output.xhtml";
//    }
       

    //登録ボタンを押下したとき
    public void next(){
        
        System.out.println("[DEBUG:Syohinmaster]START ------ next");
        System.out.println("商品コード =" + syohinCode);
        System.out.println("オンライン品番=" + onlineNum);
        System.out.println("仕入先コード=" + shiireCode);
        System.out.println("仕入単価(円)=" + shiireYen);
        System.out.println("在庫管理=" + ejbBusinessLgc.getZaiko(yesNo));
        System.out.println("月平均出荷数=" + monthAvarage);
        System.out.println("リードタイム=" + leadTime);
        System.out.println("発注ロット=" + orderlot);
        System.out.println("商品名=" + syohinName );
        System.out.println("JANコード=" + JANCode);
        System.out.println("仕入先名=" + shiireName);
        System.out.println("仕入単価=" + shiireGaika);
        System.out.println("入数=" + irisu);
        System.out.println("倉庫名=" + warehouseName);
        System.out.println("発注点=" + reoderPonit);
        System.out.println("最大保有数=" + maxHoldingNum);
        System.out.println("商品名カナ=" + syohinKana);
        System.out.println("廃盤予定日=" + haibanDate);
        System.out.println("仕入商品コード=" + shiireSyohinCode);
        System.out.println("棚番=" + rackNum);
        System.out.println("安全在庫数=" + qSafetyStock);
        System.out.println("単位発注在庫数=" + uiOrderLimitNum);
        System.out.println("受注限度数=" + orderLimitNum);
        System.out.println("売単価=" + unitSellingPrice);
        System.out.println("数量割引=" + quantityDiscount); 
        System.out.println("数量割引率=" + discountRate);
        //アノテーションによってNew宣言は割愛
        ejbBusinessLgc.toConsole();
        
        //コンストラクタの呼び出しはNew宣言する
        ejbBusinessLgc = new SampleSessionBean(syohinCode);
        
        
        //データベースの登録
        TMMaster tMMaster = new TMMaster(syohinCode, onlineNum,shiireCode,shiireYen,zaikokanri,
                                monthAvarage,leadTime,orderlot,syohinName,JANCode,shiireName,
                                shiireGaika,irisu,warehouseName,reoderPonit,maxHoldingNum,
                                syohinKana,haibanDate,shiireSyohinCode,rackNum,qSafetyStock,
                                uiOrderLimitNum,orderLimitNum,unitSellingPrice,quantityDiscount,
                                discountRate,"松井",new  Timestamp(System.currentTimeMillis()) );
        
        try {
            db.create(tMMaster);
            msg = "登録が完了しました★";
        } catch (Exception e) {
            e.printStackTrace();  
            msg = "エラーが発生しました";
        }          
        
        System.out.println("[DEBUG:SyohinMaster]END ------ next");
        
    }
    
    //リスト化して全てのテーブル項目を取得する
    public List<TMMaster> getAll(){
       return db.getALL();
    }
    
    //編集する項目をセットする
    public String edit(TMMaster tMMaster){
        
        syohinCode = tMMaster.getSyohinCode();
        shiireCode = tMMaster.getShiireCode();
        shiireYen = tMMaster.getShiireYen();
        syohinName = tMMaster.getSyohinName();
        rackNum = tMMaster.getRackNum();
        
        msg = "商品コード:"+ shiireCode + "のデータを表示しました";            
       return msg;
    }
    
    //データベースを更新するメソッド
    public String update(){
        
        TMMaster tMMaster = new TMMaster(syohinCode, onlineNum,shiireCode,shiireYen,zaikokanri,
                                monthAvarage,leadTime,orderlot,syohinName,JANCode,shiireName,
                                shiireGaika,irisu,warehouseName,reoderPonit,maxHoldingNum,
                                syohinKana,haibanDate,shiireSyohinCode,rackNum,qSafetyStock,
                                uiOrderLimitNum,orderLimitNum,unitSellingPrice,quantityDiscount,
                                discountRate,"松井",new  Timestamp(System.currentTimeMillis()) );
        
        try {
            db.update(tMMaster);
            
        } catch (Exception e) {
            e.printStackTrace();
            msg = "エラーが発生しました。データの更新ができませんでした";
            return msg;
        }
        
        msg = "登録が完了しました";
        return msg;
    }
    
    //テーブル項目を主キーから検索する
    public String find(){
        
        //Entityクラスからデータを取り出す
        TMMaster tMMaster = db.find(syohinCode);
        if (tMMaster != null) {
            this.syohinCode = tMMaster.getSyohinCode();
            this.shiireCode = tMMaster.getShiireCode();
            this.shiireYen = tMMaster.getShiireYen();
            this.syohinName = tMMaster.getSyohinName();
            this.rackNum = tMMaster.getRackNum();
            msg = shiireCode + "の検索結果を表示しました。";
        }else{
            msg = shiireCode + "の検索結果はありませんでした。";
        }
        return msg;
    }
    
    //削除するメソッド
    public String delete(){
        TMMaster tMMaster = new TMMaster(syohinCode, onlineNum,shiireCode,shiireYen,zaikokanri,
                                monthAvarage,leadTime,orderlot,syohinName,JANCode,shiireName,
                                shiireGaika,irisu,warehouseName,reoderPonit,maxHoldingNum,
                                syohinKana,haibanDate,shiireSyohinCode,rackNum,qSafetyStock,
                                uiOrderLimitNum,orderLimitNum,unitSellingPrice,quantityDiscount,
                                discountRate,"松井",new  Timestamp(System.currentTimeMillis()) );
        db.delete(tMMaster);
        msg = "該当のデータを削除しました。";
        return msg;
    }
    
    
    /**　アクセサーメソッド
     * 
     * @return 商品コード
     */
    public String getSyohinCode(){          
        return syohinCode;
    }
    /**
     * 
     * @param syohinCode 
     * 
     */
    public  void setSyohinCode(String syohinCode){
        this.syohinCode  = syohinCode; 
    }
    /**
     * 
     * @return オンライン品番
     * 
     */   
    public  Integer getOnlineNum(){
        return onlineNum;
    }
    /**
     * 
     * @param onlieNum 
     */
    public void setOnlineNum(Integer onlieNum){
        this.onlineNum = onlieNum;
    }
    /**
     * 
     * @return 仕入先コード
     * 
     */
    public String getShiireCode(){
        return shiireCode;
    }
    /**
     * 
     * @param shiireCode 
     */
    public void setShiireCode(String shiireCode){
        this.shiireCode = shiireCode;
        
    }
    /**
     * 
     * @return 仕入単価(円)
     * 
     */
    public Integer getShiireYen(){
        return  shiireYen;
    }
    /**
     * 
     * @param shiireYen 
     */
    public void setShiireYen(Integer shiireYen){
        this.shiireYen = shiireYen;
    }
    /**
     * 
     * @return 在庫管理
     */
    public  Integer getYesNo(){
        return yesNo;
    }
    /**
     * 
     * @param yesNo 
     */
    public void setYesNo(Integer yesNo){
        this.yesNo = yesNo;
    }
    /**
     * 
     * @return 
     */
    public Integer getMonthAvarage(){
        return monthAvarage;
    }
    /**
     * 
     * @param monthAvarage 
     */
    public void setMonthAvarage(Integer monthAvarage){
        this.monthAvarage = monthAvarage;
    }
    /**
     * 
     * @return 
     */
    public Integer getLeadTime(){
        return leadTime;
    }
    /**
     * 
     * @param leadTime 
     */
    public void setLeadTime(Integer leadTime){
        this.leadTime = leadTime;
    }
    /**
     * 
     * @return 
     */
    public Integer getOrderLot(){
        return orderlot;
    }
    /**
     * 
     * @param orderLot 
     */
    public void setOrderLot(Integer orderLot){
        this.orderlot = orderLot;
    }
    /**
     * 
     * @return 
     */
    public String getSyohinName(){
        return syohinName;
    }
    /**
     * 
     * @param syohinName 
     */
    public void setSyohinName(String syohinName){
        this.syohinName = syohinName;
    }
    /**
     * 
     * @return 
     */
    public String getJANCode(){
        return JANCode;
    }
    /**
     * 
     * @param JANCode 
     */
    public void setJANCode(String JANCode){
        this.JANCode = JANCode;
    }
    /**
     * 
     * @return 
     */
    public String getShiireName(){
        return shiireName;
    }
    /**
     * 
     * @param shiireName 
     */
    public void setShiireName(String shiireName){
        this.shiireName = shiireName;
    }
    /**
     * 
     * @return 
     */
    public Integer getShiireGaika(){
        return shiireGaika;
    }
    /**
     * 
     * @param shiireGaika 
     */
    public void setShiireGaika(Integer shiireGaika){
        this.shiireGaika = shiireGaika;
    }
    /**
     * 
     * @return 
     */
    public  Integer getIrisu(){
            return irisu;
    }
    /**
     * 
     * @param irisu 
     */
    public void setIrisu(Integer irisu){
        this.irisu = irisu;
    }
    /**
     * 
     * @return 
     */
    public String getWarehouseName(){
        return warehouseName;
    }
    /**
     * 
     * @param warehouseName 
     */
    public void setWarehouseName(String warehouseName){
        this.warehouseName = warehouseName;
    }
    /**
     * 
     * @return 
     */
    public  Integer getReorderPoint(){
        return reoderPonit;
    }
    /**
     * 
     * @param reorderPoint 
     */
    public void setReorderPoint(Integer reorderPoint){
        this.reoderPonit = reorderPoint;
    }
    /**
     * 
     * @return 
     */
    public Integer getMaxHoldingNum(){
        return maxHoldingNum;
    }
    /**
     * 
     * @param maxHoldingNum 
     */
    public void setMaxHoldingNum(Integer maxHoldingNum){
        this.maxHoldingNum = maxHoldingNum;
    }
    /**
     * 
     * @return 
     */
    public String getSyohinKana(){
        return syohinKana;
    }
    /**
     * 
     * @param syohinKana 
     */
    public void setSyohinKana(String syohinKana){
        this.syohinKana = syohinKana;
    }
    /**
     * 
     * @return 
     */
    public Date getHaibanDate(){
        return haibanDate;
    }
    /**
     * 
     * @param haibanDate 
     */
    public void setHaibanDate(Date haibanDate){
        this.haibanDate = haibanDate;
    }
    /**
     * 
     * @return 
     */
    public String getShiireShohinCode(){
        return shiireSyohinCode;
    }
    /**
     * 
     * @param shiireSyohinCode 
     */
    public void setShiireShohinCode(String shiireSyohinCode){
        this.shiireSyohinCode = shiireSyohinCode;
    }
    /**
     * 
     * @return 
     */
    public Integer getRackNum(){
        return  rackNum;
    }
    /**
     * 
     * @param rackNum 
     */
    public void setRackNum(Integer rackNum){
        this.rackNum = rackNum;
    }
    /**
     * 
     * @return 
     */
    public Integer getQSafetyStock(){
        return qSafetyStock;
    }
    /**
     * 
     * @param qSafetyStock 
     */
    public void setQSafetyStock(Integer qSafetyStock){
        this.qSafetyStock = qSafetyStock;
    }
    /**
     * 
     * @return 
     */
    public Integer getUiOrderLimitNum(){
        return uiOrderLimitNum;
    }
    /**
     * 
     * @param uiOrderLimitNum 
     */
    public void setUiOrderLimitNum(Integer uiOrderLimitNum){
        this.uiOrderLimitNum = uiOrderLimitNum;
    }
    /**
     * 
     * @return 
     */
    public Integer getOrderLimitNum(){
        return orderLimitNum;
    }
    /**
     * 
     * @param orderLimitNum 
     */
    public void setOrderLimitNum(Integer orderLimitNum){
        this.orderLimitNum = orderLimitNum;
    }
    /**
     * 
     * @return 
     */
    public Integer getUnitSellingPrice(){
        return  unitSellingPrice;
    }
    /**
     * 
     * @param unitSellingPrice 
     */
    public void setUnitSellingPrice(Integer unitSellingPrice){
        this.unitSellingPrice = unitSellingPrice;
    }
    /**
     * 
     * @return 
     */
    public Integer getQuantityDiscount(){
        return  quantityDiscount;
    }
    /**
     * 
     * @param quantityDiscocunt 
     */
    public void setQuantityDiscount(Integer quantityDiscocunt){
        this.quantityDiscount = quantityDiscocunt;
    }
    /**
     * 
     * @return 
     */
    public Double getDiscountRate() {
        return discountRate;
    }
    /**
     * 
     * @param discountRate 
     */
    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }
    /**
     * 
     * @return 
     */
    public boolean isZaikokanri() {
        return zaikokanri;
    }
    /**
     * 
     * @param zaikokanri 
     */
    public void setZaikokanri(boolean zaikokanri) {
        this.zaikokanri = zaikokanri;
    }
    /**
     * 
     * @return 
     */
    public boolean isEditable() {
        return editable;
    }
    /**
     * 
     * @param editable 
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    /**
     * 
     * @return 
     */
    public String getMsg() {
        return msg;
    }
    /**
     * 
     * @param msg 
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    

      
}
