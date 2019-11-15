package com.zxx.final_tag;

import android.os.Environment;

/**
 * Created by yfyandr on 2017/9/12.
 */

public  class TagFinal {


    public static String getAppFile(){
        return Environment.getExternalStorageDirectory().toString() + "/yfy/";
    }
    /**
     *   int final tag
     */
    public final static int ZERO_INT = 0;//常量 0
    public final static int ONE_INT = 1;//常量 1
    public final static int TWO_INT = 2;//常量 2
    public final static int THREE_INT = 3;//常量 3
    public final static int FOUR_INT = 4;//常量 4
    public final static int TEN_INT = 10;//常量 10


    public final static int TYPE_FOOTER = ONE_INT;//
    public final static int TYPE_ITEM = TWO_INT;//
    public final static int LOADING = ONE_INT;//
    public final static int LOADING_COMPLETE = TWO_INT;//
    public final static int LOADING_END = THREE_INT;//

    public static final int CAMERA= 1003;//调用摄像头
    public static final int PHOTO_ALBUM = 1004;//调用相册
    public static final int NET_WIFI = 1005;//NET_WIFI
    public static final int CALL_PHONE = 1006;//NET_WIFI
    public static final int UI_TAG = 1101;//tag
    public static final int UI_CONTENT = 1102;//content
    public static final int UI_REFRESH = 1201;//页面刷新
    public static final int UI_ADD = 1202;//进入添加
    public static final int UI_ADMIN = 1203;//审核操作

    public static final int PAGE_NUM = TEN_INT;//常量页码条数
    /**
     *   String final tag
     */
    //基址
    public final static String BASE_URL = "https://www.cdeps.sc.cn/";
    public final static String CHENGDU_SHIYAN = "https://www.cdeps.sc.cn/service2.svc";//成都实验
    public static final String Content_Type = "Content-Type: text/xml;charset=UTF-8";//
    public static final String SOAP_ACTION = "SOAPAction: http://tempuri.org/Service2/";//
    public static final String POST_URI = "/Service2.svc";//
    public static final String NAMESPACE = "http://tempuri.org/";//
    public static final String NET_SOAP_ACTION = "http://tempuri.org/Service2/";
    public static final int TIME_OUT = 10000;
    public final static String WCF_TXT = "wcf.txt";

    public static final int UPLOAD_LIMIT = 100 * 1024;
    public static final long TOTAL_UPLOAD_LIMIT = 4 * 1024 * 1024;
    //app更新地址
    public static final String UPLOAD_URL = "http://www.yfyit.com/apk/cdsyxx.txt";


    public static final String AUTHORITY = "com.example.zhao_sheng.fileProvider";//android 7.0文件访问权限Tag（要和Provider一直）
    public static final String TRUE="true";
    public static final String FALSE="false";
    public static final String REFRESH="refresh";
    public static final String REFRESH_MORE="refresh_more";
    public static final String MAP_TXT_TAG="map_txt";
    public static final String MAP_PIC_TAG="map_pic";
    public static final String ALBUM_LIST_INDEX="index";
    public static final String ALBUM_SINGLE="single";
    public static final String ALBUM_TAG="album_tag";
    public static final String ALBUM_SINGE_URI="album_singe_uri";
    public static final String ACTION_INTENT_FILTER="zxx.intent.badge";
    public static final String BADGE="badge";//桌面小红点badge
    public static final String CLASS_BEAN="class_bean";//班级对象tag
    public static final String PRAISE_TAG="praise";
    public static final String DELETE_TAG="delete";
    public static final String OBJECT_TAG="object_tag";
    public static final String ID_TAG="id_tag";
    public static final String NAME_TAG="name_tag";
    public static final String TITLE_TAG="title_tag";
    public static final String CONTENT_TAG="content_tag";
    public static final String HINT_TAG="hint_tag";
    public static final String URI_TAG="uri_tag";

    public static final String TYPE_TAG="type_tag";

    public static final String USER_TYPE_TEA="tea";
    public static final String USER_TYPE_STU="stu";
    public static final String ZXX="zxx";

    /**
     *   //url
     */


