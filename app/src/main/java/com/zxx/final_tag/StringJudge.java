package com.zxx.final_tag;

import android.os.Bundle;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 封装判断是否为 空
 */
public class StringJudge {



    public static String listToString(List<String> datas) {
        StringBuilder sb=new StringBuilder();
        for (String h:datas){
            sb.append(h).append(",");
        }
        if (sb.length()>2){
            return sb.substring(0,sb.length()-1);
        }
        return "";
    }
    public static List<String> stringToList(String data) {
        return Arrays.asList(data.split(","));
    }

    public static String[] arraysToList(List<String> list){
        String[] se=new String[list.size()];
        return list.toArray(se);
    }



    public static boolean isContainsKey(Bundle b, String tag) {
        if (b != null) {
            if (b.containsKey(tag)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断一个对象是否为空
     */
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个对象是否不为空
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }


    /**
     * 判断是否为空字符串
     */
    public static boolean isEmpty(CharSequence str) {
        if (str == null) {
            return true;
        }
        if (str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否不为空字符串
     */
    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    /**
     * 判断是否为空集合
     */
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否不为空集合
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 比较
     */
    public static boolean equals(Object text1, Object text2) {
        if (text1 == null || text2 == null) {
            return false;
        }
        return TextUtils.equals(text1.toString(), text2.toString());
    }

    public static boolean isSuccess(Gson gson, String str){
        if (isEmpty(str)){
            return false;
        }else{
            if (str.equals(TagFinal.TRUE)){
                return true;
            }
            if (str.equals(TagFinal.FALSE)){
                return false;
            }
            Ru ru=gson.fromJson(str,Ru.class);
            if (ru.getResult().equals(TagFinal.TRUE)){
                return true;
            }
            return false;
        }
    }

    class Ru{
        /**
         * result : true
         * error_code :
         */
        private String result;
        private String error_code;

        public void setResult(String result) {
            this.result = result;
        }

        public void setError_code(String error_code) {
            this.error_code = error_code;
        }

        public String getResult() {
            return result;
        }

        public String getError_code() {
            return error_code;
        }
    }
}
