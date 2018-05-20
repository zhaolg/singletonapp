package com.zhaolg5.singleton.userinfo.bean;

/**
 * Created by zhaolg on 2018/5/17
 *
 * @return
 * @throws Exception
 */
public class Constant {

    /**
     * 个人标签类型
     */
    public  static final String TAG_TYPE = "TAG_TYPE";

    public interface TagType{

        /**
         * 运动
         */
        public static final String TAG_TYPE_SPORT = "TAG_TYPE_SPORT";

        /**
         * 音乐
         */
        public static final String TAG_TYPE_MUSIC = "TAG_TYPE_MUSIC";

        /**
         * 食物
         */
        public static final String TAG_TYPE_FOOD = "TAG_TYPE_FOOD";

        /**
         * 书籍
         */
        public static final String TAG_TYPE_BOOK = "TAG_TYPE_BOOK";

        /**
         * 旅行
         */
        public static final String TAG_TYPE_TRAVEL = "TAG_TYPE_TRAVEL";

        /**
         * 电影
         */
        public static final String TAG_TYPE_MOVIE = "TAG_TYPE_MOVIE";

    }


    public interface USER_STATE{

        /**
         * 有效
         */
        public static final String USER_STATE_VALID = "U";

        /**
         * 无效
         */
        public static final String USER_STATE_INVALID = "E";

        /**
         * 初始化完成 基本资料无录入
         */
        public static final String USER_STATE_INIT = "I";

    }

    /**
     * 全局变量
     */
    public static final String IMAGE_GLOBALDATA = "https://www.zhaolg5.com/singleton/image";




}
