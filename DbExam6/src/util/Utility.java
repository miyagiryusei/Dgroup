package util;

/**
 * Utilityメソッドをまとめたクラス
 */
public class Utility {

    /**
     * 引数に指定した文字列がnull、または空文字かを判定
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        // このメソッドは作成済
        if (str == null || str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 引数に指定した文字列が数値に変換できるかを判定
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        // このメソッドは作成済
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    /**
     * 引数に指定した文字列が数値に変換して返却する。
     * 変換できない場合はnullを返却する。
     */
    public static Integer checkAndParseInt(String str) {
        // このメソッドは作成済
        if (isNumber(str)) {
            return Integer.parseInt(str);
        } else {
            return null;
        }
    }

}