    public static final String USER_BASE_DATA="get_stu_baseinfo";//获取个人中心基础数据
    public static final String USER_BASE_UPDATA="set_stu_baseinfo";//设置个人中心基础数据
    public static String SCHEDULE="http://www.cdeps.sc.cn/kcb.aspx?sessionkey=";//教师课程表url+sessionkey
    public static String DEYU_KEY="http://www.cdeps.sc.cn/showdykp.aspx?sessionkey=";//班级评比
    public static final String POINT_PATH="http://www.cdeps.sc.cn/detail.aspx?id=241342";

    public static final String AUTHEN_BMCX="bmcx";//
    public static final String AUTHEN_GET_STU="getstuxx";//获取学生
    public static final String AUTHEN_SET_STU="setstuxx";//设置学生信息
    public static final String USER_GET_TERM = "gettermlistnew";//获取学期
    public static final String GET_CURRENT_TERM = "getCurrentTermnew";//获取当前学期
    public static final String USER_GET_MOBILE = "get_Mobile";//获取电话
    public static final String USER_SET_MOBILE = "set_Mobile";//置电话
    /**
     * -------------------user相关-------------------
     */
    public static final String GETNOTICENUM = "getnoticenum";//小红点
    public static final String READNOTICE="readnotice";//阅读小红点
    public static final String GET_USER_ADMIN="get_user_right";//获取权限
    public static final String USER_ADD_HEAD="addphoto";//用户添加头像
//    private String headpicMethod = "addphoto";
    public static final String USER_LOGOUT="logout";//用户退出登录logout
    public static final String LOGIN="login";//登录
    public static final String LOGSTU= "logstu";//重名学生login
    public static final String GET_DUPLICATION_USER = "user_duplication";//返回重名学生


    public static final String SCHOOL_GET_NEWS_LIST = "getnewslist";//公告


    /**
     * -------------------vote-------------------------------
     */
    public static final String VOTE_MAIN_LIST = "getvotelist";//组列表信息
    /**
     * -------------------e_book-------------------------------
     */
    public static final String BOOK_GET_TAG = "get_book_tag";//获取
    public static final String VIDEO_GET_TAG = "get_video_tag";//获取
    /**
     * ----------------notice----------------------
     */
    public final static String NOTICE_RECEIVE_LIST = "receive_notice_list";//获取 notice 信息列表
    public final static String NOTICE_SEND_BOX_LIST = "send_notice_list";// notice 发件箱消息列表
    public final static String NOTICE_SEND = "send_notice";// notice 发送消息
    public final static String NOTICE_GET_READSTATE = "get_notice_readstate";// notice 消息回执
    public final static String NOTICE_READ = "read_notice";// notice 标记已读notice

    public final static String NOTICE_GET_TEA = "get_contacts_tea";// notice 获取联系人tea
    public final static String NOTICE_GET_STU = "get_contacts_stu";// notice 获取联系人stu
    public final static String NOTICE_GET_CONTENT = "get_notice_content";// notice 消息内容（图片）


    /**
     * -----------------------shape----------------------
     */
    public final static String SHAPE_MAIN_LIST= "WB_get_class";//获取shape首页列表
    public final static String SHAPE_DID_PRAISE= "WB_did_praise";//为Item praise
    public final static String SHAPE_DID_DELETE= "WB_delete";//删除 Item
    public final static String SHAPE_DID_ADD= "WB_add";//新增 Item
    public final static String SHAPE_DID_DELETE_REPLY= "WB_delete_reply";//删除 Item 的回复
    public final static String SHAPE_GET_TAG= "WB_get_tag";//获取tag
    public final static String SHAPE_DID_REPLY= "WB_did_reply";//回复 WB_did_reply
    public final static String SHAPE_PERSON_DETAIL= "WB_person_detail";//个人详情
    public final static String SHAPE_PERSON_GET_CLASS= "WB_person_get_class";//个人详情

    /**
     * -----------------------个人成果---------------------------
     * （学生自己上串）
     */
    public final static String HONOR_ADD = "add_reward";//个人添加个人成果
    public final static String HONOR_GET_STU_REWARD = "get_stu_reward";//获取学生个人成果列表
    public final static String HONOR_DELETE_ONE_REWARD = "del_reward";//delete单条个人成果
    public final static String HONOR_TYPE="get_rewardtype";//个人成果荣誉类型
    public final static String HONOR_RANK="get_rewardrank";//个人成果荣誉等级（省，市区）

