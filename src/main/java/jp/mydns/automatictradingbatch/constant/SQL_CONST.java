package jp.mydns.automatictradingbatch.constant;

/**
 * 接頭辞　U:UPDATE,R:READ,D:DELETE
 * 接頭辞ごとに3桁の連番を付与する
 */
public class SQL_CONST {
    //Mx全データ取得用
    public static final String R001 = "SELECT  f.fk_id fk_id, f.date f_date, f.time f_time, f.price f_price, f.trend f_trend, f.mountain f_mountain, f.valley f_valley,f.sendFlg f_sendFlg, fk.sign fk_sign, fk.interest fk_interest, fk.prev_order_location fk_prev_order_location, fs.sign fs_sign, fs.interest fs_interest, fs.prev_order_location fs_prev_order_location, refk.sign refk_sign, refk.interest refk_interest, refk.prev_order_location refk_prev_order_location, mx.sign mx_sign, mx.interest mx_interest, mx.prev_order_location mx_prev_order_location FROM footkey_t f LEFT OUTER JOIN fk_t fk  ON f.fk_id=fk.fk_id LEFT OUTER JOIN fs_t fs  ON f.fk_id=fs.fk_id LEFT OUTER JOIN refk_t refk  ON f.fk_id=refk.fk_id LEFT OUTER JOIN mx_t mx  ON f.fk_id=mx.FK_ID WHERE f.sendFlg = '0'";
}
