package org.nerve.boot.util;
/*
 * @project cib-kitchen
 * @file    com.nncib.common.util.StringUtil
 * CREATE ON 2022年04月13日 9:13
 * --------------------------------------------------------------
 * 兴业银行南宁分行/信息科技部/曾行明
 *
 * 340416@cib.com.cn    zxingming@cib.com.cn    (0771)5751225
 * --------------------------------------------------------------
 */

public class StringUtil {
    /**
     转半角的函数(DBC case)
     全角空格为12288，半角空格为32
     其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248

     * @param input 任意字符串
     * @return 半角字符串
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                //全角空格为12288，半角空格为32
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                //其他字符半角(33-126)与全角(65281-65374)的对应关系是：均相差65248
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }
}