    /**
     * ---------------------------流程报修-----------
     */
    public final static String MAINTIAN_ADD= "addMaintainnewsyxx";//新增报修
    public final static String MAINNEW_GET_MAIN_LIST_USER = "get_Maintain_usersyxx";//获取首页列表普通用户dealstate;//user：0; admin:-1
    public final static String MAINNEW_GET_MAIN_LIST_ADMIN = "get_Maintain_adminsyxx";//获取首页列表管理用户
    public final static String MAINNEW_DELETE_MAINTAIN= "delete_maintain";//撤销自己申请
    public final static String MAINNEW_SYXX= "setMaintain_syxx";//同意，拒绝， dealstate,//1,完成2，拒绝,3 维修中
    public final static String MAINNEW_SET_TYPE= "setMaintainclassid";//部门转交
    public final static String MAINNEW_GET_TYPE= "getMaintainclass";//获取部门分类
    public final static String MAINNEW_GET_COUNT= "get_maintain_review_count";//获取需要处理次数

    /**
     *  审核列表 attendance_review_list_syxx(string session_key, int userid=0, string key="", int type=0, int status=0, int page, int size)
        自己列表 (string session_key, int type=0, int status=0, int page, int size)
        审核操作 attendance_did_review_syxx(string session_key, string id, string reply, string table_plan, int review_result)

     */
    public final static String ATTENNEW_GET_MAIN_LIST_USER= "attendance_list_syxx";//获取首页列表普通用户
    public final static String ATTENNEW_GET_MAIN_LIST_ADMIN= "attendance_review_list_syxx";//获取首页审核列表
    public final static String ATTENNEW_ADMIN_DO ="attendance_did_review_syxx";//审核操作(同意1，申请2，驳回3，校长4)
    public final static String ATTENNEW_SUBMIT ="attendance_submit1";//新增提交cdpx
    public final static String ATTENNEW_DELETE ="delete_attendance";//撤销申请

    public final static String ATTENNEW_USER_LIST ="attendance_approve";//审核人列表
    public final static String ATTENNEW_TYPE ="attendance_type";//请假type
    public final static String ATTENNEW_ADMIN_COUNT ="get_attendance_review_count";//审核操作数量







    /**
     * ------------------------学生奖励---------------------
     * (只能老师发放)
     *   get_tea_course (string session_key,int termid)//
        get_tea_award(string session_key, int classid, int courseid, int termid, int page, int size)//
     */

    public final static String  AWARD_TEA_CLASS_LIST= "get_tea_course";//老师进入查看时班级列表
    public final static String  AWARD_CLASS_AWARD_DETAIL= "get_class_award";//老师进入班级详情列表
    public final static String  AWARD_GET_COURSE= "get_tea_award_self";//管理学生列表(添加学生奖励时选择学科后的学生列表)
    public final static String  AWARD_DEL_UTIL= "del_award_students";//取消学科优生
    public final static String  AWARD_ADD_UTIL= "set_award_students";//添加学生奖励

    public final static String AWARD_STU_CLASS_LIST= "get_stu_award";//学生进入学科优生
    public final static String AWARD_STU_GET_INFO="award_student_info_stu";//学生看自己

    public final static String AWARD_TEA_GET_STU_INFO="award_student_info";//老师看学生

    public final static String AWARD_TEA_ADD = "send_award";//老师发放奖励
    public final static String AWARD_STU_ADD = "send_stu_award";//学生上传奖励
    public final static String get_award_students="get_award_students";//
    public final static String AWARD_GET_TYPE="get_award_type";//

    /**
     * ---------------------------功能室申请------------
     */
    public final static String Order_User_Detsail="my_funcRoom";//我的记录-1 全部 5 已结束
    public final static String ORDER_ADMIN_RECORD="review_funcRoom_record";//审核记录 list
    public final static String ORDER_LOGISTICS_LIST="logistics_funcRoom";//后勤处理列表

