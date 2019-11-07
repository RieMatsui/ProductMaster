/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import java.io.FileInputStream;
import java.util.Properties;
import javax.ejb.Singleton;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author matsuirie
 */
@Singleton
public class FileUtil {
    
    private Properties conf;
    
    /**
     * ファイル名を読み込むメソッド
     * @param filename (ファイル名を引数として設定)
     */
    public void loadPropsConfiguration(String filename){
        System.out.println("ファイル名を読み込むメソッド");
        String str_fileName =null;
        //プロパティをインスタンス化する(ストリームに文字列を保管したり、ストリームから読み込んだりすることができる)
            str_fileName =  getRealPath(filename);
        try {
            //ロードしてファイル名を呼び出す
            System.out.println("ファイル名=" + str_fileName);
            conf.load(new  FileInputStream(str_fileName));
           
            
        } catch (Exception e) {
            System.err.println("Cannot open" + filename);
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param key プロパティファイルのKey項目を引数し
     * @return キー項目がプロパティファイルにあれば文字列データを取り出す
     */
    public  String getProperty(String key){
        if (conf.containsKey(key)) {
            return conf.getProperty(key);
        }else{
            System.err.println("[異常終了]登録対象のキーデータ検索結果が存在しません。key = :" + key);
            return "";
        }
    }
    public static String getRealPath(String path) {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        return ctx.getRealPath(path);
    }
    
}
