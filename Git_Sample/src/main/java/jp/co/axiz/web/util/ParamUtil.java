package jp.co.axiz.web.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.SessionInfo;

/**
 * Utilityメソッドをまとめたクラス
 */
public class ParamUtil {
    /**
     * 引数に指定した文字列がnull、または空文字かを判定
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 引数に指定した文字列が数値に変換できるかを判定
     */
    public static boolean isNumber(String str) {
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
        if (isNumber(str)) {
            return Integer.parseInt(str);
        } else {
            return null;
        }
    }

    /**
     * 引数に指定したセッションオブジェクトから、SessionInfoオブジェクトを取得する。
     * セッションに保存されていない場合は、SessionInfoオブジェクトを新規作成する。
     */
    public static SessionInfo getSessionInfo(HttpSession session) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");

        if (sessionInfo == null) {
            return new SessionInfo();
        } else {
            return sessionInfo;
        }
    }

    /**
     * 第1引数に指定したrole_idに対応するrole_nameを第2引数から検索する。
     * 該当するデータがあればrole_nameを変革する。無ければEmptyを返却する。
     */
    public static String getRoleNameByRoleId(Integer targetRoleId, List<Role> roleList) {
        // ロール名取得
        for (Role role : roleList) {
            if (role.getRoleId() == targetRoleId) {
                return role.getRoleName();
            }
        }

        return "";
    }
}