    public final static String ORDER_GET_DETAIL="get_funcRoom_detail";//单条详情
    public final static String ORDER_GET_ROOM_NAME="get_funcRoom_name";//获取功能室名称
    public final static String ORDER_GET_COUNT="review_funcRoom_count";//个数
    public final static String ORDER_GET_GRADE="get_funcRoom_type";//获取预约等级
    public final static String ORDER_QUERY="query_funcRoom";//查功能室状态
    public final static String ORDER_ADMIN_LIST="review_funcRoom_list";//审核记录 0,
    public final static String ORDER_SUBMIT="submit_funcRoomnew";//提交
    public final static String ORDER_AUDIT="review_funcRoom";//审核接口：2拒绝1同意
    public final static String ORDER_SET_SCORE="set_funcRoom_score";//打分 islogistics(0不打，1打), logisticsscore, logisticscontent,
    public final static String MERO_SON_CONTENT="review_funcRoom_content";


    /**
     * ---------------------------教师平车------------------
     */

    public final static String TEA_JUDGE_STATISTICS_CLASS="get_teacher_judge_statistics_class";//获取统计考评类型
    public final static String TEA_JUDGE_CLASS="get_teacher_judge_class";//获取添加考评类型
    public final static String TEA_JUDGE_YEAR="get_teacher_judge_year";//获取考评年份。
    public final static String TEA_ADD_PARAMETER="get_teacher_judge_parameter";//获取添加考评参数(无响应)
    public final static String TEA_ADD_JUDGE="add_teacher_judge";//添加考评
    public final static String TEA_DELECTED_PIC="del_teacher_judge_image";//删除考评附件
    public final static String TEA_JUDGE_STATISTICS="get_teacher_judge_statistics";//获取考评统计数据
    public final static String TEA_JUDGE_LIST="get_teacher_judge_record_list";//获取某一年单项获奖记录列表
    public final static String TEA_JUDGE_INFO="get_teacher_judge_info";//获取单个考评的详细内容 (not)
    public final static String TEA_DELETE_JUDGE="del_teacher_judge_list";//del item


    /**
     * -----------------文化物品申领----------------
     */
    public final static String GOODS_ADMIN_COUNT="get_office_supply_review_count";//获取需要审核的个数
    public final static String GOODS_MASTER_COUNT="get_office_supply_master_count";//获取需要审核的个数
    public final static String GOODS_GET_USER="get_office_supply_user";//我的申领记录
    public final static String GOODS_GET_ADMIN="get_office_supply_admin";//管理审核申领记录
    public final static String GOODS_DELETE_ITEM="delete_office_supply";//撤销申请
    public final static String GOODS_ITEM_DETAILS="get_office_supply_content";//单条申领详情
    public final static String GOODS_ADMIN="set_office_supply";//申请审核（管理/校长）
    public final static String GOODS_SEARCH="search_office_supply_classify";//搜索物品分类
    public final static String GOODS_TYPE_GET="get_office_supply_type";//获取物品分类
    public final static String GOODS_ADD="add_office_supply";//添加申领物品(日常添加masterid传0新增传接口get_office_supply_master)
    public final static String GOODS_ADD_TYPE="add_office_supply_goods";//添加物品
    public final static String GOODS_MASTER_USER="get_office_supply_master";//获取审核新物品校长列表
    public final static String GOODS_MASTER_LIST="get_office_supply_bymaster";//获取待审核的物品列表


    /**
     * ---------------------duty-----------------------------
     */

    public final static String DUTY_GET_PLANE="get_dutyreport_plane";//duty add 选日期
//    public final static String DUTY_GETADMIN_PLANE="get_dutyreport_planeadmin";//duty add  admin 选日期
    public final static String DUTY_GET_ADD_DETAILS="get_dutyreport_mydetail";//duty get add  details 获取值周操作信息
//    public final static String DUTY_GETADMIN_ADD_DETAILS="get_dutyreport_admindetail";//duty get admin add  details
    public final static String DUTY_ADD="add_dutyreport";//增加或修改记录
    public final static String DUTY_CHANGE="set_dutyreport_plane";//临调设置
    public final static String DUTY_TYPE="get_dutyreport_type";//"校级行政值周", "中层行政值周

    public final static String DUTY_GET_USER="get_dutyreport_list";//获取记录
    public final static String DUTY_DEL_IMAGE="del_dutyreport_image";//删除值周图片接口，和以前删除一样

    public final static String USER_GET_WEEK_ALL="get_termweek_all";//所有学期，周列表
    public final static String USER_GET_TERM_WEEK="get_termweek_byterm";//指定学期周列表
}

