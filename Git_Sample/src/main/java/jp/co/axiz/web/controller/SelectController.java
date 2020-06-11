package jp.co.axiz.web.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.form.SelectForm;
import jp.co.axiz.web.service.UserInfoService;

/*
 * 検索画面コントローラ
 */
@Controller
public class SelectController {

    /*
     * messages_ja.propertiesのメッセージ取得用
     */
    @Autowired
    MessageSource messageSource;

    /*
     * ユーザ情報サービス
     */
    @Autowired
    private UserInfoService userInfoService;

    /*
     * 検索画面表示
     */
    @RequestMapping("/select")
    public String select(@ModelAttribute("selectForm") SelectForm form, Model model) {
        return "select";
    }

    /*
     * 検索結果画面表示 (検索画面の検索ボタン押下時)
     */
    @RequestMapping(value = "/list")
    public String list(@Validated @ModelAttribute("selectForm") SelectForm form, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "select";
        }

        // 検索条件をEntityにセット
        UserInfo condition = new UserInfo(
                null, null,
                form.getUserName(),
                form.getTel(),
                null, null);

        // 検索処理
        List<UserInfo> resultList = userInfoService.find(condition);

        if (resultList.isEmpty()) {
            // 検索結果が無い場合
            String errMsg = messageSource.getMessage("select.error", null, Locale.getDefault());
            model.addAttribute("errMsg", errMsg);
            return "select";
        } else {
            // 検索結果がある場合
            model.addAttribute("userlist", resultList);
            return "selectResult";
        }
    }
}
